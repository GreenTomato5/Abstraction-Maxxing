package frc.robot.abstraction.supersystems;

import java.util.HashMap;
import java.util.Map;

import frc.robot.abstraction.subsystems.State;
import frc.robot.abstraction.subsystems.Subsystem;

public class Manager {
    /*
     * Should be able to add subsystems
     * Add Triggers
     * Add states
     */

    Map<String, Subsystem> subsystems;
    State state;

    public Manager() {
        subsystems = new HashMap<>();
    }

    public void addSubsystem(Subsystem subsystem) {
        subsystems.put(subsystem.getName(), subsystem);
    }
}
