package report;

import house.Floor;
import house.House;
import house.Room;
import households.animals.Animal;
import households.people.Person;

import java.io.IOException;
import java.util.stream.Collectors;

/**
 * Represents house configuration report
 */
public class HouseConfigurationReport extends Reporter<House> {

    String createReport(House house) {
        System.out.println();
        return "In the house with address " + house.getHouseName() + " there are " + house.getAllHouseParts().size()
                + " floors\n" + house.getAllHouseParts().stream().map(this::visitFloor).collect(Collectors.joining()) + "\n"
                + "\nPeople:\n" + house.getAllPeople().stream().map(this::visitPerson).collect(Collectors.joining())
                + "\nAnimals:\n" + house.getAllAnimals().stream().map(this::visitAnimal).collect(Collectors.joining());
    }


    public String visitFloor(Floor floor) {
         return "\nOn the " + floor.getFloorNumber() + " floor there are " + floor.getAllRooms().size() + " rooms:\n"
                 + floor.getAllRooms().stream().map(this::visitRoom).collect(Collectors.joining("\n"));
    }

    public String visitRoom(Room room) {
        return "In the " + room.getName() + " are:\n"
                + room.getChildren().stream()
                .map(device -> device.getClass().getSimpleName())
                .collect(Collectors.joining(", ")) + "\n";
    }

    public String visitPerson(Person person) {
        return person.getName() + " is " + person.getAge() + " years old\n";
    }

    public String visitAnimal(Animal animal) {
        return animal.getName() + " is " + animal.getAge() + " years old\n";
    }

    @Override
    public void generateReport(House report) throws IOException {
        houseConfigurationReport.write(createReport(report));
        houseConfigurationReport.flush();
        houseConfigurationReport.close();
    }
}
