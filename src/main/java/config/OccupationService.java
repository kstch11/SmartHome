package config;

import house.Interactable;
import house.RepairTask;
import house.devices.Device;
import house.devices.ElectronicDevice;
import house.devices.states.IdleState;
import house.devices.states.State;
import households.Household;
import households.animals.Animal;
import report.EventReport;


/**
 * Service used to remove current occupation of a household and their device/other household.
 */
class OccupationService {


    void removeOccupation() {
        var occupationMap = HouseContext.getInstance().getOccupationMap();
        occupationMap.keySet().forEach(household -> {
            var interractable = occupationMap.get(household);

            if (household.getCurrentProgress() == interractable.getTicks()) {
                removeOccupation(household, interractable);
                probablyBreakDevice(household, interractable);
                occupationMap.remove(household);
            }
        });
    }

    private void removeOccupation(Household household, Interactable interactable) {
        household.setAvailable(true);
        household.refreshProgress();

        if (interactable.getInteractableType() == Interactable.InteractableType.HOUSEHOLD) {
            ((Household) interactable).setAvailable(true);
            ((Household) interactable).refreshProgress();
        } else {
            ((Device) interactable).setState(new IdleState((Device) interactable));
        }
    }

    private void probablyBreakDevice(Household household, Interactable interactable) {
        if (interactable.getInteractableType() == Interactable.InteractableType.DEVICE) {
            var device = (Device) interactable;

            if (!household.isPerson() &&
                    (device.getDeviceType() == Device.Type.TV || device.getDeviceType() == Device.Type.COMPUTER)) {
                ((Animal) household).brokenPersonDeviceAfterUse((ElectronicDevice) device);
            } else {
                household.brokenDeviceAfterUse(device);
            }


            if (device.getState() == State.Type.BROKEN) {
                EventReport.generateEventReport(device.getDeviceType() + " was broken");
                household.brokenReport(device);
                var repairTask = new RepairTask(device);
                device.increaseBrokenTimes();
                HouseContext.getInstance().enqueueRepairTask(repairTask);
            }
        }
    }
}
