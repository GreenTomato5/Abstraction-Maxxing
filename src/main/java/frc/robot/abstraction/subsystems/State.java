package frc.robot.abstraction.subsystems;

public class State {
    protected double setPoint;
    protected String stateString;

    // Note: Only 1 setpoint per state thing bc subsystems are split up by dof so you should only have 1 setpoint (Unless im missing sumthing)
    // I'm not gona add something hard to do like a 3 DOF arm also so womp womp
    
    public State (String stateString, double setPoint) {
        this.setPoint = setPoint;
        this.stateString = stateString;
    }

    public State (String stateString) {
        this.setPoint = 0;
        this.stateString = stateString;
    }
    
    public String getStateString() {
        return stateString;
    }

    public double getSetPoint() {
        return setPoint;
    }
}


