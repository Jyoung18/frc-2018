package org.usfirst.frc.team5924.robot.subsystems;

import org.usfirst.frc.team5924.robot.Robot;
import org.usfirst.frc.team5924.robot.RobotConstants;
import org.usfirst.frc.team5924.robot.commands.DriveCommand;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class RobotDrive extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	private static WPI_TalonSRX frontRight = new WPI_TalonSRX(RobotConstants.cFrontRight);
	private static WPI_TalonSRX rearRight = new WPI_TalonSRX(RobotConstants.cRearRight);
	private static WPI_TalonSRX frontLeft = new WPI_TalonSRX(RobotConstants.cFrontLeft);
	private static WPI_TalonSRX rearLeft = new WPI_TalonSRX(RobotConstants.cRearLeft);
	
	private static SpeedControllerGroup rightSide = new SpeedControllerGroup(frontRight, rearRight);
	private static SpeedControllerGroup leftSide = new SpeedControllerGroup(frontLeft, rearLeft);
	
	private static DifferentialDrive rDrive = new DifferentialDrive(rightSide, leftSide);
	
	private static Timer timer = new Timer();
	
	public RobotDrive(){
		
	}
	
	public void printMotorVoltage(){
		
		SmartDashboard.putNumber("Front Right Motor Voltage", frontRight.getMotorOutputVoltage());
		SmartDashboard.putNumber("Rear Right Motor Voltage", rearRight.getMotorOutputVoltage());
		SmartDashboard.putNumber("Front Left Motor Voltage", frontLeft.getMotorOutputVoltage());
		SmartDashboard.putNumber("Rear Left Motor Voltage", rearLeft.getMotorOutputVoltage());
		
	}
	
	
	//TELE STUFF
	public void driveRobotBase(){
		
		rDrive.arcadeDrive(Robot.oi.getXboxYAxis(), Robot.oi.getXboxXAxis());	

	}
	
	//AUTO STUFF
	public void driveTimer(){
		
		timer.reset();
		timer.start();
		
	}	
	
	public void checkAutoDrive(String gameDataReq){

		if(gameDataReq.length() > 0){
			
			if(gameDataReq.charAt(0) == 'L'){
				
				//leftAutoCode
				if(timer.get() < 10){
					
					rDrive.arcadeDrive(0.5, 0);
					
				} else if(timer.get() < 15 && timer.get() > 10){
					
					rDrive.arcadeDrive(0, 0.25);
				}
				
			} else{
				
				//rightAutoCode
				if(timer.get() < 10){
					
					rDrive.arcadeDrive(0.5, 0);
					
				} else if(timer.get() < 15 && timer.get() > 10){
					
					rDrive.arcadeDrive(0, 0.75);
					
				}
			}
		}
	}
	
	public boolean autoDriveFinish(){
		
		if(timer.get() > 15){
			return true;
		}
		return false;
			
	}
	
	public void autoTestDrive(){
		
		rDrive.arcadeDrive(0, 0.5);
		
	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new DriveCommand());
    }
}

