package house.devices;

import house.Room;

public class Bicycle extends SportDevice {
    public Bicycle(Room currentRoom) {
        super(Type.BICYCLE, 3, 1, currentRoom);
    }
}
