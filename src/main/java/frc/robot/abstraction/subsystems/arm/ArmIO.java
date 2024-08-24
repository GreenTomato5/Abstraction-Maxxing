package frc.robot.abstraction.subsystems.arm;

public interface ArmIO {
    public default void setPosition(Double setPointRads) {}

    public default void addFollower(String followerName, int followerID, boolean invertFollower) {}

    public default void stop() {}

    public default void setPoistion() {}

    public default void setVolts() {}
}
