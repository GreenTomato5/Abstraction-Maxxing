package frc.robot.motorcontrollers;

import java.util.function.DoubleSupplier;

import com.ctre.phoenix6.hardware.TalonFX;

import frc.robot.interfaces.MotorControllerIO;

public class TalonFXIO implements MotorControllerIO {
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

    public void setSpeed(double speed) {
        motor.set(speed);
    }

    public void setVolts(double volts) {
        motor.setVoltage(volts);
    }
}
