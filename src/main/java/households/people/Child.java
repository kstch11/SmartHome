package households.people;

import house.Room;
import house.devices.Device;
import house.devices.states.BrokenState;
import report.EventReport;

import java.util.List;
import java.util.Random;

public class Child extends Person {


    public Child(String name, int age, Room currentRoom) {
        super(name, age, currentRoom);
    }

    @Override
    public void saySomething() {
        List<String> phrases = List.of("Mom, where is my phone?", "I wanna eat", "Cringe...", "Dad, where is mom?", "Mom, can I play a computer?");
        EventReport.generateEventReport(phrases.get(new Random().nextInt(phrases.size())));
    }

    @Override
    public Type getType() {
        return Type.CHILD;
    }

    @Override
    public boolean brokenDeviceAfterUse(Device device) {
        int currentProbability = new Random().nextInt(100);

        int PROBABILITY_TO_BREAK = 13;
        if (currentProbability < PROBABILITY_TO_BREAK) {
            device.setState(new BrokenState(device));
            return false;
        }

        return true;
    }

    @Override
    public void brokenReport(Device device) {
        EventReport.generateEventReport("Mooooooom! I think I broke something");
        EventReport.generateEventReport(this.getName() + " has broken " + device.getDeviceType());
    }
}
