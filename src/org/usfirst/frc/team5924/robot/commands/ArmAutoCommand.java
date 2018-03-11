package org.usfirst.frc.team5924.robot.commands;

import org.usfirst.frc.team5924.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ArmAutoCommand extends Command {

	private String autoPosition;
	
    public ArmAutoCommand(String autoPositionReq) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.kArmManipulator);
    	autoPosition = autoPositionReq;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.kArmManipulator.selectSensor();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	Robot.kArmManipulator.printArmInfo();
    	Robot.kArmManipulator.setPosition();
    
    	if(autoPosition == "I"){
    		Robot.kArmManipulator.setGroundPosition();
    		
    	} else if(autoPosition == "O"){
    		Robot.kArmManipulator.setSwitchPosition();
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.kArmManipulator.armAutoCheck();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
