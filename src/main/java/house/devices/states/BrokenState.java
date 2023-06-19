package house.devices.states;

import house.devices.Device;

public class BrokenState implements State{

    private Device device;

    public BrokenState(Device device) {
        this.device = device;
    }

    @Override
    public void setDevice(Device device) {

    }

    @Override
    public Type getStateType() {
        return Type.BROKEN;
    }
}
