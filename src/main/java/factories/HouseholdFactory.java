package factories;

import house.Room;
import households.Household;
import households.animals.Animal;
import households.animals.Cat;
import households.animals.Dog;
import households.animals.Lizard;
import households.people.Adult;
import households.people.Child;
import households.people.Person;

import java.util.ArrayList;

public class HouseholdFactory {

    private static HouseholdFactory instance = null;

    private final ArrayList<Person> people = new ArrayList<>();
    private final ArrayList<Animal> animals = new ArrayList<>();

    public HouseholdFactory() {
    }

    public static HouseholdFactory getInstance() {
        if (instance == null) {
            instance = new HouseholdFactory();
        }
        return instance;
    }

    public Household create(Household.Type type, String name, int age, Room room) throws IllegalArgumentException {
        Household household = switch (type) {
            case ADULT -> new Adult(name, age, room);
            case CHILD -> new Child(name, age, room);
            case CAT -> new Cat(name, age, room);
            case DOG -> new Dog(name, age, room);
            case LIZARD -> new Lizard(name, age, room);
            default -> throw new IllegalArgumentException();
        };

        if (household.isPerson()) {
            people.add((Person) household);
        } else {
            animals.add((Animal) household);
        }
        return null;
    }

    public ArrayList<Person> getPeople() {
        return people;
    }

    public ArrayList<Animal> getAnimals() {
        return animals;
    }
}
