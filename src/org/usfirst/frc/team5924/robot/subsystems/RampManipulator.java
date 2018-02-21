package org.usfirst.frc.team5924.robot.subsystems;

import org.usfirst.frc.team5924.robot.Robot;
import org.usfirst.frc.team5924.robot.RobotConstants;
import org.usfirst.frc.team5924.robot.commands.RampCommand;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class RampManipulator extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private WPI_TalonSRX bRampTalonRight = new WPI_TalonSRX(RobotConstants.cBackRampMotorRight);
	private WPI_TalonSRX bRampTalonLeft = new WPI_TalonSRX(RobotConstants.cBackRampMotorLeft);
	private WPI_TalonSRX fRampTalonRight = new WPI_TalonSRX(RobotConstants.cFrontRampMotorRight);
	private WPI_TalonSRX fRampTalonLeft = new WPI_TalonSRX(RobotConstants.cFrontRampMotorLeft);
	
	private double bRampPosition;
	private double fRampPosition;
	
	public RampManipulator(){
		bRampTalonRight.config_kF(0, 0.0, 10);
		bRampTalonRight.config_kP(0, 0.07, 10);//1.25
		bRampTalonRight.config_kI(0, 0.00008, 10);
		bRampTalonRight.config_kD(0, 0, 10);
		bRampTalonRight.configForwardSoftLimitThreshold(2220, 0);
		bRampTalonRight.configForwardSoftLimitEnable(true, 0);
		bRampTalonRight.configReverseSoftLimitThreshold(1024, 0);
		bRampTalonRight.configReverseSoftLimitEnable(true, 0);
		
		fRampTalonRight.config_kF(0, 0.0, 10);
		fRampTalonRight.config_kP(0, 0.07, 10);//1.25
		fRampTalonRight.config_kI(0, 0.00008, 10);
		fRampTalonRight.config_kD(0, 0, 10);
		fRampTalonRight.configForwardSoftLimitThreshold(1536, 0);
		fRampTalonRight.configForwardSoftLimitEnable(true, 0);
		fRampTalonRight.configReverseSoftLimitThreshold(0, 0);
		fRampTalonRight.configReverseSoftLimitEnable(true, 0);
		
		bRampTalonLeft.follow(bRampTalonRight);
		
		fRampTalonLeft.follow(fRampTalonRight);
		
	}
	
	public void selectSensor(){
		
		bRampTalonRight.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 0);
		bRampTalonRight.setSelectedSensorPosition(0, 0, 0);
	}
	
	public void setBackRampPosition(){
		
		bRampTalonRight.set(ControlMode.Position, bRampPosition);
		
	}
	
	public void setFrontRampPosition(){
		
		bRampTalonRight.set(ControlMode.Position, fRampPosition);
	}
	
	public void printSelectedSensorPos(){
		
		System.out.println(bRampTalonRight.getSelectedSensorPosition(0));
		
	}
	
	public void setBackRampVerticalPosition(){
		
		//bRampTalonRight.set(ControlMode.Position, 1024);
		bRampPosition = RobotConstants.bRampVerticalPosition;
	}
	
	public void setBackRampDownPosition(){
		
		//bRampTalonRight.set(ControlMode.Position, 2220);
		bRampPosition = RobotConstants.bRampDownPosition;
	}
	
	public void setFrontRampDownPosition(){
		
		//fRampTalonRight.set(ControlMode.Position, 1536);
		fRampPosition = RobotConstants.fRampDownPosition;
	}
	
	public void manualMove(){
		
		bRampTalonRight.set(ControlMode.PercentOutput, Robot.oi.getButtonPanelAxis() * 0.25);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	//setDefaultCommand(new RampCommand());
    }
    
    
}

