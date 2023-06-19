package house.devices;

import house.Room;

public class Treadmill extends SportDevice {
    public Treadmill(Room currentRoom) {
        super(Type.TREADMILL, 4, 2, currentRoom);
    }
}
