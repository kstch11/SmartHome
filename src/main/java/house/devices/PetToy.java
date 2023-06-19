package house.devices;

import house.Room;

public class PetToy extends ElectronicDevice {

    public PetToy(Room currentRoom) {
        super(Type.PET_TOY, 3, 1, currentRoom);
    }

    @Override
    public int getIdleConsumption() {
        return 1;
    }

    @Override
    public int getBrokenConsumption() {
        return 0;
    }

    @Override
    public int getInUseConsumption() {
        return 2;
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
