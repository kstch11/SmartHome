package house.commands;

import house.devices.Device;
import house.devices.ElectronicDevice;
import house.devices.states.FixingState;
import households.people.Person;
import report.EventReport;

public class FixDeviceCommand extends CommandBase {

    private final Person person;
    private final Device device;

    public FixDeviceCommand(Person person, Device device) {
        this.person = person;
        this.device = device;
    }

    @Override
    public void execute() {
        var context = getHouseContext();
        person.moveTo(device.getCurrentRoom());
        person.setAvailable(false);
        person.setCurrentDevice(device);
        device.setState(new FixingState(device));
        if (device.isElectronicDevice()) {
            ((ElectronicDevice) device).consumeElectricity();
        }
        context.getOccupationMap().put(person, device);

        EventReport.generateEventReport(person.readManual(device));
        EventReport.generateEventReport(person.getName() + " started fixing " + device.getDeviceType());
    }
}