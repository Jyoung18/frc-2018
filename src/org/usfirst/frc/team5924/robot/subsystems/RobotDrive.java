package org.usfirst.frc.team5924.robot.subsystems;

import org.usfirst.frc.team5924.robot.Robot;
import org.usfirst.frc.team5924.robot.RobotConstants;
import org.usfirst.frc.team5924.robot.commands.DriveCommand;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Encoder;
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
	
	public static Encoder rightEncoder = new Encoder(0, 1, true, Encoder.EncodingType.k4X);
	public static Encoder leftEncoder = new Encoder(2, 3, false, Encoder.EncodingType.k4X);
	
	private static double distancePerPulse = 4 * (6.0 * Math.PI) / 1440.0;
	private int autoCounter = 0;
	private boolean resetPosition = true;
	
	public RobotDrive(){
		//pulses per revolution: 1440
		//E4T MINI optical encoder
		rightEncoder.setDistancePerPulse(distancePerPulse);
		leftEncoder.setDistancePerPulse(distancePerPulse);
		
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
	
	public void checkAutoDrive(String gameDataReq, String autoTypeDriveReq){
		/**
		if(gameDataReq.length() > 0){
			
			if(autoTypeDriveReq == "C"){ //CHECK CENTER AUTODRIVE
				
				if(gameDataReq.charAt(0) == 'L'){ 
				
					//leftAutoCode
					//PRIMARY OPTION

					moveRobot(); //forward
					turnLeft();
					moveRobot(); //forward
					turnRight();
					moveRobot(); //forward
					//Deposit Cube
					moveRobot(); //reverse
					turnRight();
					moveRobot(); //forward
					//pick up cube
					moveRobot(); //reverse
					turnLeft();
					//deposit cube


					
				
				
		
					//SECONDARY OPTION
					moveRobot(94.0);
					//pick up cube
					turnLeft();
					moveRobot(122.0);
					turnRight();
					moveRobot(98);
					turnRight();
					//move forward ?
					//deposit cube
					turnLeft();
					//moveForward();
					turnRight();
					//moveForward();
					//pick up cube
					turnRight();
					//moveForward();
					turnLeft();
					//deposit cube
				
					} else{
				
						//rightAutoCode
						//PRIMARY OPTION

						moveRobot(); //forward
						turnRight();
						moveRobot(); //forward
						turnLeft();
						moveRobot(); //forward
						//Deposit Cube
						moveRobot(); //reverse
						turnLeft();
						moveRobot(); //forward
						//pick up cube
						moveRobot(); //reverse
						turnRight();
						//deposit cube


				
						//SECONDARY OPTION
						moveRobot(94.0);
						turnRight();
						moveRobot(122.0);
						turnLeft();
						moveRobot(98);
						turnLeft();
				
					}
			} else if(autoTypeDriveReq == "L"){ //CHECK LEFT AUTODRIVE
				
				if(gameDataReq.charAt(0) == 'L'){
					
					//leftAutoCode
					//PRIMARY OPTION

					moveRobot(); //forward
					turnRight();
					moveRobot(); //forward
					//deposit cube
					moveRobot(); //reverse
					turnRight();
					moveRobot(); //forward
					turnLeft();
					moveRobot(); //forward
					//pick up cube
					moveRobot(); //reverse
					turnLeft();
					//deposit cube


					
					
					
				} else{
					
					//rightAutoCode

					moveRobot(); //forward
					turnRight();
					moveRobot(); //forward
					turnRight();
					moveRobot(); //forward
					turnRight();
					moveRobot(); //forward
					//deposit cube
					moveRobot(); //reverse
					turnLeft();
					moveRobot(); //forward
					turnLeft();
					moveRobot(); //forward
					turnLeft();
					moveRobot(); //forward
					//pick up cube
					moveRobot(); //reverse
					turnLeft();
					moveRobot(); //forward
					turnRight();
					moveRobot(); //forward
					turnRight();
					moveRobot(); //forward
					//deposit cube


					
				}
				
			} else if(autoTypeDriveReq == "R"){ //CHECK RIGHT AUTODRIVE
				
				if(gameDataReq.charAt(0) == 'L'){
					
					//leftAutoCode
					//PRIMARY OPTION

					moveRobot(); //forward
					turnLeft();
					moveRobot(); //forward
					turnLeft();
					moveRobot(); //forward
					turnLeft();
					moveRobot(); //forward
					//deposit cube
					moveRobot(); //reverse
					turnRight();
					moveRobot(); //forward
					turnRight();
					moveRobot(); //forward
					turnRight();
					moveRobot(); //forward
					//pick up cube
					moveRobot(); //reverse
					turnRight();
					moveRobot(); //forward
					turnLeft();
					moveRobot(); //forward
					turnLeft();
					moveRobot(); //forward
					//deposit cube

					
				} else{
					
					//rightAutoCode
					//PRIMARY OPTION

					moveRobot(); //forward
					turnLeft();
					moveRobot(); //forward
					//deposit cube
					moveRobot(); //reverse
					turnLeft();
					moveRobot(); //forward
					turnRight();
					moveRobot(); //forward
					//pick up cube
					moveRobot(); //reverse
					turnRight();
					//deposit cube


				}
			} 
		}**/
	}
	
	public boolean autoDriveFinish(){
		
		if(timer.get() > 15){
			return true;
		}
		return false;
			
	}
	
	public void moveRobot(double inches) {
		if(resetPosition){
			resetEncoders();
			resetPosition = false;
		}
		if(leftEncoder.getDistance() != inches){
			rDrive.arcadeDrive(0.3, 0);
			
		} else if (leftEncoder.getDistance() == inches){
			rDrive.arcadeDrive(0, 0);
			autoCounter++;
			resetPosition = true;
			
		}
	}
	
	public double getAverageEncoderPosition() {
		return (leftEncoder.getDistance() + rightEncoder.getDistance()) / 2;
	}
	
	public void resetEncoders() {
		rightEncoder.reset();
		leftEncoder.reset();
	}
	
	public void autoTestDrive(){
		
		rDrive.arcadeDrive(0, 0.5);
	}
		
	public void gBoxTest(){
		frontLeft.set(Robot.oi.getButtonPanelAxis() * 0.25);
		rearLeft.set(Robot.oi.getButtonPanelAxis() * -0.25);
	}
	
	public void genericForward() {
    	rearLeft.follow(frontLeft);
    	rearRight.follow(frontRight);
    	frontLeft.set(ControlMode.Position, 137625.6);
    	frontRight.set(ControlMode.Position, -137625.6);
    }
	
	public void turnLeft() {
		timer.reset();
		timer.start();
		while (timer.get() < 1)
			
		{
			rDrive.arcadeDrive(0.0, -0.5);
		} 
	}
	
	public void turnRight() {
		timer.reset();
		timer.start();
		while (timer.get() < 1)
		
		{
			rDrive.arcadeDrive(0.0, 0.5);
		}
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new DriveCommand());
    }
    
    
}

