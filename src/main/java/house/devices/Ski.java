package house.devices;

import house.Room;

public class Ski extends SportDevice {
    public Ski(Room currentRoom) {
        super(Type.SKI, 3, 1, currentRoom);
    }
}
