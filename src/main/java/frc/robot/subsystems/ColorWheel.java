/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import com.revrobotics.ColorSensorV3; 


public class ColorWheel extends SubsystemBase {
  /**
   * Creates a new ColorWheel.
   */
  private final I2C.Port port = I2C.Port.kOnboard;
  private final TalonSRX wheelSpinner = new TalonSRX(Constants.colorport);
  private final ColorSensorV3 Sensor = new ColorSensorV3(port);
  
  public ColorWheel() {

  }

  public Color getcolor(){
    return Sensor.getColor();
  }
  
  public void doSpin() {
    wheelSpinner.set(ControlMode.PercentOutput, -1);
  }

  public void stopSpin() {
    wheelSpinner.set(ControlMode.PercentOutput, 0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
