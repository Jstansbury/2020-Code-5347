/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSub;

public class driveTo extends CommandBase {
  /**
   * Creates a new driveTo.
   */
  private final DriveSub m_drivetrain;
  private final Double m_inchDistance;
  private double encoder;
  private final PIDController m_pidloop;

  public driveTo(Double inchDistance, DriveSub drivetrain) {
    encoder = inchDistance;
    m_drivetrain = drivetrain;
    m_inchDistance = inchDistance;
    m_pidloop = m_drivetrain.pid_drivedistance;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_drivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    encoder = m_drivetrain.getCurrentpos();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_drivetrain.driveDistance(m_inchDistance - encoder);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_drivetrain.stopDriving();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return m_pidloop.atSetpoint();
  }
}
