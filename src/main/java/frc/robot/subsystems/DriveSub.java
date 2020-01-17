/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveSub extends SubsystemBase {
  /**
   * Creates a new DriveSub.
   */

  private final SpeedController leftDrive =
  new SpeedControllerGroup(new WPI_TalonSRX(0), new WPI_TalonSRX(2));

  private final SpeedController rightDrive =
  new SpeedControllerGroup(new WPI_TalonSRX(4), new WPI_TalonSRX(3));

  private final DifferentialDrive tankieDrivie = new DifferentialDrive(leftDrive, rightDrive);

  private final ADXRS450_Gyro gyro = new ADXRS450_Gyro();
  
  public double Squareinput(double inputspeed){
    double outputspeed = 0;

    if (inputspeed >0){
     outputspeed = inputspeed * inputspeed;
    }else{
      outputspeed = -1*(inputspeed * inputspeed);
    }
    return outputspeed;
  } 

  public void tankdrive(double left, double right) {
    tankieDrivie.tankDrive(left, right);

  }
  public void arcadeDrive(double forward, double rotation){
    tankieDrivie.arcadeDrive(forward, rotation);
  }
  public double getangle(){
    return gyro.getAngle();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
