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
    // y=-23.6*(x)+822.2 voltage 
  } // c == 25" b == 20" 
  public double eqPotH(Double angle) {
    return ((1000*Math.sin(angle)- 225)*-1);
  }

  public double potVoltage(double angle) {
    angle = (1000*Math.sin(angle)- 225)*-1;
    return 23.6*eqPotH(angle)+822.2;
  }

  public double voltageofPot() {
    return 0;

  }
  public void startsliftUP() {
      actuator.set(ControlMode.PercentOutput, 0.7);
  }
  public void startsliftDOWN() {
    actuator.set(ControlMode.PercentOutput, -0.7);
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
