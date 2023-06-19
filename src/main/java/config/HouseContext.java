package config;

import house.Interactable;
import house.RepairTask;
import house.House;
import house.devices.ElectronicDevice;
import house.devices.SportDevice;
import house.devices.states.State;
import households.Household;
import households.HouseholdBase;
import households.animals.Animal;
import households.people.Person;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class HouseContext {

    private static HouseContext instance = null;
    private final Queue<RepairTask> repairTasks;
    private final Map<Household, Interactable> occupationMap;

    private int totalElectricity;

    private HouseContext() {
        this.repairTasks = new LinkedList<>();
        this.occupationMap = new ConcurrentHashMap<>();
        this.totalElectricity = 0;
    }

    public static HouseContext getInstance() {
        if (instance == null) {
            instance = new HouseContext();
        }
        return instance;
    }

    public boolean suitableToRepair(Person person) {
        return person.getType() == Household.Type.ADULT;
    }

    public Animal findFreeAnimal(House house) {
        return house.getAllAnimals().stream()
                .filter(HouseholdBase::isAvailable)
                .findFirst()
                .orElse(null);
    }

    public Person findFreePerson(House house) {
        return house.getAllPeople().stream()
                .filter(HouseholdBase::isAvailable)
                .findFirst()
                .orElse(null);
    }

    public SportDevice findSportDevice(House house) {
        return (SportDevice) house.getAllDevices().stream()
                .filter(device -> !device.isElectronicDevice()
                && device.getState() == State.Type.IDLE)
                .findFirst()
                .orElse(null);
    }

    public ElectronicDevice findElectronicDevice(House house) {
        return (ElectronicDevice) house.getAllDevices().stream()
                .filter(device -> device.getState() == State.Type.IDLE
                        && device.isElectronicDevice()
                        && !((ElectronicDevice) device).isForAnimal())
                .findFirst()
                .orElse(null);
    }

    public ElectronicDevice findDeviceForAnimal(House house) {
        return (ElectronicDevice) house.getAllDevices().stream()
                .filter(device -> device.getState() == State.Type.IDLE
                        && device.isForAnimal())
                .findFirst()
                .orElse(null);
    }

    public ElectronicDevice findPersonDeviceForAnimal(House house) {
        return (ElectronicDevice) house.getAllDevices().stream()
                .filter(device -> device.getState() == State.Type.IDLE
                        && device.isElectronicDevice()
                        && (((ElectronicDevice) device).getDeviceType() == ElectronicDevice.Type.TV
                                || ((ElectronicDevice) device).getDeviceType() == ElectronicDevice.Type.COMPUTER))
                .findFirst()
                .orElse(null);
    }

    public ArrayList<Household> findAllLazyFaggots(House house) {
        List<Household> people;
        List<Household> animals;
        people = house.getAllPeople().stream()
                .filter(HouseholdBase::isAvailable)
                .collect(Collectors.toList());
        animals = house.getAllAnimals().stream()
                .filter(HouseholdBase::isAvailable)
                .collect(Collectors.toList());
        people.addAll(animals);
        return (ArrayList<Household>) people;
    }

    public void resetByDay(House house) {
        house.getAllDevices().stream().forEach(device -> {
            device.resetBrokenTimes();
            device.resetBrokenTimes();
            device.resetElectricity();
        });
    }

    public void countElectricity(House house) {
        house.getAllDevices().stream()
                .forEach(device -> totalElectricity += device.getElectricityConsumption());
    }

    public int getTotalElectricity() {
        return totalElectricity;
    }

    public RepairTask popRepairTask() {
        return repairTasks.remove();
    }

    public void enqueueRepairTask(RepairTask repairTask) {
        repairTasks.add(repairTask);
    }

    public boolean containsTasks() {
        return !repairTasks.isEmpty();
    }

    public Map<Household, Interactable> getOccupationMap() {
        return occupationMap;
    }
}
