package house.devices.states;

import house.devices.Device;

public class FixingState implements State {

    private Device device;

    public FixingState(Device device) {
        this.device = device;
    }

    @Override
    public void setDevice(Device device) {

    }

    @Override
    public Type getStateType() {
        return Type.FIXING;
    }
}
