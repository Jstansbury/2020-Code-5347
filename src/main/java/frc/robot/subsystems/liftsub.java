/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class liftsub extends SubsystemBase {
  AnalogPotentiometer pot = new AnalogPotentiometer(Constants.potentiometerport, 360, 30);

    // creates
    private final TalonSRX actuator = new TalonSRX(Constants.actuatorport);
  public liftsub() {

  }
  public void startslift() {
      actuator.set(ControlMode.PercentOutput, -0.5);
  }

  public void stopslift() {
      actuator.set(ControlMode.PercentOutput, 0);
  }
  public double logPot() {
    SmartDashboard.putNumber("Potentiometer", pot.get());
    return pot.get();
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
