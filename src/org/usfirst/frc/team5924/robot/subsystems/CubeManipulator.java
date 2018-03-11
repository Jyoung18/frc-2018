package org.usfirst.frc.team5924.robot.subsystems;

import org.usfirst.frc.team5924.robot.RobotConstants;
import org.usfirst.frc.team5924.robot.commands.CubeCommand;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

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
	
	private Timer intakeTimer = new Timer();
	private Timer outtakeTimer = new Timer();
	
	private boolean autoMotorStatus;
	private String cubeGrabberStatus = "";
	
	public CubeManipulator(){
		
	}
	
	public void printCubeInfo(){
		
		SmartDashboard.putString("Cube State", cubeGrabberStatus);
		SmartDashboard.putNumber("Intake Timer", intakeTimer.get());
		SmartDashboard.putNumber("Outtake Timer", outtakeTimer.get());
		SmartDashboard.putNumber("Cube Left Motor", leftMotor.getMotorOutputVoltage());
		SmartDashboard.putNumber("Cube Right Motor", rightMotor.getMotorOutputVoltage());
		
	}
	
	public void runCubeMotor(){
		
		leftMotor.set(-cubeMotorSpeed);
		rightMotor.set(cubeMotorSpeed);
		if(intakeTimer.get() > 1.5 && leftMotor.getMotorOutputVoltage() < 5.3 && rightMotor.getMotorOutputVoltage() > -5.3){
			
			cubeMotorSpeed = 0;
			intakeTimer.stop();
			intakeTimer.reset();
			cubeGrabberStatus = "Intake Done";
			
			
		} else if(outtakeTimer.get() > 1){
			
			cubeMotorSpeed = 0;
			outtakeTimer.stop();
			outtakeTimer.reset();
			cubeGrabberStatus = "Outtake Done";
			
		}	
	}
	
	public boolean checkCubeAuto(){
		
		if(outtakeTimer.get() > 1){
			outtakeTimer.stop();
			outtakeTimer.reset();
			return true;
			
		}else if(intakeTimer.get() > 1.5 && leftMotor.getMotorOutputVoltage() < 5.3 && rightMotor.getMotorOutputVoltage() > -5.3){
			intakeTimer.stop();
			intakeTimer.reset();
			return true;
		}
		
		return false;
	}

	public void intakeCube(){
		
		intakeTimer.start();
		cubeMotorSpeed = 0.5;
		cubeGrabberStatus = "Intake";
		
	}
	
	public void outtakeCube(){
		
		outtakeTimer.start();
		cubeMotorSpeed = -0.5;
		cubeGrabberStatus = "Outtake";
    }
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new CubeCommand());
    }
}

