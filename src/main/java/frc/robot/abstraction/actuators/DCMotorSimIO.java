package frc.robot.abstraction.actuators;

import java.util.function.DoubleSupplier;

import edu.wpi.first.math.system.plant.DCMotor;
import edu.wpi.first.wpilibj.simulation.DCMotorSim;
import frc.robot.abstraction.interfaces.ActuatorIO;

public class DCMotorSimIO implements ActuatorIO{
    DCMotorSim sim;

    // TODO: Overload constructor to work with other sim constant things (or just take in a DCMotorSim, crazy idea i know)
    public DCMotorSimIO(DCMotor gearbox, double gearing, double jkgMetersSquared) {
        sim = new DCMotorSim(gearbox, gearing, jkgMetersSquared);
        
        // TODO: Change to whatever decided timeslice alloted to given mechanism
        sim.update(0.02);
    }

    public DoubleSupplier getSpeedRPS() {
        return () -> sim.getAngularVelocityRPM() / 60;
    }

    public DoubleSupplier getPositionRad() {
        return () -> sim.getAngularPositionRad();
    }

    public void setVolts(double volts) {
        sim.setInputVoltage(volts);
    }
}
