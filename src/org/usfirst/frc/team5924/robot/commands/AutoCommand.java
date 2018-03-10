package org.usfirst.frc.team5924.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoCommand extends CommandGroup {
	
    public AutoCommand(String robotPosReq, String gameDataReq) {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.
    	
    	if(gameDataReq.length() > 0){
    		
    		if(robotPosReq == "C"){ //CENTER POSITION AUTO CODE
    		
    			if(gameDataReq.charAt(0) == 'L'){ //CENTER POSITION LEFT SWITCH
					addSequential(new AutoDriveCommand(94.0));
					addSequential(new DriveTurnCommand("L"));
					addSequential(new AutoDriveCommand(48.0));
					addSequential(new DriveTurnCommand("R"));
					addSequential(new AutoDriveCommand(50.0));//check
					addSequential(new CubeCommand());
					addSequential(new AutoDriveCommand(-8.0));
					addSequential(new DriveTurnCommand("L"));
					addSequential(new AutoDriveCommand(88.0));
					addSequential(new DriveTurnCommand("R"));
					addParallel(new AutoDriveCommand(80.0));
					addParallel(new ArmAutoCommand());
					addSequential(new DriveTurnCommand("R"));
					
					//...to be continued
					addSequential(new AutoDriveCommand(66.0));
					//addSequential(new AutoDriveCommand("R"));
					addSequential(new AutoDriveCommand(.0));
					
					addSequential(new CubeCommand());
					addParallel(new AutoDriveCommand(15.0));
					addParallel(new ArmAutoCommand());
					addParallel(new AutoDriveCommand(15.0));
					addSequential(new CubeCommand());
				
					/*
					RobotDrive-- 5
					Cube-- 1
					{RobotDrive--3
					Arm- 1}
					Cube- 1
					{Arm- 1
					RobotDrive- 2}
					Cube- 1
					*/
    			} else{ //CENTER POSITION RIGHT SWITCH
				
    				addSequential(new AutoDriveCommand(94.0));
					addSequential(new DriveTurnCommand("R"));
					addSequential(new AutoDriveCommand(48.0));
					addSequential(new DriveTurnCommand("L"));
					addSequential(new AutoDriveCommand(50.0));//check
					addSequential(new CubeCommand());
					addSequential(new AutoDriveCommand(-8.0));
					addSequential(new DriveTurnCommand("R"));
					addSequential(new AutoDriveCommand(88.0));
					addSequential(new DriveTurnCommand("L"));
					addParallel(new AutoDriveCommand(80.0));
					addParallel(new ArmAutoCommand());
					//addSequential(new AutoDriveCommand("L"));
					
					//...to be continued
					addSequential(new AutoDriveCommand(66.0));
					//addSequential(new AutoDriveCommand("L"));
					addSequential(new AutoDriveCommand(.0));
					
					addSequential(new CubeCommand());
					addParallel(new AutoDriveCommand(15.0));
					addParallel(new ArmAutoCommand());
					addParallel(new AutoDriveCommand(15.0));
					addSequential(new CubeCommand());
				
    			}
    		} else if(robotPosReq == "L"){ //LEFT POSITION AUTO CODE
    			
    			if(gameDataReq.charAt(0) == 'L'){ //LEFT POSITION LEFT SWITCH
    				//24
	    			addSequential(new AutoDriveCommand(170.0));
					addSequential(new DriveTurnCommand("R"));
					addSequential(new CubeCommand());
					addSequential(new AutoDriveCommand(.0));
					addSequential(new AutoDriveCommand(15.0));
					addSequential(new AutoDriveCommand(15.0));
					addSequential(new AutoDriveCommand(15.0));
					addParallel(new AutoDriveCommand(15.0));
					addParallel(new ArmAutoCommand());
					addSequential(new CubeCommand());
					addParallel(new AutoDriveCommand(15.0));
					addParallel(new ArmAutoCommand());
					addParallel(new AutoDriveCommand(15.0));
					addSequential(new CubeCommand());
    			
    			} else{ //LEFT POSITION RIGHT SWITCH
    			/*
    				addSequential(new AutoDriveCommand(15.0));
					addSequential(new AutoDriveCommand(15.0));
					addSequential(new AutoDriveCommand(15.0));
					addSequential(new CubeCommand());
					addSequential(new AutoDriveCommand(15.0));
					addSequential(new AutoDriveCommand(15.0));
					addSequential(new AutoDriveCommand(15.0));
					addSequential(new AutoDriveCommand(15.0));
					addParallel(new AutoDriveCommand(15.0));
					addParallel(new ArmAutoCommand());
					addSequential(new CubeCommand());
					addParallel(new AutoDriveCommand(15.0));
					addParallel(new ArmAutoCommand());
					addParallel(new AutoDriveCommand(15.0));
					addSequential(new CubeCommand());
    			
    			}*/
    			}
    			
    		} else if(robotPosReq == "R"){ //RIGHT POSITION AUTO CODE
    			
    			if(gameDataReq.charAt(0) == 'L'){ //RIGHT POSITION LEFT SWITCH

	    			addSequential(new AutoDriveCommand(15.0));
					addSequential(new AutoDriveCommand(15.0));
					addSequential(new AutoDriveCommand(15.0));
					addSequential(new CubeCommand());
					addSequential(new AutoDriveCommand(15.0));
					addSequential(new AutoDriveCommand(15.0));
					addSequential(new AutoDriveCommand(15.0));
					addSequential(new AutoDriveCommand(15.0));
					addParallel(new AutoDriveCommand(15.0));
					addParallel(new ArmAutoCommand());
					addSequential(new CubeCommand());
					addParallel(new AutoDriveCommand(15.0));
					addParallel(new ArmAutoCommand());
					addParallel(new AutoDriveCommand(15.0));
					addSequential(new CubeCommand());
    			
    			} else{ //RIGHT POSITION RIGHT SWITCH
    			
    				addSequential(new AutoDriveCommand(15.0));
					addSequential(new AutoDriveCommand(15.0));
					addSequential(new AutoDriveCommand(15.0));
					addSequential(new CubeCommand());
					addSequential(new AutoDriveCommand(15.0));
					addSequential(new AutoDriveCommand(15.0));
					addSequential(new AutoDriveCommand(15.0));
					addSequential(new AutoDriveCommand(15.0));
					addParallel(new AutoDriveCommand(15.0));
					addParallel(new ArmAutoCommand());
					addSequential(new CubeCommand());
					addParallel(new AutoDriveCommand(15.0));
					addParallel(new ArmAutoCommand());
					addParallel(new AutoDriveCommand(15.0));
					addSequential(new CubeCommand());
    			
    			}
    		}

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    	}
    } 	
}
    

