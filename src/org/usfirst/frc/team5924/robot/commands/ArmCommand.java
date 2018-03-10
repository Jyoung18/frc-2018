package org.usfirst.frc.team5924.robot.commands;

import org.usfirst.frc.team5924.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ArmCommand extends Command {

    public ArmCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.kArmManipulator);
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.kArmManipulator.selectSensor();
    
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	Robot.kArmManipulator.checkButtonToggle();
    	Robot.kArmManipulator.printSensorPosition();
    	Robot.kArmManipulator.printMotorVoltage();
    	Robot.kArmManipulator.printSelectedPosition();
		
		if(Robot.oi.getGroundPosButton()){
			Robot.kArmManipulator.setGroundPosition();
			
		} else if(Robot.oi.getExchangePosButton()){
			Robot.kArmManipulator.setExchangePosition();
			
		} else if(Robot.oi.getSwitchPosButton()){
			Robot.kArmManipulator.setSwitchPosition();
			
		} else if(Robot.oi.getStartPosButton()){
			Robot.kArmManipulator.setStartPosition();
			
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
