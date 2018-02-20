package org.usfirst.frc.team5924.robot.commands;

import org.usfirst.frc.team5924.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class EncoderCommand extends Command {

    public EncoderCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.kEncoderTesting);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	Robot.kEncoderTesting.printSelectedSensorPos();
		
		if(Robot.oi.getGroundPosButton()){
			Robot.kEncoderTesting.testyTesting1();
		} else if(Robot.oi.getExchangePosButton()){
			Robot.kEncoderTesting.testyTesting2();
		}
		
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
