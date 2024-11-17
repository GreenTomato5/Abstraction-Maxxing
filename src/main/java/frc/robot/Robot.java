// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import java.util.HashMap;
import java.util.Map;

import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.simulation.DCMotorSim;
import edu.wpi.first.wpilibj.simulation.SingleJointedArmSim;
import frc.robot.Constants.GeneralConstants.RobotMode;
import frc.robot.Utils.MotorConfigs;
import frc.robot.abstraction.actuators.SparkMotorGroupIO;
import frc.robot.abstraction.actuators.TalonFXMotorGroup;
import frc.robot.abstraction.subsystems.State;
import frc.robot.abstraction.subsystems.Subsystem;
import frc.robot.abstraction.subsystems.arm.Arm;
import frc.robot.abstraction.subsystems.arm.ArmIO;
import frc.robot.abstraction.subsystems.arm.ArmRealIO;
import frc.robot.abstraction.subsystems.arm.ArmSimIO;
import frc.robot.abstraction.subsystems.intake.Intake;
import frc.robot.abstraction.subsystems.intake.IntakeIO;
import frc.robot.abstraction.subsystems.intake.IntakeRealIO;
import frc.robot.abstraction.subsystems.intake.IntakeSimIO;
import frc.robot.abstraction.supersystems.Manager;
import frc.robot.abstraction.supersystems.ManagerState;
import frc.robot.abstraction.supersystems.Trigger;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to
 * each mode, as described in the TimesliceRobot documentation. If you change
 * the name of this class
 * or the package after creating this project, you must also update the
 * build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  /** Robot constructor. */
  // Nah this is peak, timeslice > fodder

  Manager manager;

  public Robot() {

    this.manager = new Manager();

    // LiveWindow causes drastic overruns in robot periodic functions that will
    // interfere with controllers
    LiveWindow.disableAllTelemetry();
 
  }

  /**
   * This function is run when the robot is first started up and should be used
   * for any
   * initialization code.
   */
  @Override
  public void robotInit() {

    // 2024 Bot

	// TODO: Put random stuff in constants
	
    // Subsystem Config

	// Intake Pivot
		Map<String, MotorConfigs> intakePivotFollowerMotors = new HashMap<>() {{}};
		ArmIO intakePivotIO = 
			Constants.GeneralConstants.MODE == RobotMode.SIM ? 
			new ArmRealIO(new SparkMotorGroupIO("Leader", 0, false, MotorType.kBrushless)) :
			new ArmSimIO(new SingleJointedArmSim(null, kDefaultPeriod, kDefaultPeriod, kDefaultPeriod, kDefaultPeriod, kDefaultPeriod, isAutonomous(), kDefaultPeriod, null));
		manager.addSubsystem(
			new Arm(
				"Intake Pivot",
				new State("IDLE", 0),
				intakePivotIO,
				intakePivotFollowerMotors));
		Subsystem intakePivot = manager.getSubsystem("Intake Pivot");

	// Amp Bar Pivot
		Map<String, MotorConfigs> ampBarFollowerMotors = new HashMap<>() {{
			put("Left Pivot", new MotorConfigs(20, true));
		}};
		ArmIO ampBarIO = 
			Constants.GeneralConstants.MODE == RobotMode.SIM ? 
			new ArmRealIO(new SparkMotorGroupIO("Leader", 21, false, MotorType.kBrushless)) :
			new ArmSimIO(new SingleJointedArmSim(null, kDefaultPeriod, kDefaultPeriod, kDefaultPeriod, kDefaultPeriod, kDefaultPeriod, isAutonomous(), kDefaultPeriod, null));
		manager.addSubsystem(
			new Arm(
				"Amp Bar Pivot",
				new State("IDLE", 0),
				ampBarIO,
				ampBarFollowerMotors));
		Subsystem ampBarPivot = manager.getSubsystem("Amp Bar Pivot");
	
	// Intake Intake
		Map<String, MotorConfigs> intakeFollowers = new HashMap<>() {{}};
		IntakeIO intakeIO = 
			Constants.GeneralConstants.MODE == RobotMode.SIM ? 
			new IntakeRealIO(new TalonFXMotorGroup("Leader", 0, false)) :
			new IntakeSimIO(new DCMotorSim(null, null, 0.0, null));
		manager.addSubsystem(
			new Intake(
				"Intake", 
				new State("IDLE", 0), 
				intakeIO, 
				intakeFollowers)
		);
		Subsystem intake = manager.getSubsystem("Intake");
	// AmpBar Intake
		Map<String, MotorConfigs> ampBarIntakeFollowers = new HashMap<>() {{}};
			IntakeIO ampBarIntakeIO = 
				Constants.GeneralConstants.MODE == RobotMode.SIM ? 
				new IntakeRealIO(new TalonFXMotorGroup("Leader", 0, false)) :
				new IntakeSimIO(new DCMotorSim(null, null, 0.0, null));
			manager.addSubsystem(
				new Intake(
					"Amp Bar Intake", 
					new State("IDLE", 0), 
					ampBarIntakeIO, 
					ampBarIntakeFollowers)
			);
			Subsystem ampBarIntake = manager.getSubsystem("Amp Bar Intake");

	// States
		manager.setDefaultState(
			new ManagerState(
				"Idle", 
				() -> {
					intake.setState(intake.getDefaultState());
					intakePivot.setState(intakePivot.getDefaultState());
					ampBarPivot.setState(ampBarPivot.getDefaultState());
					ampBarIntake.setState(ampBarPivot.getDefaultState());
				}
			)
		);
		
		manager.addState(
			new ManagerState(
				"Intaking", 
				() -> {
					intake.setState(new State("Intaking", 1));
					intakePivot.setState(new State("Intaking", 1));
					ampBarPivot.setState(new State("Intakig", 0));
					ampBarIntake.setState(new State("Intaking", 0));
				}
			)
		);

    manager.addTransition("Intake", new Trigger(manager.getDefaultState().getStateName(), manager.getState("Intaking"), () -> true));
	manager.addTransition("Return after Intaking", new Trigger("Intaking", manager.getDefaultState(), () -> true));
  }
  

  @Override
  public void robotPeriodic() {
	manager.periodic();
  }

  @Override
  public void autonomousInit() {
  }

  @Override
  public void autonomousPeriodic() {
  }

  @Override
  public void teleopInit() {
  }

  @Override
  public void teleopPeriodic() {
  }

  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
  }

  @Override
  public void testInit() {
  }

  @Override
  public void testPeriodic() {
  }
}
