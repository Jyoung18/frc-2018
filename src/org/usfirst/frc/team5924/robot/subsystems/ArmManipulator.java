/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5924.robot.subsystems;

import org.usfirst.frc.team5924.robot.Robot;
import org.usfirst.frc.team5924.robot.RobotConstants;
import org.usfirst.frc.team5924.robot.RobotMechanisms;
import org.usfirst.frc.team5924.robot.commands.RobotCommand;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;




/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class ArmManipulator extends Subsystem{
	
	private WPI_TalonSRX actuatorTalon = new WPI_TalonSRX(RobotConstants.cActuator);

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public ArmManipulator(){
		
		actuatorTalon.config_kF(0, 0.0, 10);
		actuatorTalon.config_kP(0, 7.0065, 10); //7.007
		actuatorTalon.config_kI(0, 0.006, 10); //.006
		actuatorTalon.config_kD(0, 0.0001, 10);
		actuatorTalon.configSelectedFeedbackSensor(FeedbackDevice.Analog, 0, 0);
    	actuatorTalon.getSelectedSensorPosition(0);
    	actuatorTalon.setNeutralMode(NeutralMode.Coast);
		actuatorTalon.setSelectedSensorPosition(0, 0, 0);
		actuatorTalon.setInverted(false);
		actuatorTalon.setSensorPhase(false);
		
	}
   
    public void setGroundPosition(){
    	
    	actuatorTalon.set(ControlMode.Position, RobotConstants.groundPosition);
    	
    }
    
    public void setExchangePosition(){
    	
    	actuatorTalon.set(ControlMode.Position, RobotConstants.exchangePosition);
    	
    }
    
    public void setSwitchPosition(){
    	
    	actuatorTalon.set(ControlMode.Position, RobotConstants.switchPosition);
    	
    }
    
    public void setStartPosition(){
    	
    	actuatorTalon.set(ControlMode.Position, RobotConstants.startPosition);
    	
    }
    
    public void setRawPosition(){
    	
    	actuatorTalon.set(Robot.m_oi.getButtonPanelAxis() * 0.25);
    	
    }
   
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
		setDefaultCommand(new RobotCommand());
    	
    }
    
}
