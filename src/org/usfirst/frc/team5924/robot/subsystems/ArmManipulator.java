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
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;




/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class ArmManipulator extends Subsystem{
	
	private WPI_TalonSRX actuatorTalon = new WPI_TalonSRX(RobotConstants.cActuator);
	private double positionTarget = 390.0;
	private double autoPosTarget = 310.0;
	private int buttonToggle = 0;
	private String actuatorPosition = "Start Position";

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public ArmManipulator(){
		
		actuatorTalon.config_kF(0, 0.0, 10);
		actuatorTalon.config_kP(0, 25.25, 10); //25.25
		actuatorTalon.config_kI(0, 0.00015, 10); //.00015
		actuatorTalon.config_kD(0, 0.0, 10);
		actuatorTalon.configForwardSoftLimitThreshold(450, 0);
		actuatorTalon.configForwardSoftLimitEnable(false, 0);
		actuatorTalon.configReverseSoftLimitThreshold(15, 0);
		actuatorTalon.configReverseSoftLimitEnable(false, 0);
		
	}
	//SELECT FEEDBACK SENSOR
	public void selectSensor(){
		
		//Pot
		actuatorTalon.configSelectedFeedbackSensor(FeedbackDevice.Analog, 0, 0);
		//actuatorTalon.setSelectedSensorPosition(0, 0, 0);
		
	}
	//OUTPUT INFO TO SMARTDASHBOARD
	public void printSelectedPosition(){
		
		SmartDashboard.putString("Selected Position", actuatorPosition);
		
	}
	
	public void printMotorVoltage(){
		
		SmartDashboard.putNumber("Actuator Talon Voltage", actuatorTalon.getMotorOutputVoltage());
		
	}
	
	public void printSensorPosition(){
		
		SmartDashboard.putNumber("Potentiometer Position", actuatorTalon.getSelectedSensorPosition(0));
		
	}
	//CLOSED LOOP POSITION SETTING
	public void setPosition(){
		
		actuatorTalon.set(ControlMode.Position, positionTarget);
			
	}
   
    public void setGroundPosition(){
    	
    	positionTarget = RobotConstants.groundPosition;
    	actuatorPosition = "Ground Position";
    	
    }
    
    public void setExchangePosition(){
    	
    	positionTarget = RobotConstants.exchangePosition;
    	actuatorPosition = "Exchange Position";
    	
    }
    
    public void setSwitchPosition(){
    	
    	positionTarget = RobotConstants.switchPosition;
    	actuatorPosition = "Switch Position";
    	
    }
    
    public void setStartPosition(){
    	
    	positionTarget = RobotConstants.startPosition;
    	actuatorPosition = "Start Position";
    	
    }
    //OPEN LOOP POSITION SETTING
    public void setRawPosition(){
    	
    	actuatorTalon.set(ControlMode.PercentOutput, Robot.oi.getButtonPanelAxis() * 0.25);
    		
    }
    //SWITCH CONTROL MODE
    public void checkButtonToggle(){
    	
    	if(Robot.oi.toggleControlMode()){
    		buttonToggle = buttonToggle + 1;
    	}
    	
    	if((buttonToggle % 2) == 0){
    		setRawPosition();
    		SmartDashboard.putString("Control Mode", "Voltage");
    		
    	} else {
    		setPosition();
    		SmartDashboard.putString("Control Mode", "Position");
    	}
    	
    }
    //AUTO CODE
    public void armAuto(){
    	actuatorTalon.set(ControlMode.Position, autoPosTarget);
    	
    }
    
    public boolean armAutoCheck(){
    	if(actuatorTalon.getSelectedSensorPosition(0) > autoPosTarget - 1 && actuatorTalon.getSelectedSensorPosition(0) > autoPosTarget + 1){
    		return true;
    	}
    	return false;
    	
    }

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
		setDefaultCommand(new ArmCommand());
    	
    }
}
