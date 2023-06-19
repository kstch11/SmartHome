package house.commands;

import households.animals.Animal;
import households.people.Person;
import report.EventReport;

public class PlayWithCommand extends CommandBase {

    private final Person person;
    private final Animal animal;

    public PlayWithCommand(Person person, Animal animal) {
        this.person = person;
        this.animal = animal;
    }

    @Override
    public void execute() {
        EventReport.generateEventReport(person.getName() + " started playing with " + animal.getType());

        var context = getHouseContext();
        person.moveTo(animal.getCurrentLocation());
        person.setAvailable(false);
        person.setHouseholdToInteract(animal);
        animal.setAvailable(false);
        context.getOccupationMap().put(person, animal);
    }
}
