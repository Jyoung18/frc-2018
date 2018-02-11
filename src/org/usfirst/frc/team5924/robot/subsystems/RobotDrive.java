package org.usfirst.frc.team5924.robot.subsystems;

import org.usfirst.frc.team5924.robot.Robot;
import org.usfirst.frc.team5924.robot.RobotConstants;
import org.usfirst.frc.team5924.robot.commands.RobotCommand;

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
	
	private WPI_TalonSRX frontRight = new WPI_TalonSRX(RobotConstants.cFrontRight);
	private WPI_TalonSRX rearRight = new WPI_TalonSRX(RobotConstants.cRearRight);
	private WPI_TalonSRX frontLeft = new WPI_TalonSRX(RobotConstants.cFrontLeft);
	private WPI_TalonSRX rearLeft = new WPI_TalonSRX(RobotConstants.cRearLeft);
	
	private SpeedControllerGroup rightSide = new SpeedControllerGroup(frontRight, rearRight);
	private SpeedControllerGroup leftSide = new SpeedControllerGroup(frontLeft, rearLeft);
	
	private DifferentialDrive rDrive = new DifferentialDrive(rightSide, leftSide);
	
	public RobotDrive(){
		
	}
	
	public void driveRobotBase(){
		
		rDrive.arcadeDrive(Robot.m_oi.getXboxYAxis(), Robot.m_oi.getXboxXAxis());		
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new RobotCommand());
    }
}

