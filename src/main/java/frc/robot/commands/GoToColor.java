/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import com.revrobotics.ColorMatch;
import com.revrobotics.ColorMatchResult;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ColorWheel;

public class GoToColor extends CommandBase {
  /**
   * Creates a new GoToColor.
   */
  private final ColorWheel m_colorwheel;
  private String gameColor;
  private int x;
  private String colorString;

  private final ColorMatch m_colorMatcher = new ColorMatch();

  private final Color kBlueTarget = ColorMatch.makeColor(0.143, 0.427, 0.429);
  private final Color kGreenTarget = ColorMatch.makeColor(0.197, 0.561, 0.240);
  private final Color kRedTarget = ColorMatch.makeColor(0.561, 0.232, 0.114);
  private final Color kYellowTarget = ColorMatch.makeColor(0.361, 0.524, 0.113);
  
  public GoToColor(final ColorWheel subsystem) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_colorwheel = subsystem;
    addRequirements(m_colorwheel);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    gameColor = "Y"; //DriverStation.getInstance().getGameSpecificMessage();
    x = 0;

    m_colorMatcher.addColorMatch(kBlueTarget);
    m_colorMatcher.addColorMatch(kGreenTarget);
    m_colorMatcher.addColorMatch(kRedTarget);
    m_colorMatcher.addColorMatch(kYellowTarget); 

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    Color detectedColor = m_colorwheel.getcolor();
    m_colorwheel.doSpin();

    ColorMatchResult match = m_colorMatcher.matchClosestColor(detectedColor);
    
    if (match.color == kBlueTarget) {
      colorString = "Blue";
    } else if (match.color == kRedTarget) {
      colorString = "Red";
    } else if (match.color == kGreenTarget) {
      colorString = "Green";
    } else if (match.color == kYellowTarget) {
      colorString = "Yellow";
    } else {
      colorString = "Unknown";
    }

    SmartDashboard.putNumber("Red", detectedColor.red);
    SmartDashboard.putNumber("Green", detectedColor.green);
    SmartDashboard.putNumber("Blue", detectedColor.blue);
    SmartDashboard.putNumber("Confidence", match.confidence);
    SmartDashboard.putString("Detected Color", colorString);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_colorwheel.stopSpin();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {  

    if (gameColor == "Y") {
      if (colorString == "Red") { //now color is an int not a b, put numbers here
          return true;
      }
      else {
        return false;
      }
    }

    else if (gameColor == "G") {
      if (colorString == "Yellow") { //now color is an int not a b, put nu mbers here
          return true;
      }
      else {
        return false;
      }
    }

    else if (gameColor == "R") {
      if (colorString == "Green") { //now color is an int not a b, put numbers here
          return true;
      }
      else {
        return false;
      }
    }

    else if (gameColor == "Y") {
      if (colorString == "Blue") { //now color is an int not a b, put numbers here
          return true;
      }
      else {
        return false;
      }
    }
    else {
      return false;
    }
  }
}
