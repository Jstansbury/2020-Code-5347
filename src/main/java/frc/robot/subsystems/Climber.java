/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Climber extends SubsystemBase {
  /**
   * Creates a new Climber.
   */
  private final TalonSRX Winch = new TalonSRX(Constants.winchport);
  private final TalonSRX RopePull = new TalonSRX(Constants.ropepullport);

  public Climber() {

  }

  public void winchUp() {
    Winch.set(ControlMode.PercentOutput, 1);
  }

  public void winchDown() {
    Winch.set(ControlMode.PercentOutput, -1);
  }

  public void ropeRetract() {
    RopePull.set(ControlMode.PercentOutput, 1);
  }

  public void stopInTheNameOfTheLawWINCHEDITION() {
    Winch.set(ControlMode.PercentOutput, 0);
  }

  public void stopInTheNameOfTheLawROPEDITION() {
    RopePull.set(ControlMode.PercentOutput, 0);
  }
  

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
