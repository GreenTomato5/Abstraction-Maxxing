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

    public Manager() {
        subsystems = new HashMap<>();
    }

    public void addSubsystem(Subsystem subsystem) {
        subsystems.put(subsystem.getName(), subsystem);
    }

    public Subsystem getSubsystem(String subsytemName) {
        return subsystems.get(subsytemName);
    }

    public void addState(ManagerState state) {
        states.put(state.getStateName(), state);
    }

    public void addTransition(String transitionName, Trigger trigger) {
        transitions.put(transitionName, trigger);
    }

    private void checkTransitions() {
        // Chat did I cook or am I cooked?
        for (String transition : transitions.keySet()) {
            if (transitions.get(transition).getInitialState() == state.getStateName()) {
                state = transitions.get(transition).getEndState();
                state.runRunnable();
            }
        }
    }

    public void periodic() {
        checkTransitions();
    }
}
