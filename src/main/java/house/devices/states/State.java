package house.devices.states;

import house.devices.Device;

/**
 *Class representing device state.
 */
public interface State {

    void setDevice(Device device);

    Type getStateType();

    enum Type {
        IDLE,

        BROKEN,

        IN_USE,

        FIXING
    }
}
