package frc.robot.abstraction.supersystems;

import java.util.HashMap;
import java.util.Map;

import frc.robot.abstraction.subsystems.Subsystem;

public class Manager {
    /*
     * Should be able to add subsystems
     * Add Triggers
     * Add states
     */

    // I feel like im doing something terribly wrong

    private Map<String, Subsystem> subsystems;
    private Map<String, Trigger> transitions;
    private Map<String, ManagerState> states;
    private ManagerState state;
    private ManagerState defaultState;
    // For logging
    private String lastTransition;

    public Manager() {
        this.defaultState = new ManagerState("Placeholder", () -> doNothing());
        this.state = defaultState;
        this.subsystems = new HashMap<>();
        this.lastTransition = "";
    }

    public void addSubsystem(Subsystem subsystem) {
        subsystems.put(subsystem.getName(), subsystem);
    }

    private void doNothing() {
        return;
    }

    // Call this once, idk what happens if you do it multiple times
    public void setDefaultState(ManagerState defaulState) {
        this.defaultState = defaulState;
        state = defaulState;
        state.runRunnable();
    }

    public Subsystem getSubsystem(String subsytemName) {
        return subsystems.get(subsytemName);
    }

    public void addState(ManagerState state) {
        states.put(state.getStateName(), state);
    }

    public ManagerState getState(String stateKey) {
        return states.get(stateKey);
    }
    
    public String getLastTransition() {
        return lastTransition;
    }

    public ManagerState getDefaultState() {
        return defaultState;
    }

    public void addTransition(String transitionName, Trigger trigger) {
        transitions.put(transitionName, trigger);
    }

    private void checkTransitions() {
        // Chat did I cook or am I cooked?
        for (String transitionKey : transitions.keySet()) {
            Trigger transition = transitions.get(transitionKey);
            if (transition.getInitialState() == state.getStateName()) {
                state = transition.getEndState();
                state.runRunnable();
                lastTransition = transitionKey;
            }
        }
    }

    public void periodic() {
        checkTransitions();
    }
}
