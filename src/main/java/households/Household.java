package households;

import house.Interactable;
import house.Room;
import house.commands.Command;
import house.devices.Device;

/**
 * Represents a household.
 */
public interface Household extends TickSubscriber, Interactable {

    void saySomething();

    /**
     * Changes person's current location
     * @param room where the household moves to
     */
    void moveTo(Room room);

    Room getCurrentLocation();

    int getAge();

    String getName();

    /**
     * Starts new activity
     * @param command - type of activity
     */
    void executeCommand(Command command);

    Type getType();

    @Override
    default InteractableType getInteractableType() {
        return InteractableType.HOUSEHOLD;
    }

    boolean isAvailable();

    void setAvailable(boolean available);

    /**
     * Randomly breaking device
     * @param device which was used by a household
     * @return boolean value if device is broken or not
     */
    boolean brokenDeviceAfterUse(Device device);

    /**
     * Household is doing nothing
     */
    void doNothing();

    void setCurrentDevice(Device currentDevice);

    Device getCurrentDevice();

    void setHouseholdToInteract(Household householdToInteract);

    Household getHouseholdToInteract();

    boolean isPerson();

    void brokenReport(Device device);

    enum Type {
        /**
         * Type representing an adult. Typically, adults can repair devices, do sport, etc.
         */
        ADULT,

        /**
         * Type representing a child. Children can use devices, which sometimes leads to the device damage :).
         */
        CHILD,

        /**
         * Type representing a cat. ....
         */
        CAT,

        /**
         * Type representing a dog.
         */
        DOG,

        /**
         * Type representing a lizard.
         */
        LIZARD
    }
}
