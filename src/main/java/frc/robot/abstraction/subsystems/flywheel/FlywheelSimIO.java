package frc.robot.abstraction.subsystems.flywheel;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.simulation.FlywheelSim;

public class FlywheelSimIO implements FlywheelIO {
    FlywheelSim sim;
    PIDController controller;

    public FlywheelSimIO(FlywheelSim sim) {
        this.sim = sim;
        this.sim.update(0.02);
        this.controller.setPID(0, 0, 0);
    }

    public void addFollower(String followerName, int followerID, boolean invertFollower) {
        return;
    }

    public void stop() {
        sim.setInput(0);
    }

    public void setVelocityRPS(double setPointRPS) {
        sim.setInput(controller.calculate(sim.getAngularVelocityRPM()/60, setPointRPS));
    }

    public void setVolts(double volts) {
        sim.setInput(volts);
    }

    public void configurePID(double kP, double kI, double kD) {
        controller.setPID(kP, kI, kD);
    }


}
