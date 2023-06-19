package households.animals;

import house.Room;
import report.EventReport;

public class Lizard extends Animal {
    public Lizard(String name, int age, Room currentRoom) {
        super(name, age, currentRoom);
    }

    @Override
    public void saySomething() {
        EventReport.generateEventReport("...");
    }

    @Override
    public Type getType() {
        return Type.LIZARD;
    }
}
