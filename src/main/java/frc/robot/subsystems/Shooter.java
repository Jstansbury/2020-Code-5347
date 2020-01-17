/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;


import com.ctre.phoenix.motorcontrol.*;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Shooter extends SubsystemBase {
  private final TalonSRX Leftshoot = new TalonSRX(1);
  private final TalonSRX Rightshoot = new TalonSRX(5);
  

  /**
   * Creates a new Shooter.
   */

  public void shootinit() {
    Rightshoot.follow(Leftshoot);
  } 
  public void spinup() {
    Leftshoot.set(ControlMode.PercentOutput, -1);
   
  }

  public void stop() {
    Leftshoot.set(ControlMode.PercentOutput, 0);
   
  }

  public Shooter() {

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
