package frc.robot.abstraction.actuators;

import java.util.function.DoubleSupplier;

import com.ctre.phoenix6.controls.Follower;
import com.ctre.phoenix6.hardware.TalonFX;

public class TalonFXIO implements MotorIO {
    TalonFX motor;

    public TalonFXIO(int motorId) {
        motor = new TalonFX(motorId);
    }

    public DoubleSupplier getSpeedRPS() {
        return () -> motor.getVelocity().getValueAsDouble();
    }

    public DoubleSupplier getPositionRad() {
        return () -> motor.getPosition().getValueAsDouble() * (2 * Math.PI);
    }

    public void setVolts(double volts) {
        motor.setVoltage(volts);
    }

    public void followMotor(int leaderID, Boolean reverseMotor) {
        motor.setControl(new Follower(leaderID, reverseMotor));
    }
}
