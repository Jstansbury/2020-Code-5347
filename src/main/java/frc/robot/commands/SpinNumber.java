/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ColorWheel;

public class SpinNumber extends CommandBase {
  /**
   * Creates a new colorSense.
   */

  private final ColorWheel m_colorwheel;
  private Color originalColor;
  private Color nowColor;
  private Color beforeColor;
  private int x;

  public SpinNumber(ColorWheel subsystem) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_colorwheel = subsystem;
    addRequirements(m_colorwheel);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    x = 0;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_colorwheel.doSpin();
    Color nowColor = m_colorwheel.getcolor();
    if (nowColor == beforeColor) {
      return;
    }
    if (nowColor != beforeColor) {
      if (nowColor == originalColor) {
        x = x + 1;
      }
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_colorwheel.stopSpin();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if (x < 6) {
      return false;
    } else {
      return true;
    }
  }
}
