/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.controller.ProfiledPIDController;
import edu.wpi.first.wpilibj.trajectory.TrapezoidProfile;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import edu.wpi.first.wpilibj2.command.ProfiledPIDCommand;
import edu.wpi.first.wpiutil.math.MathUtil;
import frc.robot.Constants;
import frc.robot.subsystems.DriveSub;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class DriveDistance extends ProfiledPIDCommand {
  /**
   * Creates a new DriveDistance.
   */
  public DriveDistance(double DistancetoDrive, DriveSub drive) {
    super(
        // The ProfiledPIDController used by the command
        new ProfiledPIDController(
            // The PID gains
            Constants.kdistanceP, Constants.kdistanceI, Constants.kdistanceD,
            // The motion profile constraints
            new TrapezoidProfile.Constraints(120, 240)),
        // This should return the measurement
        drive::getaveragedistace,
        // This should return the goal (can also be a constant)
        drive.setsetpoint(DistancetoDrive),
        // This uses the output
        (output, setpoint) -> {
              drive.arcadeDrive(MathUtil.clamp(output,-1, 1), 0);
          // Use the output (and setpoint, if desired) here
            },
        drive);
    // Use addRequirements() here to declare subsystem dependencies.
    // Configure additional PID options by calling `getController` here.
    getController().setTolerance(1);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return getController().atGoal();
  }
}
