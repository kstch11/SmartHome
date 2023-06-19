package households.animals;

import house.Room;
import report.EventReport;

public class Cat extends Animal {

    public Cat(String name, int age, Room currentRoom) {
        super(name, age, currentRoom);
    }

    @Override
    public void saySomething() {
        EventReport.generateEventReport("Meow");
    }

    @Override
    public Type getType() {
        return Type.CAT;
    }
}
