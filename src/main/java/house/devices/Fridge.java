package house.devices;

import house.Room;

public class Fridge extends ElectronicDevice {

    public Fridge(Room currentRoom) {
        super(Type.FRIDGE, 2, 2, currentRoom);
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
        return 5;
    }

    @Override
    public int getFixingConsumption() {
        return 0;
    }
}
