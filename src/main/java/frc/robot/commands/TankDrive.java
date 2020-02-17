/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSub;

public class TankDrive extends CommandBase {
  /**
   * Creates a new TankDrive.
   */

    private final DriveSub m_drivetrain;
    private final DoubleSupplier m_left;
    private final DoubleSupplier m_right;
  
    /**
     * Creates a new TankDrive command.
     *
     * @param left       The control input for the left side of the drive
     * @param right      The control input for the right sight of the drive
     * @param drivetrain The drivetrain subsystem to drive
     */
    public TankDrive(DoubleSupplier left, DoubleSupplier right, DriveSub drivetrain) {
      m_drivetrain = drivetrain;
      m_left = left;
      m_right = right;
      addRequirements(m_drivetrain);
    }


// Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_drivetrain.drive(m_drivetrain.Squareinput(m_left.getAsDouble()), m_drivetrain.Squareinput(m_right.getAsDouble()));
    m_drivetrain.getaveragedistace();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_drivetrain.drive(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
