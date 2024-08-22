package frc.robot.abstraction.subsystems;

import java.util.HashMap;
import java.util.Map;

public class SubsystemStates {
    
    private final Map<String, State> states = new HashMap<>();
    State state;

    // This is optimal PPHerage, trust
    
    public SubsystemStates(String defaultStateName, State defaultState) {
        this.state = defaultState;
        states.put(defaultStateName, defaultState);
    }

    // State Name is prog facing, state string is mech facing
    public void addState(String stateName, State state) {
        states.put(stateName, state);
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getState() {
        return this.state;
    }

    // What should this do?

    /*
     * Add/Remove states
     * Manage a hashmap of states
     * Get state based on key string
     * Get setpoint based on key string
     */
}
