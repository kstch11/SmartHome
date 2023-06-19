package house.devices;

import house.Room;

public class TV extends ElectronicDevice {

    public TV(Room currentRoom) {
        super(Type.TV, 6, 3, currentRoom);
    }

    @Override
    public int getIdleConsumption() {
        return 4;
    }

    @Override
    public int getBrokenConsumption() {
        return 3;
    }

    @Override
    public int getInUseConsumption() {
        return 10;
    }

    @Override
    public int getFixingConsumption() {
        return 1;
    }
}
