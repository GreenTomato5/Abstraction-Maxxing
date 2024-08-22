package frc.robot.abstraction.subsystems.arm;

import frc.robot.abstraction.actuators.MotorIO;

public class ArmRealIO implements ArmIO {

    private MotorIO motor;
    private MotorIO follower;

    public ArmRealIO(MotorIO motor) {
        this.motor = motor;
    }
    
}
