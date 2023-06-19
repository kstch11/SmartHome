package house.commands;

import house.devices.ElectronicDevice;
import house.devices.states.InUseState;
import households.Household;
import report.EventReport;

public class UseDeviceCommand extends CommandBase {

    private final Household household;
    private final ElectronicDevice device;

    public UseDeviceCommand(Household household, ElectronicDevice device) {
        this.household = household;
        this.device = device;
    }

    @Override
    public void execute() {
        EventReport.generateEventReport(household.getName() + " started using " + device.getDeviceType());

        var context = getHouseContext();
        household.moveTo(device.getCurrentRoom());
        household.setAvailable(false);
        household.setCurrentDevice(device);
        device.setState(new InUseState(device));
        device.consumeElectricity();
        device.increaseUsedTimes();
        context.getOccupationMap().put(household, device);
    }
}
