package house.devices;

import house.Room;

public class Computer extends ElectronicDevice {

    public Computer( Room currentRoom) {
        super(Type.COMPUTER, 6, 3, currentRoom);
    }

    @Override
    public int getIdleConsumption() {
        return 2;
    }

    @Override
    public int getBrokenConsumption() {
        return 3;
    }

    @Override
    public int getInUseConsumption() {
        return 7;
    }

    @Override
    public int getFixingConsumption() {
        return 1;
    }
}
