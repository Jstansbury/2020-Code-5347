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

public class ClimberBar extends SubsystemBase {
  /**
   * Creates a new ClimberBar.
   */
  public static TalonSRX Barturner = new TalonSRX(Constants.BarturnerPort);

  public ClimberBar() {

  }

  public void ClimbUP(){
    Barturner.set(ControlMode.PercentOutput, 1);
  }

  public void STOP(){
    Barturner.set(ControlMode.PercentOutput, 0);
  }
  public void spoolback(){
    Barturner.set(ControlMode.PercentOutput, -.45);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
