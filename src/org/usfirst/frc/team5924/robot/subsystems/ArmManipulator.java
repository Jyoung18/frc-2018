/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5924.robot.subsystems;

import org.usfirst.frc.team5924.robot.Robot;
import org.usfirst.frc.team5924.robot.RobotConstants;
import org.usfirst.frc.team5924.robot.commands.ArmCommand;
import org.usfirst.frc.team5924.robot.commands.DriveCommand;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;




/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class ArmManipulator extends Subsystem{
	
	private WPI_TalonSRX actuatorTalon = new WPI_TalonSRX(RobotConstants.cActuator);
	private double positionTarget = 390.0;
	private int buttonToggle = 0;

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public ArmManipulator(){
		
		actuatorTalon.config_kF(0, 0.0, 10);
		actuatorTalon.config_kP(0, 25.25, 10); //25.25
		actuatorTalon.config_kI(0, 0.00015, 10); //.00015
		actuatorTalon.config_kD(0, 0.0, 10);
		actuatorTalon.configForwardSoftLimitThreshold(400, 0);
		actuatorTalon.configForwardSoftLimitEnable(true, 0);
		actuatorTalon.configReverseSoftLimitThreshold(15, 0);
		actuatorTalon.configReverseSoftLimitEnable(true, 0);
	}
	
	
	public void selectSensor(){
		
		//Pot
		actuatorTalon.configSelectedFeedbackSensor(FeedbackDevice.Analog, 0, 0);
		//actuatorTalon.setSelectedSensorPosition(0, 0, 0);
		
		//Encoder
		//actuatorTalon.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 0);
		
		
	}
	
	public void printMotorVoltage(){
		
		SmartDashboard.putNumber("Actuator Talon Voltage", actuatorTalon.getMotorOutputVoltage());
		
	}
	
	public void printSensorPosition(){
		
		SmartDashboard.putNumber("Potentiometer Position", actuatorTalon.getSelectedSensorPosition(0));
		System.out.println(actuatorTalon.getSelectedSensorPosition(0));
		
	}
	
	public void setPosition(){
		
		actuatorTalon.set(ControlMode.Position, positionTarget);
			
	}
   
    public void setGroundPosition(){
    	
    	//actuatorTalon.set(ControlMode.Position, RobotConstants.groundPosition);
    	positionTarget = RobotConstants.groundPosition;
    	
    }
    
    public void setExchangePosition(){
    	
    	//actuatorTalon.set(ControlMode.Position, RobotConstants.exchangePosition);
    	positionTarget = RobotConstants.exchangePosition;
    	
    }
    
    public void setSwitchPosition(){
    	
    	//actuatorTalon.set(ControlMode.Position, RobotConstants.switchPosition);
    	positionTarget = RobotConstants.switchPosition;
    	
    }
    
    public void setStartPosition(){
    	
    	//actuatorTalon.set(ControlMode.Position, RobotConstants.startPosition);
    	positionTarget = RobotConstants.startPosition;
    	
    }
    
    public void setRawPosition(){
    	
    	actuatorTalon.set(ControlMode.PercentOutput, Robot.oi.getButtonPanelAxis() * 0.25);
    		
    }
    
    public void checkButtonToggle(){
    	
    	if(Robot.oi.toggleControlMode()){
    		buttonToggle = buttonToggle + 1;
    	}
    	
    	if((buttonToggle % 2) == 0){
    		setPosition();
    		SmartDashboard.putString("Control Mode", "Position");
    		
    	} else {
    		setRawPosition();
    		SmartDashboard.putString("Control Mode", "Voltage");
    	}
    	
    }
   
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
		setDefaultCommand(new ArmCommand());
    	
    }
}
