package factories;

import house.Room;
import house.devices.*;

import java.util.ArrayList;

public class DeviceFactory {

    private static  DeviceFactory instance = null;

    private final ArrayList<Device> devices = new ArrayList<>();

    public DeviceFactory() {
    }

    public static DeviceFactory getInstance() {
        if (instance == null) {
            instance = new DeviceFactory();
        }
        return instance;
    }

    public Device create(Device.Type type, Room room) {
        Device device = switch (type) {
            case TV -> new TV(room);
            case CAR -> new Car(room);
            case COOKER -> new Cooker(room);
            case FRIDGE -> new Fridge(room);
            case COMPUTER -> new Computer(room);
            case TREADMILL -> new Treadmill(room);
            case SMART_BATH -> new SmartBath(room);
            case VACUUM_CLEANER -> new VacuumCleaner(room);
            case WASHING_MACHINE -> new WashingMachine(room);
            case SKI -> new Ski(room);
            case BICYCLE -> new Bicycle(room);
            case PET_TOY -> new PetToy(room);
            case PET_FEEDER -> new PetFeeder(room);
            default -> throw new IllegalStateException(type + "does not exist");
        };
        devices.add(device);
        return device;
    }

    public ArrayList<Device> getDevices() {
        return devices;
    }
}
