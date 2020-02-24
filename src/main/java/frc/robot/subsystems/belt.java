/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class belt extends SubsystemBase {

  private final DigitalInput bottomLim = new DigitalInput(Constants.BLimport);
  private final TalonSRX belt = new TalonSRX(Constants.beltsport);
  private final Ultrasonic UTS = new Ultrasonic(Constants.Uts1, Constants.Uts2);
  AnalogPotentiometer ussr = new AnalogPotentiometer(Constants.ultrasonicport, 360, 30);

  public belt() {
  }
  public boolean bottomisPressed() {
    // if(UTS.getRangeMM() < 30){
    //   return false;
    // } else {
    //   return true;
    // }
    return bottomLim.get();
  }
  public void startbelt(){
    belt.set(ControlMode.PercentOutput, 1);
  }
  public void stopbelt(){
    belt.set(ControlMode.PercentOutput, -0);
  }
  public double logUSSR() {
    SmartDashboard.putNumber("Ultrasonic Sensor", ussr.get());
    return ussr.get();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
