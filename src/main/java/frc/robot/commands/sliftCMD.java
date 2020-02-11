/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.liftsub;

public class sliftCMD extends CommandBase {

  /**
   * Creates a new ShooterCmd.
   */
  private final liftsub m_liftsub;

  public sliftCMD(liftsub subsystem) {
    m_liftsub = subsystem;
    addRequirements(m_liftsub);
    // Use addRequirements() here to declare subsystem dependencies.
  }
 
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_liftsub.startslift();
    m_liftsub.logPot();
    SmartDashboard.putNumber("Potentiometer5", 5);
    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_liftsub.stopslift();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if(m_liftsub.logPot() < Constants.lowerlimit){
      return true;
    } else if (m_liftsub.logPot() > Constants.upperlimit){
      return false;
    }
    return false;
  }
}
