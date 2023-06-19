package house.devices.states;

import house.devices.Device;

public class IdleState implements State{

    private Device device;

    public IdleState(Device device) {
        this.device = device;
    }

    @Override
    public void setDevice(Device device) {

    }

    @Override
    public Type getStateType() {
        return Type.IDLE;
    }
}
