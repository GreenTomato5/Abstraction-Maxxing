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

    Map<String, Subsystem> subsystems;
    Map<String, ManagerState> states;
    ManagerState state;

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

    public void addTransition() {}
}
