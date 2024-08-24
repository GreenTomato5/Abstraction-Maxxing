package frc.robot.abstraction.subsystems.arm;

public interface ArmIO {
    public default void setPosition(Double setPointRads) {}

    public default void addFollower(String followerName, int followerID, boolean invertFollower) {}

    public default void stop() {}

    public default void setPoistion(double setPoint) {}

    public default void setVolts(double volts) {}

    public default void configurePID(double kP, double kI, double kD) {}
}
