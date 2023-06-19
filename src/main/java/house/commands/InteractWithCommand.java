package house.commands;

import households.people.Person;
import report.EventReport;

public class InteractWithCommand extends CommandBase {

    private final Person firstPerson;
    private final Person secondPerson;

    public InteractWithCommand(Person firstPerson, Person secondPerson) {
        this.firstPerson = firstPerson;
        this.secondPerson = secondPerson;
    }

    @Override
    public void execute() {
        EventReport.generateEventReport(firstPerson.getName() + " started talking with " + secondPerson.getName());

        var context = getHouseContext();
        firstPerson.moveTo(secondPerson.getCurrentLocation());
        firstPerson.setAvailable(false);
        firstPerson.setHouseholdToInteract(secondPerson);
        secondPerson.setAvailable(false);
        context.getOccupationMap().put(firstPerson, secondPerson);
    }
}
