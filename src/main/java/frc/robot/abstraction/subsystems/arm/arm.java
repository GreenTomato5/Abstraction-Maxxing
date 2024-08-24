package frc.robot.abstraction.subsystems.arm;

import java.util.Map;

import frc.robot.Utils.MotorConfigs;
import frc.robot.abstraction.subsystems.Subsystem;
import frc.robot.abstraction.subsystems.SubsystemStates;

public class Arm extends Subsystem {
    /*
     * This subsystem is for a single DOF arm that can pivor up and down.
     * If you have a weird arm that has more than 1 DOF too bad so sad.
     */
    protected int numMotors;
    protected ArmIO io;

    public Arm(ArmIO io, Map<String, MotorConfigs> followerConfigs) {
        this.io = io;

        for(String motorName : followerConfigs.keySet()) {
            MotorConfigs configs = followerConfigs.get(motorName);
            io.addFollower(motorName, configs.getMotorID(), configs.getInverted());
        }
    }

    public void periodic() {
        
    }
}
