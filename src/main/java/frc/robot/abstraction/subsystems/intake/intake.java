package frc.robot.abstraction.subsystems.intake;

import java.util.Map;

import frc.robot.Utils.MotorConfigs;
import frc.robot.abstraction.subsystems.State;
import frc.robot.abstraction.subsystems.Subsystem;

public class Intake extends Subsystem {
    /*
     * This is for spinny wheels that intake gamepieces, use 
     * the flywheel subsystem for flywheeling thingys
    */

    protected IntakeIO io;
    protected int numMotors;

    public Intake(String subsystemName, State defaultState, IntakeIO io, Map<String, MotorConfigs> followerConfigs) {
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

    public void stop() {
        io.stop();
    }

    @Override
    public void runState() {
        io.setVelocityRPS(getState().getSetPoint());
    }

    @Override
    public void periodic() {
        super.periodic();

        runState();
    }
}
