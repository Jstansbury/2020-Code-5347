/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.AnalogInput;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    public static int BLimport = 5;
	public static int leftJoystickport = 0;
    public static int rightJoystickport = 1;
    public static int LogibleghPort = 2;


    public static int leftdriveport1 = 8;
    public static int leftdriveport2 = 7;
    public static int rightdriveport1 = 1;
    public static int rightdriveport2 = 2;

    public static int tailport = 4;
    public static int beltsport = 3;
    public static int rollerport = 6;

    public static int LeftShootPort = 9;
    public static int RightShootPort = 5;
    public static int actuatorport = 0;
    
    public static int potentiometerport = 0;
    public static double lowerlimit = 110;
    public static double upperlimit = 370;  
    
    public static int CompressorPort = 11;

    public static int TestMototPort = 2; 

    public static double kPa = 0.094;
    public static double kIa = 0;
    public static double kDa = 0;

    public static int encoderleftport1 = 0;
    public static int encoderleftport2 = 1;
    public static int encoderrightport1 = 2;
    public static int encoderrightport2 = 3;

    public static int SolF = 0;
    public static int SolR = 1;

    public static int Uts1 = 6;
    public static int Uts2 = 7;

    public static int kVelocityIdx = 0;
    public static double kVelocityP = 0;
    public static double kVelocityI = 0;
    public static double kVelocityD = 0;
    public static double kVelocityF = 5.5;
    public static int kTimeoutMs =0;


    public static int colorport = 1;

    public static double krotationP = 0;
    public static double krotationI = 0;
    public static double krotationD = 0;

    public static double kdistanceP = 0;
    public static double kdistanceI = 0;
    public static double kdistanceD = 0;
    public static int ultrasonicport = 3;

    public static double kactuatorP = 0.008;
	public static double kactuatorI = 0;
	public static double kactuatorD = 0;
    public static int BarturnerPort = 12;
    public static int SpoolPort = 0;
}
