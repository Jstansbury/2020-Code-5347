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
    public static int leftJoystickport = 0;
    public static int rightJoystickport = 1;



    public static double krotationP = 0.1;
    public static double krotationI = 0;
    public static double krotationD = 0;

    public static double kdistanceP = .12;
    public static double kdistanceI = 0;
    public static double kdistanceD = 0;


    public static int kVelocityIdx = 0;
    public static double kVelocityP = 0;
    public static double kVelocityI = 0;
    public static double kVelocityD = 0;


    public static int ColorSenPort = 5;
    public static int leftdriveport1 = 3;
    public static int leftdriveport2 = 4;
    public static int rightdriveport1 = 2;
    public static int rightdriveport2 = 0;
    public static int tailport = 6;
    public static int colorport = 8;
}
