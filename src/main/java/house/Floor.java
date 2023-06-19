package house;

import report.HouseConfigurationReport;

import java.util.List;

/**
 * Class representing a floor in a house.
 */
public class Floor extends HousePartBase implements HouseSpace<HouseConfigurationReport> {

    private final String floorNumber;
    private final List<Room> rooms;

    public Floor(String floorNumber, List<Room> rooms) {
        this.floorNumber = floorNumber;
        this.rooms = rooms;
    }

    public String getFloorNumber() {
        return floorNumber;
    }

    public List<Room> getAllRooms() {
        return rooms;
    }

    @Override
    List<Room> getChildren() {
        return rooms;
    }

    @Override
    public void visit(HouseConfigurationReport visitor) {
        visitor.visitFloor(this);
    }
}
