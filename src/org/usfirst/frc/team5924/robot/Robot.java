/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5924.robot;

import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team5924.robot.commands.AutoCommand;
import org.usfirst.frc.team5924.robot.commands.AutoTestCommand;
import org.usfirst.frc.team5924.robot.commands.DriveCommand;
import org.usfirst.frc.team5924.robot.subsystems.ArmManipulator;
import org.usfirst.frc.team5924.robot.subsystems.CubeManipulator;
import org.usfirst.frc.team5924.robot.subsystems.EncoderTesting;
import org.usfirst.frc.team5924.robot.subsystems.RobotDrive;
import edu.wpi.first.wpilibj.Timer;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends TimedRobot {
	public static final ArmManipulator kArmManipulator = new ArmManipulator();
	public static final RobotDrive kRobotDrive = new RobotDrive();
	public static final CubeManipulator kCubeManipulator = new CubeManipulator();
	public static final EncoderTesting kEncoderTesting = new EncoderTesting();
	public static OI oi = new OI();
	
	//Command autonomousCommand;

	Command m_selectedCommand;
	SendableChooser<Command> m_chooser = new SendableChooser<>();

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
	
		m_chooser.addDefault("Default Auto", new AutoCommand());
		m_chooser.addObject("My Auto", new AutoTestCommand());
		SmartDashboard.putData("Auto mode", m_chooser);
		//autonomousCommand = new AutoCommand();
		UsbCamera rampCam = CameraServer.getInstance().startAutomaticCapture();
		UsbCamera armCam = CameraServer.getInstance().startAutomaticCapture();
		rampCam.setResolution(640, 480);
		armCam.setResolution(640, 480);
		
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * <p>You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		m_selectedCommand = m_chooser.getSelected();
		System.out.println(m_selectedCommand);
		
		/**String autoSelected = SmartDashboard.getString("Auto Selector",
		"Default"); switch(autoSelected) { case "My Auto": selectedCommand
		= new TeleCommand(); break; case "Default Auto": default:
		selectedCommand = new AutoCommand(); break; }
		
		**/
		// schedule the autonomous command (example)
		if (m_selectedCommand != null) {
			m_selectedCommand.start();
		}
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
		
		/**double maxSpeed = (4455 * 6 * Math.PI) / (60 * 10.75 * 12);
		// ENTER STARTING POSITION (left, right, or middle)
		String startingPosition = null;
		
		if (startingPosition == "left") {
			// go forward
			// turn right
		}
		
		else if (startingPosition == "right") {
			// go forward
			// turn left
		}
		
		else if (startingPosition == "middle") {
			// go forward
		}
		while (timer.get() < 1.65) {
			RobotDrive.rDrive.arcadeDrive(0.8, 0.0);
			
		}
		//Turn 90 degr2ees to the right
		while (timer.get() > 1.15 && timer.get() < 2.15)
		
		{
			RobotDrive.rDrive.arcadeDrive(0.0, 0.5);
		}
		
		
		while (timer.get() > 1.65 && timer.get() < 2.65)
			
		{
			RobotDrive.rDrive.arcadeDrive(0.6, 0);
		} **/
		
		
		
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		//if (autonomousCommand != null) {
		//	autonomousCommand.cancel();
			
		//teleCommand.start();
			
		
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
	}
}
