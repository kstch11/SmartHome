package house.devices.states;

import house.devices.Device;

public class InUseState implements State{

    private Device device;

    public InUseState(Device device) {
        this.device = device;
    }

    @Override
    public void setDevice(Device device) {
        this.device = device;
    }

    @Override
    public Type getStateType() {
        return Type.IN_USE;
    }
}
