/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Shooter;

public class ShooterCmd extends CommandBase {
  /**
   * Creates a new ShooterCmd.
   */
  private final Shooter m_Shooter;
  private final double m_velocity;

  public ShooterCmd(Shooter subsystem, double velocity) {
    m_velocity = velocity;
    m_Shooter = subsystem;
    addRequirements(m_Shooter);
    // Use addRequirements() here to declare subsystem dependencies.
  }
 
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_Shooter.shootinit();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    //m_Shooter.spinup();
    m_Shooter.spinupRPM(m_velocity);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_Shooter.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
