package house.devices;

import house.Room;

public class WashingMachine extends ElectronicDevice {

    public WashingMachine(Room currentRoom) {
        super(Type.WASHING_MACHINE, 5, 3, currentRoom);
    }

    @Override
    public int getIdleConsumption() {
        return 1;
    }

    @Override
    public int getBrokenConsumption() {
        return 2;
    }

    @Override
    public int getInUseConsumption() {
        return 5;
    }

    @Override
    public int getFixingConsumption() {
        return 0;
    }
}
