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
import frc.robot.subsystems.liftsub;
// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class AqPID extends PIDCommand {
  /**
   * Creates a new DriveDistancePID.
   */
  public int angle;
  public AqPID(Double angle, liftsub m_liftsub) {
    super(
        // The controller that the command will use
        new PIDController(Constants.kactuatorP, Constants.kactuatorI, Constants.kactuatorD),
        // This should return the measurement
        m_liftsub::logPot,
        // This should return the setpoint (can also be a constant)
        m_liftsub.potVoltage(angle),
        // This uses the output
        output -> {
          m_liftsub.startslift(output);
          // Use the output here
        });
    // Use addRequirements() here to declare subsystem dependencies.
    // Configure additional PID options by calling `getController` here.
    addRequirements(m_liftsub);
    getController().setTolerance(1);

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return getController().atSetpoint();
  }
}