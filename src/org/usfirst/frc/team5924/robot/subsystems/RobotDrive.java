package org.usfirst.frc.team5924.robot.subsystems;

import org.usfirst.frc.team5924.robot.Robot;
import org.usfirst.frc.team5924.robot.RobotConstants;
import org.usfirst.frc.team5924.robot.commands.DriveCommand;
import org.usfirst.frc.team5924.robot.commands.DriveTurnCommand;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.AnalogGyro;
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
	
	public DifferentialDrive rDrive = new DifferentialDrive(rightSide, leftSide);
	
	private static Timer timer = new Timer();
	
	public Encoder rightEncoder = new Encoder(0, 1, true, Encoder.EncodingType.k4X);
	public Encoder leftEncoder = new Encoder(2, 3, false, Encoder.EncodingType.k4X);
	
	private static double distancePerPulse = 4 * (6.0 * Math.PI) / 1440.0;
	
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
	
	
	public boolean autoDriveFinish(double inchesReq){
		
		if (Robot.kRobotDrive.getAverageEncoderPosition() >= inchesReq){
			return true;
		}
		
		return false;
			
	}
	
	public void printBothEncoders(){
		
		System.out.println(leftEncoder.getDistance() + " " + rightEncoder.getDistance());
	}
	
	public void moveRobot(){
		
		rDrive.arcadeDrive(-0.6, 0);
	
	}
	
	public double getAverageEncoderPosition() {
		return (leftEncoder.getDistance() + rightEncoder.getDistance()) / 2;
	}
	
	public void resetEncoders() {
		rightEncoder.reset();
		leftEncoder.reset();
	}
	
	public void autoTestDrive(){
		
		rDrive.arcadeDrive(0, -0.5);
	}
		
	public void startTimer(){
		
		timer.reset();
		timer.start();
	}
	
	public void turnLeft() {
		
		timer.reset();
		timer.start();
		while (timer.get() < 1.3)		
		{
			rDrive.arcadeDrive(0.0, -0.5);
		}
		/*gyro.reset();
		//while doesn't work
		//if doesn't print
		if (gyro.getAngle() <= 90) {
			rDrive.arcadeDrive(0.0, -0.5);
			System.out.println(RobotDrive.gyro.getAngle());
		}
		*/
	}
	
	public boolean checkturnRight() {
		if(timer.get() > .675){
			timer.reset();
			return true;
		}
		return false;
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new DriveCommand());
    }
    
    
}

