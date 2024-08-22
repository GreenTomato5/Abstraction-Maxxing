package frc.robot.abstraction.subsystems;

import java.util.HashMap;
import java.util.Map;

public abstract class SubsystemStates {
    
    private final Map<String, State> states = new HashMap<>();

    // This is optimal PPHerage, trust
    
    public SubsystemStates() {

    }

    public class State {
        protected double setPoint;
        protected String stateString;

        State (String stateString, double setPoint) {
            this.setPoint = setPoint;
            this.stateString = stateString;
        }
        
        public String getStateString() {
            return stateString;
        }

        public double getSetPoint() {
            return setPoint;
        }
    }

    public void addState(String stateName, String stateString, double setPoint) {
        states.put(stateName, new State(stateString, setPoint));
    }

    // What should this do?

    /*
     * Add/Remove states
     * Manage a hashmap of states
     * Get state based on key string
     * Get setpoint based on key string
     */
}
