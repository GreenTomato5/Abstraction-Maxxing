// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import java.util.HashMap;
import java.util.Map;

import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.TimesliceRobot;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import frc.robot.Utils.MotorConfigs;
import frc.robot.abstraction.actuators.SparkMotorGroupIO;
import frc.robot.abstraction.subsystems.State;
import frc.robot.abstraction.subsystems.arm.Arm;
import frc.robot.abstraction.subsystems.arm.ArmIO;
import frc.robot.abstraction.subsystems.arm.ArmRealIO;
import frc.robot.abstraction.subsystems.arm.ArmSimIO;
import frc.robot.abstraction.supersystems.Manager;
import frc.robot.abstraction.supersystems.ManagerState;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimesliceRobot documentation. If you change the name of this class
 * or the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimesliceRobot {
  /** Robot constructor. */
  // Nah this is peak, timeslice > fodder


  Manager manager;

  public Robot() {
    // Run robot periodic() functions for 5 ms, and run controllers every 10 ms
    super(0.005, 0.01);

    // LiveWindow causes drastic overruns in robot periodic functions that will
    // interfere with controllers
    LiveWindow.disableAllTelemetry();

    // Runs for 2 ms after robot periodic functions
    schedule(() -> {}, 0.002);

    // Runs for 2 ms after first controller function
    schedule(() -> {}, 0.002);

    // Total usage:
    // 5 ms (robot) + 2 ms (controller 1) + 2 ms (controller 2) = 9 ms
    // 9 ms / 10 ms -> 90% allocated


    this.manager = new Manager();
  }

  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() { 
    Map<String, MotorConfigs> armMotors = new HashMap<>();

    manager.addSubsystem(
      new Arm(
        "Intake Arm", 
        new State("IDLE", 0), 
        new ArmRealIO(new SparkMotorGroupIO("Group Leader", 0, false, MotorType.kBrushless)), 
        armMotors
    ));

    // This is so cursed 😭
    manager.addState(new ManagerState(
      "Intaking", 
      () -> manager.getSubsystem("Intake Arm").setState(new State("Intaking", 0))
    ));
  }

  @Override
  public void robotPeriodic() {}

  @Override
  public void autonomousInit() {}

  @Override
  public void autonomousPeriodic() {}

  @Override
  public void teleopInit() {}

  @Override
  public void teleopPeriodic() {}

  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  @Override
  public void testInit() {}

  @Override
  public void testPeriodic() {}
}
