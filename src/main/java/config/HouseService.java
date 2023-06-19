package config;

import house.House;
import house.commands.*;
import house.devices.ElectronicDevice;
import house.devices.SportDevice;
import households.Household;
import households.animals.Animal;
import house.RepairTask;
import households.people.Person;
import report.HouseConfigurationReport;
import report.Journal;
import report.UsageReport;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.stream.Stream;

/**
 * Represents a simulation of a house.
 */
public class HouseService {

    private final HouseContext context;
    private int ticksNum;
    private final House house;
    private final OccupationService occupationService;

    private HouseConfigurationReport houseReport = new HouseConfigurationReport();
    private UsageReport usageReport = new UsageReport();

    private Journal journal = new Journal();

    public HouseService(HouseContext context, House house) {
        this.context = context;
        this.house = house;
        this.ticksNum = new Random().nextInt(50, 950);
        this.occupationService = new OccupationService();
    }

    /**
     * Simulate smart home
     * @throws IOException
     */
    public void execute() throws IOException {
        System.out.println("Simulation started");
        houseReport.generateReport(house);
        while (!isZeroTicks()) {
            journal.splitJournal("_____________________ Tick " + ticksNum + " _____________________\n");
            occupationService.removeOccupation();
            sendTickToAllHouseholds();

            ArrayList<Household> households = context.findAllLazyFaggots(house);

            if (!households.isEmpty()) {
                households
                        .forEach(household -> {
                            findSomethingToDo(household);
                        });
            }

            generateReports();
            decreaseTicks();
            context.countElectricity(house);
            if (ticksNum == 0) {
                usageReport.totalElectricityReport(context.getTotalElectricity());
                System.out.println("Simulation ended");
            }

        }
    }

    private boolean isZeroTicks() {
        return ticksNum == 0;
    }

    private void decreaseTicks() {
        if (!isZeroTicks()) {
            ticksNum -= 1;
        }
    }

    /**
     * Generate usage report
     * @throws IOException
     */
    private void generateReports() throws IOException {
        if (ticksNum % 50 == 0 || ticksNum == 1) {
            usageReport.dayReport(ticksNum / 50);
            usageReport.generateReport(house);
            context.resetByDay(house);
        }
    }

    /**
     * Notify all households to update tick
     */
    private void sendTickToAllHouseholds() {
        Stream.concat(house.getAllPeople().stream(), house.getAllAnimals().stream())
                .forEach(household -> {
                    try {
                        household.update();
                        journal.generateReport(household);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });
    }

    /**
     * Find repair or free activity to do
     * @param household do activity
     */
    private void findSomethingToDo(Household household) {
        if (context.containsTasks() && household.isPerson()) {
            if (context.suitableToRepair((Person) household)) {
                RepairTask task = context.popRepairTask();
                household.executeCommand(new FixDeviceCommand((Person) household, task.device()));
            }
        } else {
            if (household.isPerson()) {
                findActivity((Person) household);
            } else {
                findActivity((Animal) household);
            }
        }
    }

    /**
     * Find sport or relax activity for person
     * @param person do activity
     */
    private void findActivity(Person person) {
        boolean doSport = new Random().nextBoolean();
        SportDevice freeDevice;

        if (doSport) {
             freeDevice = context.findSportDevice(house);
            if (freeDevice != null) {
                person.executeCommand(new DoSportCommand(person, freeDevice));
            } else {
                relaxActivity(person);
            }
        } else {
            relaxActivity(person);
        }
    }

    /**
     * Find activity for animal
     * @param animal do activity
     */
    private void findActivity(Animal animal) {
        int spiteOrNotToSpite = new Random().nextInt(5);
        ElectronicDevice freeDevice = context.findDeviceForAnimal(house);

        if (spiteOrNotToSpite < 4 && freeDevice != null) {
            animal.executeCommand(new UseDeviceCommand(animal, freeDevice));
        } else if (spiteOrNotToSpite == 4){
            freeDevice = context.findPersonDeviceForAnimal(house);
            if (freeDevice != null) {
                animal.executeCommand(new UseDeviceCommand(animal, freeDevice));
            }
        } else {
            animal.saySomething();
            animal.doNothing();
        }
    }

    /**
     * Find relax activity for person
     * @param person do activity
     */
    private void relaxActivity(Person person) {
        int relaxActivity = new Random().nextInt(4);
        ElectronicDevice freeDevice = context.findElectronicDevice(house);
        Person freePerson = context.findFreePerson(house);
        Animal freeAnimal = context.findFreeAnimal(house);

        if (relaxActivity < 2 && freeDevice != null) {
            person.executeCommand(new UseDeviceCommand(person, freeDevice));
        } else if (relaxActivity == 2 && freePerson != null) {
            person.executeCommand(new InteractWithCommand(person, freePerson));
        } else if (freeAnimal != null){
            person.executeCommand(new PlayWithCommand(person, freeAnimal));
        } else {
            person.doNothing();
            person.saySomething();
        }
    }


}
