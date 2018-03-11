package org.usfirst.frc.team5924.robot.commands;

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
    	
    	// To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.
    	
    	if(gameDataReq.length() > 0){
    		
    		if(robotPosReq == "C"){ //CENTER POSITION AUTO CODE
    		
    			if(gameDataReq.charAt(0) == 'L'){ //CENTER POSITION LEFT SWITCH
					addSequential(new AutoDriveCommand(55.75));
					addSequential(new DriveTurnCommand("L"));
					addSequential(new AutoDriveCommand(37.0));
					addSequential(new DriveTurnCommand("R"));
					addParallel(new AutoDriveCommand(48.0));//check
					addParallel(new ArmAutoCommand("O"));
					addSequential(new CubeAutoCommand("O"));
					addSequential(new AutoDriveCommand(-6.0));
					addSequential(new DriveTurnCommand("L"));
					addSequential(new AutoDriveCommand(62.0));
					addSequential(new DriveTurnCommand("R"));
					addSequential(new AutoDriveCommand(47.0));
					addSequential(new DriveTurnCommand("R"));
					addParallel(new AutoDriveCommand(15));
					addParallel(new ArmAutoCommand("I"));
					addSequential(new AutoDriveCommand(9.0));
					addSequential(new CubeAutoCommand("O"));
					
    			} else{ //CENTER POSITION RIGHT SWITCH
				
    				addSequential(new AutoDriveCommand(55.75));
					addSequential(new DriveTurnCommand("R"));
					addSequential(new AutoDriveCommand(37.0));
					addSequential(new DriveTurnCommand("L"));
					addParallel(new AutoDriveCommand(48.0));//check
					addParallel(new ArmAutoCommand("O"));
					addSequential(new CubeAutoCommand("O"));
					addSequential(new AutoDriveCommand(-6.0));
					addSequential(new DriveTurnCommand("R"));
					addSequential(new AutoDriveCommand(62.0));
					addSequential(new DriveTurnCommand("L"));
					addSequential(new AutoDriveCommand(47.0));
					addSequential(new DriveTurnCommand("L"));
					addParallel(new AutoDriveCommand(15));
					addParallel(new ArmAutoCommand("I"));
					addSequential(new AutoDriveCommand(9.0));
					addSequential(new CubeAutoCommand("O"));
				
    			}
    			
    		} else if(robotPosReq == "L"){ //LEFT POSITION AUTO CODE
    			
    			if(gameDataReq.charAt(0) == 'L'){ //LEFT POSITION LEFT SWITCH
    				//24
    				addSequential(new DefiniteFix(4));
	    			//addSequential(new AutoDriveCommand(133.75));//133.75
					addSequential(new DriveTurnCommand("R"));
					addSequential(new DefiniteFix(1));
					//addSequential(new AutoDriveCommand(24.56));//drive to switch*****
					addSequential(new CubeAutoCommand("O"));
					/**addSequential(new AutoDriveCommand(-6.0));
					addSequential(new DriveTurnCommand("L"));
					addSequential(new AutoDriveCommand(51.0));
					addSequential(new DriveTurnCommand("R"));
					addParallel(new AutoDriveCommand(13.0));
					addSequential(new DriveTurnCommand("R"));
					addSequential(new AutoDriveCommand(15.0));
					addParallel(new ArmAutoCommand("I"));
					addSequential(new CubeAutoCommand("I"));
					addSequential(new AutoDriveCommand(9.0));
					addParallel(new ArmAutoCommand("O"));
					addSequential(new CubeAutoCommand("O"));
					**/
					
    			
    			} else{ //LEFT POSITION RIGHT SWITCH
    			
    				addSequential(new AutoDriveCommand(185.0));
    				addSequential(new DriveTurnCommand("R"));
					addSequential(new AutoDriveCommand(187.0));
					addSequential(new DriveTurnCommand("R"));
					addSequential(new AutoDriveCommand(50.0));
					addSequential(new DriveTurnCommand("R"));
					addSequential(new AutoDriveCommand(11.0));
					addSequential(new CubeAutoCommand("O"));
					addSequential(new AutoDriveCommand(-6.0));
					addSequential(new DriveTurnCommand("R"));
					addSequential(new AutoDriveCommand(50.0));
					addSequential(new DriveTurnCommand("L"));
					addSequential(new AutoDriveCommand(13.0));
					addSequential(new DriveTurnCommand("L"));
					addSequential(new AutoDriveCommand(15.0));
					addParallel(new ArmAutoCommand("I"));
					addSequential(new CubeAutoCommand("I"));
					addParallel(new ArmAutoCommand("O"));
					addParallel(new AutoDriveCommand(10.0));
					addSequential(new CubeAutoCommand("O"));
    			
    			}
    		}
    			
    		} else if(robotPosReq == "R"){ //RIGHT POSITION AUTO CODE
    			
    			if(gameDataReq.charAt(0) == 'L'){ //RIGHT POSITION LEFT SWITCH

    				addSequential(new AutoDriveCommand(218.0));
    				addSequential(new DriveTurnCommand("L"));
					addSequential(new AutoDriveCommand(161.0));
					addSequential(new DriveTurnCommand("L"));
					addSequential(new AutoDriveCommand(51.0));
					addSequential(new DriveTurnCommand("L"));
					addSequential(new AutoDriveCommand(43.0));
					addSequential(new CubeAutoCommand("O"));
					addSequential(new AutoDriveCommand(-6.0));
					addSequential(new DriveTurnCommand("L"));
					addSequential(new AutoDriveCommand(51.0));
					addSequential(new DriveTurnCommand("R"));
					addSequential(new AutoDriveCommand(12.0));
					addSequential(new DriveTurnCommand("R"));
					addSequential(new AutoDriveCommand(15.0));
					addParallel(new ArmAutoCommand("I"));
					addSequential(new CubeAutoCommand("I"));
					addParallel(new ArmAutoCommand("O"));
					addParallel(new AutoDriveCommand(10.0));
					addSequential(new CubeAutoCommand("O"));
    			
    			} else{ //RIGHT POSITION RIGHT SWITCH
    			
    				addSequential(new AutoDriveCommand(133.75));
					addSequential(new DriveTurnCommand("L"));
					addSequential(new AutoDriveCommand(24.56));//drive to switch*****
					addSequential(new CubeAutoCommand("O"));
					addSequential(new AutoDriveCommand(-6.0));
					addSequential(new DriveTurnCommand("R"));
					addSequential(new AutoDriveCommand(51.0));
					addSequential(new DriveTurnCommand("L"));
					addParallel(new AutoDriveCommand(13.0));
					addSequential(new DriveTurnCommand("L"));
					addSequential(new AutoDriveCommand(15.0));
					addParallel(new ArmAutoCommand("I"));
					addSequential(new CubeAutoCommand("I"));
					addSequential(new AutoDriveCommand(9.0));
					addParallel(new ArmAutoCommand("O"));
					addSequential(new CubeAutoCommand("O"));
    			
    			}
    		}
    }
} 	

    

