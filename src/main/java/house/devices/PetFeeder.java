package house.devices;

import house.Room;

public class PetFeeder extends ElectronicDevice {

    public PetFeeder(Room currentRoom) {
        super(Type.PET_FEEDER, 2, 1, currentRoom);
    }

    @Override
    public int getIdleConsumption() {
        return 1;
    }

    @Override
    public int getBrokenConsumption() {
        return 1;
    }

    @Override
    public int getInUseConsumption() {
        return 3;
    }

    @Override
    public int getFixingConsumption() {
        return 0;
    }

    @Override
    public boolean isForAnimal() {
        return true;
    }
}
