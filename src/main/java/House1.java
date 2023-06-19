import config.HouseContext;
import config.HouseService;
import factories.DeviceFactory;
import factories.HouseholdFactory;
import house.Floor;
import house.House;
import house.Room;
import house.devices.*;
import households.Household;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class House1 {
    public static void main(String[] args) throws IOException {

        DeviceFactory deviceFactory = DeviceFactory.getInstance();
        HouseholdFactory householdFactory = HouseholdFactory.getInstance();

        // 1st floor
        var garage = new Room("Garage");
        var kitchen = new Room("Kitchen");
        var livingRoom = new Room("Living room");
        var hallway = new Room("Hallway");
        var bathroom1 = new Room("Bathroom1");
        deviceFactory.create(Device.Type.BICYCLE, garage);
        deviceFactory.create(Device.Type.BICYCLE, garage);
        deviceFactory.create(Device.Type.CAR, garage);
        deviceFactory.create(Device.Type.SKI, garage);
        deviceFactory.create(Device.Type.FRIDGE, kitchen);
        deviceFactory.create(Device.Type.COOKER, kitchen);
        deviceFactory.create(Device.Type.PET_TOY, livingRoom);
        deviceFactory.create(Device.Type.TV, livingRoom);
        deviceFactory.create(Device.Type.PET_TOY, livingRoom);
        deviceFactory.create(Device.Type.PET_TOY, hallway);
        deviceFactory.create(Device.Type.PET_FEEDER, hallway);
        deviceFactory.create(Device.Type.VACUUM_CLEANER, bathroom1);

        var floor1 = new Floor("First", List.of(garage, kitchen, livingRoom, hallway, bathroom1));

        // 2nd floor
        var childrenBedroom = new Room("Children's bedroom");
        var parentsBedroom = new Room("Parents' bedroom");
        var bathroom2 = new Room("Bathroom2");
        var guestroom = new Room("Guestroom");
        deviceFactory.create(Device.Type.COMPUTER, childrenBedroom);
        deviceFactory.create(Device.Type.PET_TOY, childrenBedroom);
        deviceFactory.create(Device.Type.PET_FEEDER, childrenBedroom);
        deviceFactory.create(Device.Type.TREADMILL, parentsBedroom);
        deviceFactory.create(Device.Type.TV, parentsBedroom);
        deviceFactory.create(Device.Type.VACUUM_CLEANER, parentsBedroom);
        deviceFactory.create(Device.Type.SMART_BATH, bathroom2);
        deviceFactory.create(Device.Type.COMPUTER, guestroom);
        deviceFactory.create(Device.Type.TV, guestroom);

        var floor2 = new Floor("Second", List.of(childrenBedroom, parentsBedroom, bathroom2, guestroom));

        //3rd floor
        var fitnessRoom = new Room("Fitness room");
        deviceFactory.create(Device.Type.TREADMILL, fitnessRoom);
        deviceFactory.create(Device.Type.BICYCLE, fitnessRoom);

        var floor3 = new Floor("Third", List.of(fitnessRoom));

        // people
        householdFactory.create(Household.Type.ADULT, "Mom", 35, parentsBedroom);
        householdFactory.create(Household.Type.ADULT, "Dad", 38, livingRoom);
        householdFactory.create(Household.Type.ADULT, "Granny", 68, guestroom);
        householdFactory.create(Household.Type.ADULT, "Grandpa", 71, livingRoom);
        householdFactory.create(Household.Type.CHILD, "Judy", 11, childrenBedroom);
        householdFactory.create(Household.Type.CHILD, "Judy", 12, bathroom1);

        //animals
        householdFactory.create(Household.Type.CAT, "Kitty", 3, hallway);
        householdFactory.create(Household.Type.DOG, "Doggy", 4, kitchen);
        householdFactory.create(Household.Type.LIZARD, "Lizard", 1, childrenBedroom);


        var house = House.builder()
                .setHouseName("30 Marsh Court")
                .setHouseParts(new ArrayList<>(List.of(floor1, floor2, floor3)))
                .setPeople(householdFactory.getPeople())
                .setAnimals(householdFactory.getAnimals())
                .setDevices(deviceFactory.getDevices())
                .build();


        var context = HouseContext.getInstance();

        var service = new HouseService(context, house);
        service.execute();
    }
}
