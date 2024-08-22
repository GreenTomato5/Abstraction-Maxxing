package frc.robot.abstraction.actuators;

import java.util.HashMap;
import java.util.Map;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

public class SparkMotorGroupIO implements MotorGroupIO {
    Map<String, CANSparkMax> motors = new HashMap<>();
    CANSparkMax leader;
    String leaderName;
    int leaderID;

    public SparkMotorGroupIO(String leaderName, int leaderID, Boolean invertLeader, MotorType leaderType) {
        motors.put(leaderName, new CANSparkMax(leaderID, leaderType));
        leader = motors.get(leaderName);
        leader.setInverted(invertLeader);
    }

    public void setVolts(double volts) {
        leader.setVoltage(leaderID);
    }

    public void addFollower(String motorName, int motorID, Boolean invertMotor, MotorType motorType) {
        motors.put(motorName, new CANSparkMax(motorID, motorType));
        motors.get(motorName).setInverted(invertMotor);
    }
}
