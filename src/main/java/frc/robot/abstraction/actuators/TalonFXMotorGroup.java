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

    public TalonFXMotorGroup(String leaderName, int leaderID, Boolean invertLeader) {
        this.leaderName = leaderName;
        this.leaderID = leaderID;

        motors.put(leaderName, new TalonFX(leaderID));
        leader = motors.get(leaderName);
        leader.setInverted(invertLeader);
    }

    public void setVolts(double volts) {
        leader.setVoltage(volts);
    }

    public void addFollower(String motorName, int motorID, boolean opposeLeader) {
        motors.put(motorName, new TalonFX(motorID));
        motors.get(motorName).setControl(new Follower(leaderID, opposeLeader));
    }
}
