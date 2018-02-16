package org.usfirst.frc.team5924.robot.subsystems;

import org.usfirst.frc.team5924.robot.Robot;
import org.usfirst.frc.team5924.robot.RobotConstants;
import org.usfirst.frc.team5924.robot.commands.AutoCommand;
import org.usfirst.frc.team5924.robot.commands.TeleCommand;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

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
	
	public RobotDrive(){
		
	}
	
	public void driveRobotBase(){
		
		rDrive.arcadeDrive(Robot.oi.getXboxYAxis(), Robot.oi.getXboxXAxis());	

	}
	
	public void autoDrive(){
		
		rDrive.arcadeDrive(0.5, 0);
		
	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new AutoCommand());
    }
}

