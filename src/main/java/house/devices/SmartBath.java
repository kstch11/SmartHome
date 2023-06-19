package house.devices;

import house.Room;

public class SmartBath extends ElectronicDevice {

    public SmartBath(Room currentRoom) {
        super(Type.SMART_BATH, 6, 3, currentRoom);
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
