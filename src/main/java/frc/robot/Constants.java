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
    public static int leftJoystickport = 0;
    public static int rightJoystickport = 1;
    public static int leftdriveport1 = 3;
    public static int leftdriveport2 = 4;
    public static int rightdriveport1 = 2;
    public static int rightdriveport2 = 0;

    public static int tailport = 6;
  
    public static int LeftShootPort = 1;
    public static int RightShootPort = 5;
	public static int actuatorport = 7;
	public static int kactuatorP = 0;
	public static int kactuatorI = 0;
	public static int kactuatorD = 0;
	public static int potentiometerport = 0;

}
