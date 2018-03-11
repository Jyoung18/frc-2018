package org.usfirst.frc.team5924.robot.subsystems;

import org.usfirst.frc.team5924.robot.Robot;
import org.usfirst.frc.team5924.robot.RobotConstants;
import org.usfirst.frc.team5924.robot.commands.DriveCommand;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
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
	
	public DifferentialDrive rDrive = new DifferentialDrive(rightSide, leftSide);

	public Encoder rightEncoder = new Encoder(0, 1, true, Encoder.EncodingType.k4X);
	public Encoder leftEncoder = new Encoder(2, 3, false, Encoder.EncodingType.k4X);
	private static double distancePerPulse = 4 * (6.0 * Math.PI) / 1440.0;
	
	private String turnStatus = "";
	private double angleError;
	private double angle;
	private double errorFactor = 0.0118;
	private double targetAngle = 90;
	
	
	public RobotDrive(){
		//pulses per revolution: 1440
		//E4T MINI optical encoder
		rightEncoder.setDistancePerPulse(distancePerPulse);
		leftEncoder.setDistancePerPulse(distancePerPulse);	
	}
	
	public void printMotorInfo(){
		
		SmartDashboard.putNumber("Front Right Motor Voltage", frontRight.getMotorOutputVoltage());
		SmartDashboard.putNumber("Rear Right Motor Voltage", rearRight.getMotorOutputVoltage());
		SmartDashboard.putNumber("Front Left Motor Voltage", frontLeft.getMotorOutputVoltage());
		SmartDashboard.putNumber("Rear Left Motor Voltage", rearLeft.getMotorOutputVoltage());
	}
	
	public void printAutoMotorInfo(){
		
		SmartDashboard.putNumber("Left Encoder Position", leftEncoder.getDistance());
		SmartDashboard.putNumber("Right Encoder Position", rightEncoder.getDistance());
		SmartDashboard.putNumber("Z-Axis Angle", Robot.imu.getAngleZ());
    	SmartDashboard.putString("Robot Turn Status", turnStatus);
	}
	
	
	//TELE STUFF
	public void driveRobotBase(){
		
		rDrive.arcadeDrive(-Robot.oi.getXboxYAxis(), Robot.oi.getXboxXAxis());	
	}
	
	public void moveRobot(){
		
		rDrive.arcadeDrive(0.6, 0);
	}
	
	public void turnRobot(String turnTypeReq){
		angle = Robot.imu.getAngleZ();
		angleError = targetAngle - angle;
		
		if(turnTypeReq == "R"){
	    	if(Robot.imu.getAngleZ() < targetAngle){
	    		
	    		Robot.kRobotDrive.rDrive.arcadeDrive(0, angleError * errorFactor);
	    		turnStatus = "Turning Right";
	    	}
	    
		} else if(turnTypeReq == "L"){
			
			if(Robot.imu.getAngleZ() > -targetAngle){
	    		
	    		Robot.kRobotDrive.rDrive.arcadeDrive(0, -angleError * errorFactor);
	    		turnStatus = "Turning Left";
	    	}
		}
	}
	
	public double getAverageEncoderPosition() {
		
		return (leftEncoder.getDistance() + rightEncoder.getDistance()) / 2;
	}
	
	public void resetEncoders() {
		
		rightEncoder.reset();
		leftEncoder.reset();
	}
	
	public boolean autoDriveFinish(double inchesReq){
		
		if (Robot.kRobotDrive.getAverageEncoderPosition() >= inchesReq){
			return true;
		}
		
		return false;
	}
	
	public boolean checkTurn(){
		if(Math.abs(Robot.imu.getAngleZ()) > 88 && Math.abs(Robot.imu.getAngleZ()) < 92){
			turnStatus = "Complete";
			return true;
		}
		
		return false;
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new DriveCommand());
    }
}

