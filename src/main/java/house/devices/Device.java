package house.devices;

import house.HousePart;
import house.Interactable;
import house.Room;
import house.devices.states.State;
import report.Reportable;
import report.UsageReport;

/**
 * Class representing device entity.
 */
public interface Device extends Interactable, HousePart, Reportable<UsageReport> {

    /**
     * Returns current location in the house.
     * @return {@link Room} in which the device is located.
     */
    Room getCurrentRoom();

    /**
     * Put device in the particular room.
     * @param currentRoom - room where the device was put.
     */
    void setCurrentRoom(Room currentRoom);

    /**
     * Changes device's state.
     * @param state - new device state.
     */
    void setState(State state);

    State.Type getState();

    /**
     * Returns device's manual.
     * @return {@link Manual}
     */
    Manual getManual();

    Type getDeviceType();

    @Override
    default InteractableType getInteractableType() {
        return InteractableType.DEVICE;
    }

    boolean isForAnimal();

    boolean isElectronicDevice();

    int getElectricityConsumption();

    int brokenTimes();

    void increaseBrokenTimes();

    void resetBrokenTimes();

    int usedTimes();

    void increaseUsedTimes();

    void resetUsedTimes();

    void visit(UsageReport visitor);

    void resetElectricity();

    enum Type {
        CAR,
        COMPUTER,
        COOKER,
        FRIDGE,
        TV,
        SMART_BATH,
        VACUUM_CLEANER,
        WASHING_MACHINE,
         BICYCLE,
         TREADMILL,
         SKI,
         PET_FEEDER,
         PET_TOY,
    }
}
