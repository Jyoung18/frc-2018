package org.usfirst.frc.team5924.robot.commands;

import org.usfirst.frc.team5924.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class RampCommand extends Command {

    public RampCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	//requires(Robot.kRampManipulator);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	//Robot.kRampManipulator.selectSensor();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	/**
    	Robot.kRampManipulator.printSelectedSensorPos();
		
		if(Robot.oi.getGroundPosButton()){
			Robot.kRampManipulator.setBackRampVerticalPosition();
		} else if(Robot.oi.getExchangePosButton()){
			Robot.kRampManipulator.setBackRampDownPosition();
		} else if(Robot.oi.getButtonPanelAxis() != 0){
			Robot.kRampManipulator.manualMove();
		}
		
		Robot.kRampManipulator.setBackRampPosition();
		Robot.kRampManipulator.setFrontRampPosition();
		**/
		
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
