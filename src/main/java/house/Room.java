package house;

import house.devices.Device;
import report.HouseConfigurationReport;

import java.util.ArrayList;
import java.util.List;

/**
 * Class representing a room in a house.
 */
public class Room extends HousePartBase implements HouseSpace<HouseConfigurationReport> {

    private final String name;
    private ArrayList<Device> devices;
    private Floor floor;

    public Room(String name) {
        this.name = name;
        devices = new ArrayList<>();
    }

    public Room(String name, Floor floor) {
        this.name = name;
        this.floor = floor;
        devices = new ArrayList<>();
    }

    public String getFloor() {
        return floor.getFloorNumber();
    }

    public String getName() {
        return name;
    }

    @Override
    public List<Device> getChildren() {
        return devices;
    }

    public void addDevice(Device electronicDevice) {
        devices.add(electronicDevice);
    }

    @Override
    public void visit(HouseConfigurationReport visitor) {
        visitor.visitRoom(this);
    }
}
