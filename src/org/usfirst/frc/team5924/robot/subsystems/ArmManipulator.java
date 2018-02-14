/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5924.robot.subsystems;

import org.usfirst.frc.team5924.robot.Robot;
import org.usfirst.frc.team5924.robot.RobotConstants;
import org.usfirst.frc.team5924.robot.commands.RobotCommand;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;




/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class ArmManipulator extends Subsystem{
	
	private WPI_TalonSRX actuatorTalon = new WPI_TalonSRX(RobotConstants.cActuator);
	private double currentPosition;
	private Timer timer = new Timer();

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public ArmManipulator(){
		
		actuatorTalon.config_kF(0, 0.0, 10);
		actuatorTalon.config_kP(0, 7.45, 10); //7.0065
		actuatorTalon.config_kI(0, 0.000655, 10); //.006
		actuatorTalon.config_kD(0, 0.00007, 10);
		actuatorTalon.setInverted(false);
		actuatorTalon.setSensorPhase(false);
		actuatorTalon.configForwardSoftLimitThreshold(415, 0);
		actuatorTalon.configForwardSoftLimitEnable(true, 0);
		actuatorTalon.configReverseSoftLimitThreshold(15, 0);
		actuatorTalon.configReverseSoftLimitEnable(true, 0);
	}
	
	
	public void resetSensorPosition(){
		
		//Pot
		actuatorTalon.configSelectedFeedbackSensor(FeedbackDevice.Analog, 0, 0);
		//actuatorTalon.setSelectedSensorPosition(0, 0, 0);
		
		//Encoder
		//actuatorTalon.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 0);
		
		
	}
	
	public void getSensorPosition(){
		
		System.out.println(actuatorTalon.getSelectedSensorPosition(0));

	}
	
	public void setPosition(){
		
		actuatorTalon.set(ControlMode.Position, currentPosition);
		
	}
   
    public void setGroundPosition(){
    	
    	actuatorTalon.set(ControlMode.Position, RobotConstants.groundPosition);
    	currentPosition = RobotConstants.groundPosition;
    	
    }
    
    public void setExchangePosition(){
    	
    	actuatorTalon.set(ControlMode.Position, RobotConstants.exchangePosition);
    	currentPosition = RobotConstants.exchangePosition;
    	
    }
    
    public void setSwitchPosition(){
    	
    	actuatorTalon.set(ControlMode.Position, RobotConstants.switchPosition);
    	currentPosition = RobotConstants.switchPosition;
    	
    }
    
    public void setStartPosition(){
    	
    	actuatorTalon.set(ControlMode.Position, RobotConstants.startPosition);
    	currentPosition = RobotConstants.startPosition;
    	
    }
    
    public void setRawPosition(){
    	actuatorTalon.set(Robot.oi.getButtonPanelAxis() * 0.25);
    	
    }
   
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
		setDefaultCommand(new RobotCommand());
    	
    }
    
}
