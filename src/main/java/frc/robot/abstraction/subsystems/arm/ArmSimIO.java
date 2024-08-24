package frc.robot.abstraction.subsystems.arm;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.simulation.SingleJointedArmSim;

public class ArmSimIO implements ArmIO{
    SingleJointedArmSim sim;
    PIDController controller;

    public ArmSimIO(SingleJointedArmSim sim) {
        // IDC this is easier
        this.sim = sim;
        this.sim.update(0.02);
        this.controller.setPID(0, 0, 0);
    }

    public void setPosition(Double setPointRads) {
        sim.setInputVoltage(controller.calculate(sim.getAngleRads(), setPointRads));
    }

    public void stop() {
        sim.setInputVoltage(0);
    }

    public void setVolts(double volts) {
        sim.setInputVoltage(volts);
    }

    public void addFollower(String followerName, int followerID, boolean invertFollower) {
        return;
    }
}
