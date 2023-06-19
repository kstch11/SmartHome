package house.devices;

import house.Room;

public class Cooker extends ElectronicDevice {

    public Cooker( Room currentRoom) {
        super(Type.COOKER, 4, 1, currentRoom);
    }

    @Override
    public int getIdleConsumption() {
        return 0;
    }

    @Override
    public int getBrokenConsumption() {
        return 1;
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
