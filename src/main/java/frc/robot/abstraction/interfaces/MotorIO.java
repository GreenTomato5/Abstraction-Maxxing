package frc.robot.abstraction.interfaces;

import java.util.function.DoubleSupplier;

public interface MotorIO {
    public default DoubleSupplier getSpeedRPS() {
        return () -> 0.0;
    }

    public default DoubleSupplier getPositionRad() {
        return () -> 0.0;
    }

    public default void setVolts(double volts) {}
}
