package org.usfirst.frc.team5924.robot.commands;

import org.usfirst.frc.team5924.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CubeAutoCommand extends Command{

	private String currentState; 
	
    public CubeAutoCommand(String currentStateReq) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.kCubeManipulator);
    	currentState = currentStateReq;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	Robot.kCubeManipulator.runCubeMotor();
    	Robot.kCubeManipulator.printCubeInfo();
    	if(currentState == "I"){
    		Robot.kCubeManipulator.intakeCube();
    	}
    	if(currentState == "O"){
    		Robot.kCubeManipulator.outtakeCube();
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return Robot.kCubeManipulator.checkCubeAuto();
    }

    // Called once after isFinished returns true
    protected void end() {
    	
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	
    }
}

