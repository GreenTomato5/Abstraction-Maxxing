package frc.robot.abstraction.subsystems.arm;

import edu.wpi.first.math.controller.PIDController;
import frc.robot.abstraction.actuators.MotorGroupIO;

public class ArmRealIO implements ArmIO {

    private MotorGroupIO motorGroup;
    protected PIDController armController;

    public ArmRealIO(MotorGroupIO motorGroup, int numFollwers) {
        this.motorGroup = motorGroup;
        this.armController = new PIDController(0, 0, 0);
    }

    public void setVolts(double volts) {
        motorGroup.setVolts(volts);
    }

    public void setPosition(double setPointRads) {
        setVolts(armController.calculate(motorGroup.getLeaderPosRad(), setPointRads));
    }

    public void addFollower(String followerName, int followerID, boolean invertFollower) {
        motorGroup.addFollower(followerName, followerID, invertFollower);

    }

    public void configurePID(double kP, double kI, double kD) {
        armController.setPID(kP, kI, kD);
    }

    public void stop() {
        motorGroup.setVolts(0);
    }
    
}
