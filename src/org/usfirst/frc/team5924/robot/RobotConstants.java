package org.usfirst.frc.team5924.robot;

public class RobotConstants {
	
		// MOTOR CONTROLLER ID
		public static int cFrontRight = 1; 
		public static int cRearRight = 2;
		public static int cRearLeft = 8; 
		public static int cFrontLeft = 9; 
		public static int cActuator = 3;
		public static int cCubeRight = 4;
		public static int cCubeLeft = 7;
		public static int cBackRampMotorRight = 8;
		public static int cBackRampMotorLeft = 9;
		public static int cFrontRampMotorRight = 10;
		public static int cFrontRampMotorLeft = 11;

		//JOYSTICK ID
		public static int cXboxJoy = 1;
		public static int cButtonPanel = 2;
		
		//AXIS
		public static int cXboxJoyYAxis = 1;
		public static int cXboxJoyXAxis = 4;
		public static int cButtonPanelAxis = 1;
		
		// POSITIONS
		public static double groundPosition = 20.0;
		public static double exchangePosition = 40.0;
		public static double switchPosition = 310.0;
		public static double startPosition = 390.0;
		public static double bRampDownPosition = 2220.0;
		public static double bRampVerticalPosition = 1024.0;
		public static double fRampDownPosition = 1536.0;
		
		//MOTOR SPEEDS
		public static double rightMotorOutput = -0.5;
		public static double leftMotorOutput = 0.5;
		public static double rampMotorOutput = 0.5;
		
		//BUTTON PANEL
		public static int groundPosButton = 3;
		public static int exchangePosButton = 5;
		public static int switchPosButton = 4;
		public static int startPosButton = 6;
		public static int intakeCubeButton = 7;
		public static int outtakeCubeButton = 9;
		public static int bFRampDownButton = 1;
		public static int bRampVerticalButton = 2;
		public static int switchControlMode = 11;
		public static int switchCubeState = 10;
}
