package frc.robot.abstraction.actuators;

import java.util.HashMap;
import java.util.Map;

import com.ctre.phoenix6.controls.Follower;
import com.ctre.phoenix6.hardware.TalonFX;

public class TalonFXMotorGroup implements MotorGroupIO {
    Map<String, TalonFX> motors = new HashMap<>();
    TalonFX leader;
    String leaderName;
    int leaderID;

    // TODO: Something with CTRE sim or something idrk

    public TalonFXMotorGroup(String leaderName, int leaderID, Boolean invertLeader) {
        this.leaderName = leaderName;
        this.leaderID = leaderID;

        motors.put(leaderName, new TalonFX(leaderID));
        leader = motors.get(leaderName);
        leader.setInverted(invertLeader);
        // Zero Leader
        leader.setPosition(0);
    }

    public void setVolts(double volts) {
        leader.setVoltage(volts);
    }

    public double getLeaderPosRad() {
        return leader.getPosition().getValueAsDouble() * (2 * Math.PI);
    }

    public void addFollower(String motorName, int motorID, boolean invertMotor) {
        motors.put(motorName, new TalonFX(motorID));
        motors.get(motorName).setControl(new Follower(leaderID, invertMotor));
    }
}
