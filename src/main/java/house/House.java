package house;

import house.devices.Device;
import households.animals.Animal;
import households.people.Person;
import resources.Electricity;

import java.util.ArrayList;

/**
 * Class representing a house in th system. It contains floors, rooms, etc (see {@link HousePart}).
 */
public class House {

    private ArrayList<Floor> houseFloors;
    private ArrayList<Person> people;
    private ArrayList<Animal> animals;
    private ArrayList<Device> devices;
    private String houseName;


    public House(ArrayList<Floor> houseFloors, ArrayList<Person> people, ArrayList<Animal> animals, ArrayList<Device> devices, String houseName) {
        this.houseFloors = houseFloors;
        this.people = people;
        this.animals = animals;
        this.devices = devices;
        this.houseName = houseName;
    }

    public ArrayList<Floor> getAllHouseParts() {
        return houseFloors;
    }


    public Electricity reportTotalElectricityConsumption() {
        var totalElectricity = houseFloors.stream()
                .map(floor -> floor.reportElectricity().value())
                .reduce(0, Integer::sum);
        return new Electricity(totalElectricity);
    }

    public ArrayList<Person> getAllPeople() {
        return people;
    }

    public ArrayList<Animal> getAllAnimals() {
        return animals;
    }

    public ArrayList<Device> getAllDevices() {
        return devices;
    }

    public String getHouseName() {
        return houseName;
    }

    public static House.Builder builder() {
        return new Builder();
    }

    /**
     * Builder for {@link House}.
     */
    public static class Builder {
        private String houseName;
        private ArrayList<Floor> houseParts = new ArrayList<>();
        private ArrayList<Person> people = new ArrayList<>();
        private ArrayList<Animal> animals = new ArrayList<>();
        private ArrayList<Device> devices = new ArrayList<>();
        public House build() {
            return new House(houseParts, people, animals, devices, houseName);
        }

        public Builder setHouseName(String houseName) {
            this.houseName = houseName;
            return this;
        }

        public Builder setHouseParts(ArrayList<Floor> houseParts) {
            this.houseParts = houseParts;
            return this;
        }

        public Builder setPeople(ArrayList<Person> people) {
            this.people = people;
            return this;
        }

        public Builder setAnimals(ArrayList<Animal> animals) {
            this.animals = animals;
            return this;
        }

        public Builder setDevices(ArrayList<Device> devices) {
            this.devices = devices;
            return this;
        }
    }
}
