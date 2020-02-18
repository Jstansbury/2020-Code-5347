/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;


public class BeaverLift extends SubsystemBase {
  /**
   * Creates a new BeaverLift.
   */
  public static DoubleSolenoid Beaverlifter = new DoubleSolenoid(Constants.CompressorPort, Constants.SolF, Constants.SolR);
  public BeaverLift() {

  }

  public void toggle(){
    if(Beaverlifter.get() == DoubleSolenoid.Value.kForward) {
      Beaverlifter.set(DoubleSolenoid.Value.kReverse);

    } else if(Beaverlifter.get() == DoubleSolenoid.Value.kReverse) {
      Beaverlifter.set(DoubleSolenoid.Value.kForward);
    } else{
      Beaverlifter.set(DoubleSolenoid.Value.kForward);
    }
  }

  public void pushdown(){
    Beaverlifter.set(DoubleSolenoid.Value.kForward);

  }

  public void pushup(){
    Beaverlifter.set(DoubleSolenoid.Value.kForward);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
