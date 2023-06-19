package households.people;

import house.Room;
import house.devices.Device;
import households.HouseholdBase;
import report.EventReport;
import report.HouseConfigurationReport;

/**
 * Represents a person.
 */
public abstract class Person extends HouseholdBase {

    public Person(String name, int age, Room currentRoom) {
        super(name, age, currentRoom);
    }

    @Override
    public abstract void saySomething();

    public void doNothing() {
        EventReport.generateEventReport(this.getName() + " is waiting for activity");
    }

    @Override
    public boolean isPerson() {
        return true;
    }

    @Override
    public void visit(HouseConfigurationReport visitor) {
        visitor.visitPerson(this);
    }

    public String readManual(Device device) {
        device.getManual();
        return this.getName() + " read the manual to " + this.getCurrentDevice().getDeviceType();
    }
}
