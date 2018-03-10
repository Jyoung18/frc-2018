package org.usfirst.frc.team5924.robot.commands;

import org.usfirst.frc.team5924.robot.Robot;

import com.analog.adis16448.frc.ADIS16448_IMU;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveTurnCommand extends Command { //FIX THIS

	private double angle;
	private double errorFactor;
	private double angleError;
	private String turnType;
	private double targetAngle;
	
    public DriveTurnCommand(String turnReq) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.kRobotDrive);
    	turnType = turnReq;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.imu.reset();
    	errorFactor = 0.0118;
    	targetAngle = 90;
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	angle = Robot.imu.getAngleZ();
    	angleError =  90 - angle;
    	SmartDashboard.putNumber("Z-Axis Angle", Robot.imu.getAngleZ());
    	if(turnType == "R"){
	    	if(Robot.imu.getAngleZ() < targetAngle){
	    		
	    		Robot.kRobotDrive.rDrive.arcadeDrive(0, angleError * errorFactor);
	    		
	    	} else if(Robot.imu.getAngleZ() >= targetAngle){
	    		
	    		Robot.kRobotDrive.rDrive.arcadeDrive(0, 0);
	    		
	    	}
    	} else if(turnType == "L"){
    			if(Robot.imu.getAngleZ() > -targetAngle){
	    		
	    		Robot.kRobotDrive.rDrive.arcadeDrive(0, -angleError * errorFactor);
	    		
	    	} else if(Robot.imu.getAngleZ() <= -targetAngle){
	    		
	    		Robot.kRobotDrive.rDrive.arcadeDrive(0, 0);
	    		
	    	}
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