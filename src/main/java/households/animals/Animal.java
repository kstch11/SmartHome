package households.animals;

import house.Room;
import house.devices.Device;
import house.devices.ElectronicDevice;
import house.devices.states.BrokenState;
import households.HouseholdBase;
import report.EventReport;
import report.HouseConfigurationReport;

import java.util.Random;

/**
 * Represents an animal
 */
public abstract class Animal extends HouseholdBase {

    public Animal(String name, int age, Room currentRoom) {
        super(name, age, currentRoom);
    }

    @Override
    public abstract void saySomething();

    @Override
    public boolean brokenDeviceAfterUse(Device device) {
        int currentProbability = new Random().nextInt(100);

        int PROBABILITY_TO_BREAK = 15;
        if (currentProbability < PROBABILITY_TO_BREAK) {
            device.setState(new BrokenState(device));
            return false;
        }

        return true;
    }

    /**
     * Randomly breaking person device
     * @param device which was used by an animal
     * @return boolean value if device is broken or not
     */
    public boolean brokenPersonDeviceAfterUse(ElectronicDevice device) {
        int currentProbability = new Random().nextInt(100);

        int PROBABILITY_TO_BREAK_DEVICE = 50;
        if (currentProbability > PROBABILITY_TO_BREAK_DEVICE) {
            device.setState(new BrokenState(device));
            return false;
        }

        return true;
    }

    public void doNothing() {
        EventReport.generateEventReport(this.getName() + " is sleeping");
    }

    @Override
    public boolean isPerson() {
        return false;
    }

    @Override
    public void visit(HouseConfigurationReport visitor) {
        visitor.visitAnimal(this);
    }

    @Override
    public void brokenReport(Device device) {
        EventReport.generateEventReport(this.getName() + " has broken " + device.getDeviceType());
        EventReport.generateEventReport("*pretends it hasn't done that*");
    }
}
