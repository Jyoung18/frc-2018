/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5924.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team5924.robot.Robot;

/**
 * An example command.  You can replace me with your own command.
 */
public class RobotCommand extends Command {
	public RobotCommand() {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.kArmManipulator);
		requires(Robot.kRobotDrive);
		requires(Robot.kCubeManipulator);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		
		Robot.kArmManipulator.resetSensorPosition();

	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		Robot.kRobotDrive.driveRobotBase();
		//Robot.kArmManipulator.setPosition();
		Robot.kArmManipulator.getSensorPosition();
		
		// ARM POSITION 
		if(Robot.oi.getGroundPosButton()){
			Robot.kArmManipulator.setGroundPosition();
			
		} else if(Robot.oi.getExchangePosButton()){
			Robot.kArmManipulator.setExchangePosition();
			
		} else if(Robot.oi.getSwitchPosButton()){
			Robot.kArmManipulator.setSwitchPosition();
			
		} else if(Robot.oi.getStartPosButton()){
			Robot.kArmManipulator.setStartPosition();
			
		} else if(Robot.oi.getButtonPanelAxis() != 0){
			Robot.kArmManipulator.setRawPosition();
		}
		// CUBE MANIPULATOR
		if(Robot.oi.getIntakeButton()){
			Robot.kCubeManipulator.intakeCube();
		} else if (Robot.oi.getOuttakeButton()){
			Robot.kCubeManipulator.outtakeCube();
		}

	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
	}
}
