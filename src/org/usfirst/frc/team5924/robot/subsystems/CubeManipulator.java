package org.usfirst.frc.team5924.robot.subsystems;

import org.usfirst.frc.team5924.robot.RobotConstants;
import org.usfirst.frc.team5924.robot.commands.RobotCommand;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class CubeManipulator extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private WPI_TalonSRX leftMotor = new WPI_TalonSRX(RobotConstants.cCubeLeft); 
	private WPI_TalonSRX rightMotor = new WPI_TalonSRX(RobotConstants.cCubeRight);
	
	public CubeManipulator(){
		
		
	}
	
	public void intakeCube(){
		
		leftMotor.set(RobotConstants.leftMotorOutput);
		rightMotor.set(RobotConstants.rightMotorOutput);
		
	}
	
	public void outtakeCube(){
		
		leftMotor.set(-RobotConstants.leftMotorOutput);
		rightMotor.set(-RobotConstants.rightMotorOutput);
		
	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new RobotCommand());
    }
}

