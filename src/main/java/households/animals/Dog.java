package households.animals;

import house.Room;
import report.EventReport;

public class Dog extends Animal {
    public Dog(String name, int age, Room currentRoom) {
        super(name, age, currentRoom);
    }

    @Override
    public void saySomething() {
        EventReport.generateEventReport("Baw");
    }

    @Override
    public Type getType() {
        return Type.DOG;
    }
}
