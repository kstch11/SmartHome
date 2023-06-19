package house.commands;

import house.devices.SportDevice;
import house.devices.states.InUseState;
import households.people.Person;
import report.EventReport;

public class DoSportCommand extends CommandBase {

    private final Person person;
    private final SportDevice sportDevice;

    public DoSportCommand(Person person, SportDevice sportDevice) {
        this.person = person;
        this.sportDevice = sportDevice;
    }

    @Override
    public void execute() {
        EventReport.generateEventReport(person.getName() + " started using " + sportDevice.getDeviceType());

        var context = getHouseContext();
        person.moveTo(sportDevice.getCurrentRoom());
        person.setAvailable(false);
        person.setCurrentDevice(sportDevice);
        sportDevice.setState(new InUseState(sportDevice));
        sportDevice.increaseUsedTimes();
        context.getOccupationMap().put(person, sportDevice);
    }
}
