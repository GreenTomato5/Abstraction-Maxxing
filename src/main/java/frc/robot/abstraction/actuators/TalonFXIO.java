package frc.robot.abstraction.actuators;

import java.util.function.DoubleSupplier;

import com.ctre.phoenix6.hardware.TalonFX;

import frc.robot.abstraction.interfaces.ActuatorIO;

public class TalonFXIO implements ActuatorIO {
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
}
