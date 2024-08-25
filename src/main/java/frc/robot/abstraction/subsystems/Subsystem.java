package frc.robot.abstraction.subsystems;

import edu.wpi.first.wpilibj.DriverStation;

public abstract class Subsystem {
    // This is like the turn tuning abstraction but worse

    protected String subsytemName;
    protected State defaultState;
    protected State state;

    public Subsystem(String subsystemName, State defaultState) {
        this.subsytemName = subsystemName;
        this.defaultState = defaultState;
        this.state = this.defaultState;
    }

    public State getDefaultState() {
        return defaultState;
    }

    public void runState() {

    }

    public void periodic() {
        if (!DriverStation.isEnabled()) return;
    
        runState();
    }

    public String getName() {
        return subsytemName;
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }
}
