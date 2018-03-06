package org.usfirst.frc.team5924.robot.commands;

import org.usfirst.frc.team5924.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ArmAutoCommand extends Command {

    public ArmAutoCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	//requires(Robot.kArmManipulator);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	/**
    	Robot.kArmManipulator.printMotorVoltage();
    	Robot.kArmManipulator.printSensorPosition();
    	Robot.kArmManipulator.armAuto();
    	**/
    	
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        //return Robot.kArmManipulator.armAutoCheck();
    	return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	//System.out.println("Yes");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
