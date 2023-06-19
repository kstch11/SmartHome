package households.people;

import house.Room;
import house.devices.Device;
import house.devices.states.BrokenState;
import report.EventReport;

import java.util.List;
import java.util.Random;

public class Adult extends Person {

    public Adult(String name, int age, Room currentRoom) {
        super(name, age, currentRoom);
    }

    @Override
    public void saySomething() {
        List<String> phrases = List.of("I want to sleep", "Damn, the salary is coming only in two weeks!", "I want somebody did my work instead of me...", "...");
        EventReport.generateEventReport(phrases.get(new Random().nextInt(phrases.size())));
    }

    @Override
    public Type getType() {
        return Type.ADULT;
    }

    @Override
    public boolean brokenDeviceAfterUse(Device device) {
        int currentProbability = new Random().nextInt(100);

        int PROBABILITY_TO_BREAK = 7;
        if (currentProbability < PROBABILITY_TO_BREAK) {
            device.setState(new BrokenState(device));
            return false;
        }

        return true;
    }

    @Override
    public void brokenReport(Device device) {
        EventReport.generateEventReport("Oops! I hope nobody notice that I broke it");
        EventReport.generateEventReport(this.getName() + " has broken " + device.getDeviceType());
    }
}
