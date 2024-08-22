package frc.robot.abstraction.actuators;

public interface MotorGroupIO {
    public default void setVolts() {}

    public default void addFollower() {}
}
