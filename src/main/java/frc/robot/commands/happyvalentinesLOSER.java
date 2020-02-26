/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSub;

public class happyvalentinesLOSER extends CommandBase {
  /**
   * Creates a new happyvalentinesLOSER.
   */

  private final DriveSub m_drivesub;
  private final double m_angle;

  public happyvalentinesLOSER(DriveSub subsystem, double angle) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_drivesub = subsystem;
    addRequirements(m_drivesub);

    m_angle = angle;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_drivesub.resetGyro();
    //m_drivesub.PIDloop(m_angle);

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_drivesub.PIDloop(m_angle);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false; 
    //return m_drivesub.getOnTarget();
  }
}
