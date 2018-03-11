package org.usfirst.frc.team5924.robot.subsystems;

import org.usfirst.frc.team5924.robot.Robot;
import org.usfirst.frc.team5924.robot.RobotConstants;
import org.usfirst.frc.team5924.robot.commands.RampCommand;

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
	
	private double bRampPosition = 0;
	private double fRampPosition = 0;
	
	public RampManipulator(){
		
		bRampTalonLeft.follow(bRampTalonRight);
		fRampTalonLeft.follow(fRampTalonRight);
	}
	
	public void selectSensor(){
		
		bRampTalonRight.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 0);
		bRampTalonRight.setSelectedSensorPosition(0, 0, 0);
	}
	
	public void printRampInfo(){
		
		System.out.println(bRampTalonRight.getSelectedSensorPosition(0));
	}
	
	public void setBackRampPosition(){
		
		if(bRampTalonRight.getSelectedSensorPosition(0) < bRampPosition){
			bRampTalonRight.set(0.3);
			
		} else if(bRampTalonRight.getSelectedSensorPosition(0) >= bRampPosition){
			bRampTalonRight.set(0);
		}
	}
	
	public void setFrontRampPosition(){
		
		if(fRampTalonRight.getSelectedSensorPosition(0) < fRampPosition){
			fRampTalonRight.set(0.3);
			
		} else if(fRampTalonRight.getSelectedSensorPosition(0) >= fRampPosition){
			fRampTalonRight.set(0);
		}
	}
	
	public void setBackRampVerticalPosition(){
		
		bRampPosition = RobotConstants.bRampVerticalPosition;
	}
	
	public void setBackRampDownPosition(){
		
		bRampPosition = RobotConstants.bRampDownPosition;
	}
	
	public void setFrontRampDownPosition(){
		
		fRampPosition = RobotConstants.fRampDownPosition;
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	//setDefaultCommand(new RampCommand());
    }
    
    
}