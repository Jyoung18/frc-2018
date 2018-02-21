package org.usfirst.frc.team5924.robot.subsystems;

import org.usfirst.frc.team5924.robot.Robot;
import org.usfirst.frc.team5924.robot.RobotConstants;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
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
	
	private Compressor cubeCompressor = new Compressor(0);
	private DoubleSolenoid cubeSolenoid1 = new DoubleSolenoid(1, 2);
	private DoubleSolenoid cubeSolenoid2 = new DoubleSolenoid(0, 3);
	
	private String cubeGrabberStatus = "Base Position";
	private String cubeMotorStatus = "";
	
	private int buttonToggle = 0;
	
	public CubeManipulator(){
		
	}
	
	public void printCubeManipulatorStatus(){
		
		SmartDashboard.putString("Cube State", cubeGrabberStatus);
		SmartDashboard.putString("Cube Motor State", cubeMotorStatus);
		
	}
	
	public void intakeCube(){
		
		leftMotor.set(RobotConstants.leftMotorOutput);
		rightMotor.set(RobotConstants.rightMotorOutput);
		cubeMotorStatus = "Intake";
		
	}
	
	public void outtakeCube(){
		
		leftMotor.set(-RobotConstants.leftMotorOutput);
		rightMotor.set(-RobotConstants.rightMotorOutput);
		cubeMotorStatus = "Outtake";
		
	}
	
	public void basePositionCube(){
		
		cubeSolenoid1.set(DoubleSolenoid.Value.kForward);
		cubeSolenoid2.set(DoubleSolenoid.Value.kForward);
		
	}
	
	public void sidePositionCube(){
		
		cubeSolenoid1.set(DoubleSolenoid.Value.kReverse);
		cubeSolenoid2.set(DoubleSolenoid.Value.kReverse);
		
	}
	
	public void checkButtonToggle(){
    	
    	if(Robot.oi.toggleCubeState()){
    		buttonToggle = buttonToggle + 1;
    	}
    	
    	if((buttonToggle % 2) == 0){
    		basePositionCube();
    		cubeGrabberStatus = "Base Position";
    		
    	} else {
    		sidePositionCube();
    		cubeGrabberStatus = "Side Position";
    	}
    	
    }
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	//setDefaultCommand(new CubeCommand());
    }
}

