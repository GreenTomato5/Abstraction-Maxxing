package frc.robot.abstraction.subsystems.arm;

public interface ArmIO {

    public default void setPosition(Double radians) {}

    public default void stop() {}

    public default double getPositionRads() {
        return 0;
    }
}
