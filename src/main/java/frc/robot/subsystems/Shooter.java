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
import frc.robot.Constants;

public class Shooter extends SubsystemBase {
  private final TalonSRX Leftshoot = new TalonSRX(Constants.LeftShootPort);
  private final TalonSRX Rightshoot = new TalonSRX(Constants.RightShootPort);
  

  /**
   * Creates a new Shooter.
   */

  public void shootinit() {
    Leftshoot.configPeakOutputForward(1, 0);
    Leftshoot.configPeakOutputReverse(-1, 0);
  } 
  public void spinupRPM(double targRPM) {
    double velocity = 4 * targRPM * .000016667 * 48;
    Leftshoot.set(ControlMode.Velocity, velocity);
  }
  public void spinup() {
    Leftshoot.set(ControlMode.PercentOutput, -.98);
   
  }

  public void stop() {
    Leftshoot.set(ControlMode.PercentOutput, 0);
   
  }

  public Shooter() {
    Rightshoot.follow(Leftshoot);
    Leftshoot.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, Constants.kVelocityIdx, 0);
    Leftshoot.configPeakOutputForward(1, 0);
    Leftshoot.configPeakOutputReverse(-1, 0);
    Leftshoot.config_kP(Constants.kVelocityIdx, Constants.kVelocityP, 0);
    Leftshoot.config_kI(Constants.kVelocityIdx, Constants.kVelocityI, 0);
    Leftshoot.config_kD(Constants.kVelocityIdx, Constants.kVelocityD, 0);

  }

  public void log(){

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
