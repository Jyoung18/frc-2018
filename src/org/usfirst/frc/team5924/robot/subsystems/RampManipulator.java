package org.usfirst.frc.team5924.robot.subsystems;

import org.usfirst.frc.team5924.robot.RobotConstants;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class RampManipulator extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private WPI_TalonSRX rampMotor1 = new WPI_TalonSRX(RobotConstants.cRampMotor1);
	private WPI_TalonSRX rampMotor2 = new WPI_TalonSRX(RobotConstants.cRampMotor2);
	private WPI_TalonSRX rampMotor3 = new WPI_TalonSRX(RobotConstants.cRampMotor3);
	private WPI_TalonSRX rampMotor4 = new WPI_TalonSRX(RobotConstants.cRampMotor4);
	
	public RampManipulator(){
		
	rampMotor2.follow(rampMotor1);
	rampMotor4.follow(rampMotor3);
		
	}
	
	public void extendFrontRamp(){
		
		//rampMotor1.set(speed);
		
	}
	
	public void extendBackRamp(){
		
		//rampMotor3.set(speed);
	}
	
	public void retractBackRamp(){
		
		//rampMotor3.set(-speed);
		
	}
	
	public void retractFrontRamp(){
		
		//rampMotor1.set(speed);

	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

