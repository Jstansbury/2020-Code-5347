/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveSub extends SubsystemBase {
  /**
   * Creates a new DriveSub.
   */

  private final SpeedController leftDrive =
  new SpeedControllerGroup(new WPI_TalonSRX(0), new WPI_TalonSRX(2));

  private final SpeedController rightDrive =
  new SpeedControllerGroup(new WPI_TalonSRX(4), new WPI_TalonSRX(3));

  private final DifferentialDrive tankieDrivie = new DifferentialDrive(leftDrive, rightDrive);

  public final PIDController pid_drivedistance = new PIDController(Constants.drivedistancekP, Constants.drivedistancekI, Constants.drivedistancekD);
  

  public final static Encoder encoderLeft = new Encoder(1, 2);
  public final static Encoder encoderRight = new Encoder(3, 4);
  public final static ADXRS450_Gyro gyro = new ADXRS450_Gyro();


  public double Squareinput(double inputspeed){
    double outputspeed = 0;

    if (inputspeed >0){
     outputspeed = inputspeed * inputspeed;
    }else{
      outputspeed = -1*(inputspeed * inputspeed);
    }
    return outputspeed;
  } 

  public void drive(double left, double right) {
    tankieDrivie.tankDrive(left, right);
  }
  public double getCurrentpos(){
    double currentPos = (encoderLeft.getDistance() + encoderRight.getDistance())/2;
    return currentPos;
  }
  public void driveDistance(double inches) {
    double kP = 0;
    double kI = 0;
    double kD = 0;
    // Creates a PIDController with gains kP, kI, and kD
    PIDController pid = new PIDController(kP, kI, kD);
    tankieDrivie.tankDrive(pid.calculate(encoderLeft.getDistance(), inches), pid.calculate(encoderRight.getDistance(), inches));
  }

  public void driveAngle(double degrees) {
    double kP = 0;
    double kI = 0;
    double kD = 0;
    PIDController pid = new PIDController(kP, kI, kD);
    tankieDrivie.tankDrive(pid.calculate(gyro.getAngle(), degrees), -pid.calculate(gyro.getAngle(), degrees));
  }

  public Double gettingTheAngle() {
    double currentAngle = gyro.getAngle();
    return currentAngle;
  }

  public void stopDriving() {
    tankieDrivie.tankDrive(0, 0);
  }

  public double encoderAsInches(Encoder encoder) {
    return encoder.getDistance();
  }

  public void encoderInit(Encoder encoder) {
    encoder.setDistancePerPulse(Math.PI*6/5);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
