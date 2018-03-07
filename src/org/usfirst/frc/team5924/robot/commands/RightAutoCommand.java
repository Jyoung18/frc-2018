package org.usfirst.frc.team5924.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class RightAutoCommand extends CommandGroup {
	
    public RightAutoCommand() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.
    	//gameData = DriverStation.getInstance().getGameSpecificMessage();
    	
    	//if(gameData.length() > 0){
    		
			//if(gameData.charAt(0) == 'L'){ 
    	
				addSequential(new AutoDriveCommand(40));
				addSequential(new DriveTurnRight());
				addSequential(new AutoDriveCommand(40));
				addSequential(new DriveTurnRight());
				addSequential(new AutoDriveCommand(40));
				addSequential(new DriveTurnRight());
				addSequential(new AutoDriveCommand(40));
				/**addParallel(new AutoDriveCommand());
				addParallel(new ArmAutoCommand());
				addSequential(new AutoDriveCommand());
				addSequential(new AutoDriveCommand());
				addSequential(new CubeAutoCommand());
				addSequential(new AutoDriveCommand());
				addSequential(new AutoDriveCommand());
				addSequential(new AutoDriveCommand());
				addParallel(new AutoDriveCommand());
				addSequential(new AutoDriveCommand());
				addSequential(new AutoDriveCommand());
				addSequential(new AutoDriveCommand());
				addSequential(new CubeAutoCommand());
				addSequential(new AutoDriveCommand());
				addSequential(new AutoDriveCommand());
				addSequential(new AutoDriveCommand());
				addParallel(new AutoDriveCommand());
				addSequential(new AutoDriveCommand());
				addSequential(new AutoDriveCommand());
				addSequential(new AutoDriveCommand());
				addSequential(new CubeAutoCommand());
				**/
			//} else{
				
				
			//	addSequential(new DriveTurnRight());
			//	addSequential(new AutoDriveCommand(40));
			//	addSequential(new DriveTurnRight());
			//	addSequential(new AutoDriveCommand(40));
				
				
			//}





        //To run multiple commands at the same time,
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
