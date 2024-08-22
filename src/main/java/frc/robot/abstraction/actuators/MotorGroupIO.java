package frc.robot.abstraction.actuators;

public interface MotorGroupIO {
    public default void setVolts(double volts) {}

    public default void addFollower(String motorName, int motorID, boolean invertMotor) {}

    public default double getLeaderPosRad() {
        return 0.0;
    }
}
