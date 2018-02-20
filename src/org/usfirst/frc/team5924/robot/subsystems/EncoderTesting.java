package org.usfirst.frc.team5924.robot.subsystems;

import org.usfirst.frc.team5924.robot.RobotConstants;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class EncoderTesting extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private WPI_TalonSRX actuatorTalon = new WPI_TalonSRX(RobotConstants.cActuator);
	
	public EncoderTesting(){
		actuatorTalon.config_kF(0, 0.0, 10);
		actuatorTalon.config_kP(0, 0.1, 10);
		actuatorTalon.config_kI(0, 0.0001, 10);
		actuatorTalon.config_kD(0, 0.0, 10);
		actuatorTalon.configForwardSoftLimitThreshold(100000, 0);
		actuatorTalon.configForwardSoftLimitEnable(true, 0);
		actuatorTalon.configReverseSoftLimitThreshold(-100000, 0);
		actuatorTalon.configReverseSoftLimitEnable(true, 0);
		
	}
	
	public void selectSensor(){
		
		actuatorTalon.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 0);
		
	}
	
	public void printSelectedSensorPos(){
		
		System.out.println(actuatorTalon.getSelectedSensorPosition(0));
		
	}
	
	public void testyTesting1(){
		
		actuatorTalon.set(ControlMode.Position, 40000);
		
	}
	
	public void testyTesting2(){
		
		actuatorTalon.set(ControlMode.Position, -40000);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    
}

