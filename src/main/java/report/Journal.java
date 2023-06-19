package report;

import house.devices.ElectronicDevice;
import house.devices.states.State;
import households.Household;

import java.io.IOException;

/**
 * Represents journal
 */
public class Journal extends Reporter<Household> {

    private String fillInJournal(Household household) {
        if (household.getCurrentDevice() != null) {
            if (household.getCurrentDevice().getState() == State.Type.IN_USE) {
                return household.getName() + " is using " + household.getCurrentDevice().getDeviceType() + "\n";
            } else if (household.getCurrentDevice().getState() == State.Type.FIXING){
                return household.getName() + " is repairing " + household.getCurrentDevice().getDeviceType() + "\n";
            }
            if (household.getCurrentDevice().isElectronicDevice()) {
                ((ElectronicDevice) household.getCurrentDevice()).consumeElectricity();
            }
        } else if (household.getHouseholdToInteract() != null) {
            if (!household.getHouseholdToInteract().isPerson()) {
                return household.getName() + " is playing with " + household.getHouseholdToInteract().getName() + "\n";
            } else {
                return household.getName() + " is talking with " + household.getHouseholdToInteract().getName() + "\n";
            }
        }
        return household.getName() + " is waiting for activity\n";
    }

    public void splitJournal(String report) throws IOException {
        journal.write(report);
    }

    @Override
    public void generateReport(Household report) throws IOException {
        journal.write(fillInJournal(report));
        journal.flush();
    }
}
