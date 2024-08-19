package frc.robot.interfaces;

import java.util.function.DoubleSupplier;

public interface MotorControllerIO {
    public default DoubleSupplier getSpeedRPS() {
        return () -> 0.0;
    }

    public default DoubleSupplier getPositionRad() {
        return () -> 0.0;
    }
    
    // TODO: Change from mystery -1, 1 units
    public default void setSpeed(double speed) {}

    public default void setVolts(double volts) {}
}
