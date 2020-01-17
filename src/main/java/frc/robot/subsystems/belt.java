/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class belt extends SubsystemBase {

  private final DigitalInput bottomLim = new DigitalInput(4);
  private final DigitalInput topLim = new DigitalInput(5);
  private final TalonSRX belt = new TalonSRX(Constants.beltsport);
  public belt() {
  }
  public boolean bottomisPressed() {
    return bottomLim.get();
  }
  public boolean topisPressed() {
      return topLim.get();
  }

  public void startbelt(){
    belt.set(ControlMode.PercentOutput, 0.25);
  }
  public void stopbelt(){
    belt.set(ControlMode.PercentOutput, -0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
