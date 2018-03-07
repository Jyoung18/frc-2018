package org.usfirst.frc.team5924.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CenterAutoCommand extends CommandGroup {

	String gameData;
	
    public CenterAutoCommand() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.
    	gameData = DriverStation.getInstance().getGameSpecificMessage();
    	
    	if(gameData.length() > 0){
    		
			if(gameData.charAt(0) == 'L'){ 
				addSequential(new AutoDriveCommand(15.0));
				addSequential(new AutoDriveCommand(15.0));
				addSequential(new AutoDriveCommand(15.0));
				addSequential(new AutoDriveCommand(15.0));
				addSequential(new AutoDriveCommand(15.0));
				addSequential(new CubeCommand());
				addSequential(new AutoDriveCommand(15.0));
				addSequential(new AutoDriveCommand(15.0));
				addParallel(new AutoDriveCommand(15.0));
				addParallel(new ArmAutoCommand());
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



				
				
				
				
			} else{
				
				addSequential(new AutoDriveCommand(15.0));
				addSequential(new AutoDriveCommand(15.0));
				addSequential(new AutoDriveCommand(15.0));
				addSequential(new AutoDriveCommand(15.0));
				addSequential(new AutoDriveCommand(15.0));
				addSequential(new CubeCommand());
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
