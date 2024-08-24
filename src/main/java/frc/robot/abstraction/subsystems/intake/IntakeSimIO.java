package frc.robot.abstraction.subsystems.intake;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.simulation.DCMotorSim;

public class IntakeSimIO {
    DCMotorSim sim;
    PIDController controller;

    public IntakeSimIO(DCMotorSim sim) {
        this.sim = sim;
        this.sim.update(0.02);
        this.controller.setPID(0, 0, 0);
    }

    public void addFollower(String followerName, int followerID, boolean invertFollower) {
        return;
    }

    public void stop() {
        sim.setInputVoltage(0);
    }

    public void setVelocityRPS(double setPointRPS) {
        sim.setInputVoltage(controller.calculate(sim.getAngularVelocityRPM()/60, setPointRPS));
    }

    public void setVolts(double volts) {
        sim.setInputVoltage(volts);
    }

    public void configurePID(double kP, double kI, double kD) {
        controller.setPID(kP, kI, kD);
    }
}
