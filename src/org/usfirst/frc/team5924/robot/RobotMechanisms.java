package org.usfirst.frc.team5924.robot;

import org.usfirst.frc.team5924.robot.RobotConstants;
import org.usfirst.frc.team5924.robot.subsystems.ArmManipulator;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class RobotMechanisms {

	// SPEED CONTROLLERS
	static WPI_TalonSRX frontRight = new WPI_TalonSRX(RobotConstants.cFrontRight);
	static WPI_TalonSRX rearRight = new WPI_TalonSRX(RobotConstants.cRearRight);
	static WPI_TalonSRX rearLeft = new WPI_TalonSRX(RobotConstants.cRearLeft);
	static WPI_TalonSRX frontLeft = new WPI_TalonSRX(RobotConstants.cFrontLeft);
	static WPI_TalonSRX cubeRight = new WPI_TalonSRX(RobotConstants.cCubeRight);
	static WPI_TalonSRX cubeLeft = new WPI_TalonSRX(RobotConstants.cCubeLeft);
	static WPI_TalonSRX actuator = new WPI_TalonSRX(RobotConstants.cActuator);
	static WPI_TalonSRX rampMotor1 = new WPI_TalonSRX(RobotConstants.cRampMotor1);
	static WPI_TalonSRX rampMotor2 = new WPI_TalonSRX(RobotConstants.cRampMotor2);
	static WPI_TalonSRX rampMotor3 = new WPI_TalonSRX(RobotConstants.cRampMotor3);
	static WPI_TalonSRX rampMotor4 = new WPI_TalonSRX(RobotConstants.cRampMotor4);
	
	// DRIVE TRAIN SPEED CONTROLLER GROUPS
	
	static SpeedControllerGroup robotRight = new SpeedControllerGroup(frontRight, rearRight);
	static SpeedControllerGroup robotLeft = new SpeedControllerGroup(frontLeft, rearLeft);
	static SpeedControllerGroup robotRamp = new SpeedControllerGroup(rampMotor1, rampMotor2, rampMotor3, rampMotor4);
	
	static DifferentialDrive robotDrive = new DifferentialDrive(robotRight, robotLeft);

	
	// PNEUMATICS
	// public static Compressor compressor = new Compressor(0);
	// public static DoubleSolenoid leftCylinder = new DoubleSolenoid (1,2);
	// public static DoubleSolenoid rightCylinder = new DoubleSolenoid (0,3);
	
	//SUBSYSTEMS
	// public static ArmManipulator armManipulator = new ArmManipulator(actuator);
	// public static CubeManipulator cubeManipulator = new CubeManipulator(cubeRight, cubeLeft);
	// public static RampManipulator rampManipulator = new RampManipulator(robotRamp);
	// public static DRIVETRAINSUBSYSTEM dtmanipulator = new DRIVETRAINSUBSYSTEM(robotDrive);
}
