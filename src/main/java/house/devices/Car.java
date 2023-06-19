package house.devices;

import house.Room;

public class Car extends ElectronicDevice {
    public Car(Room currentRoom) {
        super(Type.CAR, 6, 4, currentRoom);
    }

    @Override
    int getIdleConsumption() {
        return 2;
    }

    @Override
    int getBrokenConsumption() {
        return 5;
    }

    @Override
    int getInUseConsumption() {
        return 10;
    }

    @Override
    int getFixingConsumption() {
        return 3;
    }
}
