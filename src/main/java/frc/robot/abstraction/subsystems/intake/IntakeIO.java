package frc.robot.abstraction.subsystems.intake;

public interface IntakeIO {
    public default void addFollower(String followerName, int followerID, boolean invertFollower) {}

    public default void stop() {}

    public default void setVelocityRPS(double setPointRPS) {}

    public default void setVolts(double volts) {}

    public default void configurePID(double kP, double kI, double kD) {}
}
