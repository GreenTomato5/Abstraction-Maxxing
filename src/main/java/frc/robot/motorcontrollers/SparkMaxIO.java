package frc.robot.motorcontrollers;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;

import java.util.function.DoubleSupplier;

import com.revrobotics.CANSparkLowLevel.MotorType;

import frc.robot.interfaces.MotorControllerIO;

public class SparkMaxIO implements MotorControllerIO {
    CANSparkMax motor;
    RelativeEncoder encoder;

    // TODO: Spark Utils
    public SparkMaxIO(int motorId, MotorType motorType) {
        motor = new CANSparkMax(motorId, motorType);
        encoder = motor.getEncoder();
        
        encoder.setPositionConversionFactor(2 * Math.PI);
        encoder.setVelocityConversionFactor(1/60);
    }

    public DoubleSupplier getSpeedRPS() {
        return () -> encoder.getVelocity();
    }

    public DoubleSupplier getPositionRad() {
        return () -> encoder.getPosition();
    }

    public void setSpeed(double speed) {
        motor.set(speed);
    }

    public void setVolts(double volts) {
        motor.setVoltage(volts);
    }
}
