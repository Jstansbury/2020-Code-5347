/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import java.lang.Math;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class liftsub extends SubsystemBase {
    // creates
    private final TalonSRX actuator = new TalonSRX(Constants.actuatorport);
    private final int var = 0;

  public liftsub() {
    // y=-23.6*(x)+822.2 voltage 
  } // c == 25" b == 20" 
  public double eqPotH(int angle) {
    return ((1000*Math.sin(angle)- 225)*-1);
  }

  public double potVoltage(int var) {
    return 23.6*eqPotH(var)+822.2;
  }
  public void startslift() {
      actuator.set(ControlMode.PercentOutput, 0.5);
  }

  public void stopslift() {
      actuator.set(ControlMode.PercentOutput, 0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
