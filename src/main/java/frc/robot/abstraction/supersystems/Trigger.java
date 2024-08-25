package frc.robot.abstraction.supersystems;

import java.util.function.BooleanSupplier;

public class Trigger {
    String initialState;

    ManagerState endState;
    
    BooleanSupplier triggerer;

    public Trigger(String initialState, ManagerState endState, BooleanSupplier triggerer) {
        this.initialState = initialState;
        this.endState = endState;
    }

    public Boolean isTriggered() {
        return triggerer.getAsBoolean();
    }

    public String getInitialState() {
        return initialState;
    }

    public ManagerState getEndState() {
        return endState;
    }
}
