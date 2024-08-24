package frc.robot.abstraction.subsystems.arm;

import java.util.Map;

import frc.robot.Constants;
import frc.robot.Utils.MotorConfigs;
import frc.robot.abstraction.subsystems.State;
import frc.robot.abstraction.subsystems.Subsystem;

public class Arm extends Subsystem {
    /*
     * This subsystem is for a single DOF arm that can pivor up and down.
     * If you have a weird arm that has more than 1 DOF too bad so sad.
     */
    protected int numMotors;
    protected ArmIO io;

    public Arm(String subsystemName, State defaultState, ArmIO io, Map<String, MotorConfigs> followerConfigs) {
        super(subsystemName, defaultState);
        
        this.io = io;

        for(String motorName : followerConfigs.keySet()) {
            MotorConfigs configs = followerConfigs.get(motorName);
            io.addFollower(motorName, configs.getMotorID(), configs.getInverted());
        }
    }

    public void configurePID(double kP, double kI, double kD) {
        io.configurePID(kP, kI, kD);
    }

    @Override
    public void runState() {
        io.setPoistion(getState().getSetPoint());
    }

    public void stop() {
        io.stop();
    }

    // I realized run state is kinda useless again >:( because like timeslice is good
    @Override
    public void periodic() {
        super.periodic();
        
        runState();
    }
}
