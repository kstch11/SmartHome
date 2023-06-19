package households;

import house.Room;
import house.commands.Command;
import house.devices.Device;
import report.EventReport;
import report.HouseConfigurationReport;
import report.Reportable;

import java.io.IOException;

/**
 * Implementation of {@link Household}
 */
public abstract class HouseholdBase implements Household, Reportable<HouseConfigurationReport> {

    private final String name;
    private final int age;
    private Room currentRoom;
    private boolean isAvailable;

    private Device currentDevice;
    private Household householdToInteract;

    private int currentTickProgress = 0;

    protected final EventReport eventReport = EventReport.getInstance();

    public HouseholdBase(String name, int age, Room currentRoom) {
        this.name = name;
        this.age = age;
        this.currentRoom = currentRoom;
        this.isAvailable = true;
        this.currentDevice = null;
        this.householdToInteract = null;
    }

    @Override
    public void update() throws IOException {
        if (!isAvailable) {
            currentTickProgress += 1;
        }
    }

    @Override
    public int getCurrentProgress() {
        return currentTickProgress;
    }

    @Override
    public void refreshProgress() {
        currentTickProgress = 0;
        setCurrentDevice(null);
        setHouseholdToInteract(null);
    }

    @Override
    public void moveTo(Room room) {
        this.currentRoom = room;
    }

    @Override
    public Room getCurrentLocation() {
        return currentRoom;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean isAvailable() {
        return isAvailable;
    }

    @Override
    public void setAvailable(boolean available) {
        this.isAvailable = available;
    }

    @Override
    public void executeCommand(Command command) {
        if (isAvailable) {
            command.execute();
        }
    }

    @Override
    public int getTicks() {
        return 2;
    }

    @Override
    public Device getCurrentDevice() {
        return currentDevice;
    }

    @Override
    public void setCurrentDevice(Device currentDevice) {
        this.currentDevice = currentDevice;
    }

    @Override
    public Household getHouseholdToInteract() {
        return householdToInteract;
    }

    @Override
    public void setHouseholdToInteract(Household householdToInteract) {
        this.householdToInteract = householdToInteract;
    }

    public void visit(HouseConfigurationReport visitor) {
    }

    @Override
    public abstract void brokenReport(Device device);
}
