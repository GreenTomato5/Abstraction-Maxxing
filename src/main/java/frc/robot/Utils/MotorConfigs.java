package frc.robot.Utils;

public class MotorConfigs {
    int motorID;
    boolean invertMotor;
    
    public MotorConfigs(int motorID, boolean invertMotor) {
        this.motorID = motorID;
        this.invertMotor = invertMotor;
    }

    public boolean getInverted() {
        return invertMotor;
    }

    public int getMotorID() {
        return motorID;
    }
}
