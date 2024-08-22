package frc.robot.abstraction.actuators;

import java.util.function.DoubleSupplier;

public interface MotorIO {
    public default DoubleSupplier getSpeedRPS() {
        return () -> 0.0;
    }

    public default DoubleSupplier getPositionRad() {
        return () -> 0.0;
    }

    public default void setVolts(double volts) {}

    public default void followMotor() {

    }

    public default MotorIO getIO() {
        return new MotorIO() {};
    }
}
