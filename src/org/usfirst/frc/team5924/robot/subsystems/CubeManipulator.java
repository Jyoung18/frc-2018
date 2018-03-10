package org.usfirst.frc.team5924.robot.subsystems;

import org.usfirst.frc.team5924.robot.Robot;
import org.usfirst.frc.team5924.robot.RobotConstants;
import org.usfirst.frc.team5924.robot.commands.CubeCommand;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class CubeManipulator extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private WPI_TalonSRX leftMotor = new WPI_TalonSRX(RobotConstants.cCubeLeft); 
	private WPI_TalonSRX rightMotor = new WPI_TalonSRX(RobotConstants.cCubeRight);
	
	private double cubeMotorSpeed = 0;
	
	Timer intakeTimer = new Timer();
	Timer outtakeTimer = new Timer();
	
	public CubeManipulator(){
		
	}
	
	public void printCubeManipulatorStatus(){
		
		//SmartDashboard.putString("Cube State", cubeGrabberStatus);
		//SmartDashboard.putString("Cube Motor State", cubeMotorStatus);
		SmartDashboard.putNumber("Intake Timer", intakeTimer.get());
		SmartDashboard.putNumber("Outtake Timer", outtakeTimer.get());
		SmartDashboard.putNumber("Cube Motor Speed", cubeMotorSpeed);
		SmartDashboard.putNumber("Cube Left Motor", leftMotor.getMotorOutputVoltage());
		SmartDashboard.putNumber("Cube Right Motor", rightMotor.getMotorOutputVoltage());
		
	}
	
	public void runCubeMotor(){
		
		leftMotor.set(-cubeMotorSpeed);
		rightMotor.set(cubeMotorSpeed);
		if(intakeTimer.get() > 1.5 && leftMotor.getMotorOutputVoltage() < 5.3 && rightMotor.getMotorOutputVoltage() > -5.3){
			
			cubeMotorSpeed = 0;
			
		} else if(outtakeTimer.get() > 1){
			
			cubeMotorSpeed = 0;
		}
			
			
	}

	public void intakeCube(){
		
		outtakeTimer.reset();
		outtakeTimer.stop();
		intakeTimer.reset();
		intakeTimer.start();
		cubeMotorSpeed = 0.5;
	}
	
	public void outtakeCube(){
		
		intakeTimer.reset();
		intakeTimer.stop();
		outtakeTimer.reset();
		outtakeTimer.start();
		cubeMotorSpeed = -0.5;
    }
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new CubeCommand());
    }
}

