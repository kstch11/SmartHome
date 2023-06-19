import config.HouseContext;
import config.HouseService;
import factories.DeviceFactory;
import factories.HouseholdFactory;
import house.Floor;
import house.House;
import house.Room;
import house.devices.Device;
import households.Household;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class House2 {
    public static void main(String[] args) throws IOException {
        DeviceFactory deviceFactory = DeviceFactory.getInstance();
        HouseholdFactory householdFactory = HouseholdFactory.getInstance();

        // 1st floor
        var garage = new Room("Garage");
        var kitchen = new Room("Kitchen");
        var livingRoom = new Room("Living room");
        var petsRoom = new Room("Pets' room");
        var bathroom1 = new Room("Bathroom1");
        var guestroom = new Room("Guestroom");
        deviceFactory.create(Device.Type.BICYCLE, garage);
        deviceFactory.create(Device.Type.CAR, garage);
        deviceFactory.create(Device.Type.SKI, garage);
        deviceFactory.create(Device.Type.FRIDGE, kitchen);
        deviceFactory.create(Device.Type.COOKER, kitchen);
        deviceFactory.create(Device.Type.TV, kitchen);
        deviceFactory.create(Device.Type.PET_TOY, livingRoom);
        deviceFactory.create(Device.Type.TV, livingRoom);
        deviceFactory.create(Device.Type.PET_TOY, petsRoom);
        deviceFactory.create(Device.Type.PET_TOY, petsRoom);
        deviceFactory.create(Device.Type.PET_FEEDER, petsRoom);
        deviceFactory.create(Device.Type.PET_FEEDER, petsRoom);
        deviceFactory.create(Device.Type.VACUUM_CLEANER, bathroom1);
        deviceFactory.create(Device.Type.SMART_BATH, bathroom1);
        deviceFactory.create(Device.Type.TREADMILL, guestroom);
        deviceFactory.create(Device.Type.TV, guestroom);

        var floor1 = new Floor("First", List.of(garage, kitchen, livingRoom, petsRoom, bathroom1, guestroom));

        // 2nd floor
        var childrenBedroom = new Room("Children's bedroom");
        var parentsBedroom = new Room("Parents' bedroom");
        var bathroom2 = new Room("Bathroom2");
        var grandparentsBedroom = new Room("Grandparents' bedroom");
        deviceFactory.create(Device.Type.COMPUTER, childrenBedroom);
        deviceFactory.create(Device.Type.VACUUM_CLEANER, childrenBedroom);
        deviceFactory.create(Device.Type.BICYCLE, childrenBedroom);
        deviceFactory.create(Device.Type.TREADMILL, parentsBedroom);
        deviceFactory.create(Device.Type.TV, parentsBedroom);
        deviceFactory.create(Device.Type.VACUUM_CLEANER, parentsBedroom);
        deviceFactory.create(Device.Type.SMART_BATH, bathroom2);
        deviceFactory.create(Device.Type.VACUUM_CLEANER, bathroom2);
        deviceFactory.create(Device.Type.TV, grandparentsBedroom);
        deviceFactory.create(Device.Type.PET_TOY, bathroom2);

        var floor2 = new Floor("Second", List.of(childrenBedroom, childrenBedroom, bathroom2, grandparentsBedroom));

        // people
        householdFactory.create(Household.Type.ADULT, "Mom", 40, kitchen);
        householdFactory.create(Household.Type.ADULT, "Dad", 40, parentsBedroom);
        householdFactory.create(Household.Type.ADULT, "Granny", 68, grandparentsBedroom);
        householdFactory.create(Household.Type.ADULT, "Grandpa", 71, livingRoom);
        householdFactory.create(Household.Type.CHILD, "Kate", 9, childrenBedroom);
        householdFactory.create(Household.Type.CHILD, "Tom", 7, petsRoom);
        householdFactory.create(Household.Type.CHILD, "Fillip", 11, petsRoom);


        //animals
        householdFactory.create(Household.Type.CAT, "Murzik", 3, petsRoom);
        householdFactory.create(Household.Type.CAT, "Murka", 1, petsRoom);
        householdFactory.create(Household.Type.DOG, "Bobik", 2, livingRoom);
        householdFactory.create(Household.Type.LIZARD, "Lizard", 1, petsRoom);


        var house = House.builder()
                .setHouseName("13 South Trenton Street")
                .setHouseParts(new ArrayList<>(List.of(floor1, floor2)))
                .setPeople(householdFactory.getPeople())
                .setAnimals(householdFactory.getAnimals())
                .setDevices(deviceFactory.getDevices())
                .build();


        var context = HouseContext.getInstance();

        var service = new HouseService(context, house);
        service.execute();

    }
}
