package org.usfirst.frc.team5924.robot.commands;

import org.usfirst.frc.team5924.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveTurnRight extends Command {
	
    public DriveTurnRight() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.kRobotDrive);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.kRobotDrive.startTimer();
 
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.kRobotDrive.rDrive.arcadeDrive(0, 0.6);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.kRobotDrive.checkturnRight();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
