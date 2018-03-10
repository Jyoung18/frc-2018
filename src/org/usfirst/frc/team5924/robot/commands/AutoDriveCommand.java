package org.usfirst.frc.team5924.robot.commands;

import org.usfirst.frc.team5924.robot.Robot;
import org.usfirst.frc.team5924.robot.subsystems.RobotDrive;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoDriveCommand extends Command {

	double inches;
	
    public AutoDriveCommand(double inchesReq) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	//requires(Robot.kRobotDrive);
    	//inches = inchesReq;

    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	//Robot.kRobotDrive.resetEncoders();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//Robot.kRobotDrive.printMotorVoltage();
    	//Robot.kRobotDrive.checkAutoDrive(gameData, autoTypeDrive);
    	//System.out.println(RobotDrive.rightEncoder.getDistance() + " " + RobotDrive.leftEncoder.getDistance());
		/**if(Robot.kRobotDrive.getAverageEncoderPosition() < inches){
			Robot.kRobotDrive.moveRobot();
			
		}
		Robot.kRobotDrive.printBothEncoders(); **/
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return false;//Robot.kRobotDrive.autoDriveFinish(inches);
    	
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
