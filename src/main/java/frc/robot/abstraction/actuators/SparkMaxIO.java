package frc.robot.abstraction.actuators;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;

import java.util.function.DoubleSupplier;

import com.revrobotics.CANSparkLowLevel.MotorType;

public class SparkMaxIO implements MotorIO {
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

    public void setVolts(double volts) {
        motor.setVoltage(volts);
    }
    
    public CANSparkMax getMotor() {
        return motor;
    }

    public void followMotor(SparkMaxIO leader, Boolean inverted) {
        motor.follow(leader.getMotor(), inverted);
    }
}
