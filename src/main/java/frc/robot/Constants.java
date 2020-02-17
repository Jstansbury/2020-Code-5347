/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

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
    public static int beltsport = 9;
    public static int rollerport = 6;

    public static int LeftShootPort = 3;
    public static int RightShootPort = 5;
    public static int actuatorport = 0;
    
    public static int potentiometerport = 0;
    public static double lowerlimit = 158;
    public static double upperlimit = 375;  
    
    public static int CompressorPort = 11;

    public static int TestMototPort = 2; 

    public static double kPa = .026;
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

}
