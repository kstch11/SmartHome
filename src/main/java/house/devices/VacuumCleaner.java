package house.devices;

import house.Room;

public class VacuumCleaner extends ElectronicDevice {

    public VacuumCleaner(Room currentRoom) {
        super(Type.VACUUM_CLEANER, 6, 3, currentRoom);
    }

    @Override
    public int getIdleConsumption() {
        return 0;
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
        return 1;
    }
}
