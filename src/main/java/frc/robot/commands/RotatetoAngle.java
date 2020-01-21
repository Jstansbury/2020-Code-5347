/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import edu.wpi.first.wpiutil.math.MathUtil;
import frc.robot.Constants;
import frc.robot.subsystems.DriveSub;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class RotatetoAngle extends PIDCommand {
  /**
   * Creates a new RotatetoAngle.
   */
  public RotatetoAngle(Double Angle, DriveSub drive) {
    super(
        // The controller that the command will use
        new PIDController(Constants.krotationP, Constants.krotationI, Constants.krotationD),
        // This should return the measurement
        drive::getangle,
        // This should return the setpoint (can also be a constant)
        Angle,
        // This uses the output
        output -> {
          drive.arcadeDrive(0, MathUtil.clamp(output, -1, 1));
          // Use the output here
        });
        addRequirements(drive);
    // Use addRequirements() here to declare subsystem dependencies.
    // Configure additional PID options by calling `getController` here.
    getController().setTolerance(1);
    getController().enableContinuousInput(-180, 180);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
