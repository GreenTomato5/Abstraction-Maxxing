package frc.robot.abstraction.subsystems.intake;

import edu.wpi.first.math.controller.PIDController;
import frc.robot.abstraction.actuators.MotorGroupIO;

public class IntakeRealIO implements IntakeIO {

    protected MotorGroupIO motorGroup;
    protected PIDController controller;
    
    public IntakeRealIO(MotorGroupIO motorGroup) {
        this.motorGroup = motorGroup;
        this.controller.setPID(0, 0, 0);
    }

    public void setVolts(double volts) {
        motorGroup.setVolts(volts);
    }

    public void setVelocityRPS(double setPointRPS) {
        setVolts(controller.calculate(motorGroup.getLeaderPosRad(), setPointRPS));
    }

    public void addFollower(String followerName, int followerID, boolean invertFollower) {
        motorGroup.addFollower(followerName, followerID, invertFollower);

    }

    public void configurePID(double kP, double kI, double kD) {
        controller.setPID(kP, kI, kD);
    }

    public void stop() {
        motorGroup.setVolts(0);
    }
}
