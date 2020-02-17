/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpiutil.math.MathUtil;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.SPI;

public class DriveSub extends SubsystemBase {
  /**
   * Creates a new DriveSub.
   */

   private final PIDController pidAngle = new PIDController(Constants.kPa, Constants.kIa, Constants.kDa);
   private final AHRS ahrs = new AHRS(SPI.Port.kMXP);


  private final SpeedController leftDrive =
  new SpeedControllerGroup(new WPI_TalonSRX(Constants.leftdriveport1), new WPI_TalonSRX(Constants.leftdriveport2));

  private final SpeedController rightDrive =
  new SpeedControllerGroup(new WPI_TalonSRX(Constants.rightdriveport1), new WPI_TalonSRX(Constants.rightdriveport2));

  private final DifferentialDrive tankieDrivie = new DifferentialDrive(leftDrive, rightDrive);

  private final Encoder leftEncoder = new Encoder(Constants.encoderleftport1, Constants.encoderleftport2);
  private final Encoder rightEncoder = new Encoder(Constants.encoderrightport1, Constants.encoderrightport2);
  

  public DriveSub() {
    pidAngle.setTolerance(1);
    pidAngle.enableContinuousInput(-180, 180);
    

  }
  public boolean getOnTarget(){
    return pidAngle.atSetpoint();
  }
  public double Squareinput(double inputspeed){
    double outputspeed = 0;

    if (inputspeed > 0) {
     outputspeed = -1*(inputspeed * inputspeed*inputspeed);
    } else {
      outputspeed = -1 * (inputspeed * inputspeed* inputspeed);
    }
    return outputspeed;
  } 

  public void drive(double left, double right) {
    tankieDrivie.arcadeDrive(left, -right);
  }

  public void resetGyro(){
    ahrs.reset();
  }

  public void PIDloop(double angle) {
    tankieDrivie.arcadeDrive(0, MathUtil.clamp(pidAngle.calculate(ahrs.getAngle(), angle), -1, 1));
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
