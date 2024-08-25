package frc.robot.abstraction.actuators;

import java.util.HashMap;
import java.util.Map;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkLowLevel.MotorType;

public class SparkMotorGroupIO implements MotorGroupIO {
    Map<String, CANSparkMax> motors = new HashMap<>();
    CANSparkMax leader;
    String leaderName;
    RelativeEncoder leaderEncoder;
    MotorType motorType;
    int leaderID;

    public SparkMotorGroupIO(String leaderName, int leaderID, Boolean invertLeader, MotorType leaderType) {
        this.motorType = leaderType;
        motors.put(leaderName, new CANSparkMax(leaderID, motorType));
        leader = motors.get(leaderName);
        leaderEncoder = leader.getEncoder();
        // Zero Leader
        leaderEncoder.setPosition(0);
        leader.setInverted(invertLeader);
        leaderEncoder.setPositionConversionFactor(2 * Math.PI);
    }

    public void setVolts(double volts) {
        leader.setVoltage(leaderID);
    }

    public void addFollower(String motorName, int motorID, Boolean invertMotor) {
        motors.put(motorName, new CANSparkMax(motorID, motorType));
        motors.get(motorName).setInverted(invertMotor);
    }

    public double getLeaderPosRad() {
        return leaderEncoder.getPosition();
    }
}
