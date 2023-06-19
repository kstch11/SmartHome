package house.devices;

import house.HousePartBase;
import house.Room;
import house.devices.states.IdleState;
import house.devices.states.State;
import report.UsageReport;
import resources.Electricity;

/**
 * Class representing device for sport.
 */
public abstract class SportDevice extends HousePartBase implements Device {

    private final Type deviceType;
    private State state;
    private Room currentRoom;
    private Manual manual;

    private int ticksInUse;
    private int ticksInRepair;
    private int brokenTimes;
    private int usedTimes;

    public SportDevice(Type deviceType, int ticksInUse, int ticksInRepair, Room currentRoom) {
        this.deviceType = deviceType;
        this.state = new IdleState(this);
        this.currentRoom = currentRoom;
        currentRoom.addDevice(this);
        this.ticksInUse = ticksInUse;
        this.ticksInRepair = ticksInRepair;
        this.brokenTimes = 0;
        this.usedTimes = 0;
        this.manual = new Manual();
    }

    @Override
    public Room getCurrentRoom() {
        return currentRoom;
    }

    @Override
    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    @Override
    public int getTicks() throws IllegalArgumentException {
        if (this.getState() == State.Type.IN_USE) {
            return ticksInUse;
        } else if (this.getState() == State.Type.FIXING){
            return ticksInRepair;
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public Manual getManual() {
        return manual;
    }

    @Override
    public State.Type getState() {
        return state.getStateType();
    }

    @Override
    public void setState(State state) {
        this.state = state;
    }

    @Override
    public Type getDeviceType() {
        return deviceType;
    }

    @Override
    public boolean isForAnimal() {
        return false;
    }

    @Override
    public boolean isElectronicDevice() {
        return false;
    }

    @Override
    public int getElectricityConsumption() {
        return 0;
    }

    @Override
    public int brokenTimes() {
        return this.brokenTimes;
    }

    @Override
    public void increaseBrokenTimes() {
        this.brokenTimes += 1;
    }

    @Override
    public void resetBrokenTimes() {
        this.brokenTimes = 0;
    }

    @Override
    public int usedTimes() {
        return usedTimes;
    }

    @Override
    public void increaseUsedTimes() {
        this.usedTimes += 1;
    }

    @Override
    public void resetUsedTimes() {
        this.usedTimes = 0;
    }

    @Override
    public Electricity reportElectricity() {
        return new Electricity(0);
    }

    @Override
    public void resetElectricity() {

    }

    @Override
    public void visit(UsageReport visitor) {
        visitor.visitDevice(this);
    }
}
