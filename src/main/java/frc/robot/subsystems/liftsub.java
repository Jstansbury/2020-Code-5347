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

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class liftsub extends SubsystemBase {
  AnalogPotentiometer pot = new AnalogPotentiometer(Constants.potentiometerport, 360, 30);

    // creates
  private final TalonSRX actuator = new TalonSRX(Constants.actuatorport);
  NetworkTableInstance table = NetworkTableInstance.getDefault();

  // Gets the MyCamName table under the chamelon-vision table
  // MyCamName will vary depending on the name of your camera
  NetworkTable cameraTable = table.getTable("chameleon-vision").getSubTable("MyCamName");
  // Gets the yaw to the target from the cameraTable
  public NetworkTableEntry yaw = cameraTable.getEntry("targetPitch");

  public double pitch() {
    NetworkTableInstance table = NetworkTableInstance.getDefault();

    // Gets the MyCamName table under the chamelon-vision table
    // MyCamName will vary depending on the name of your camera
    NetworkTable cameraTable = table.getTable("chameleon-vision").getSubTable("MyCamName");
    // Gets the yaw to the target from the cameraTable
    NetworkTableEntry pitch = cameraTable.getEntry("targetPitch");
    return 12.5;

  }
  public liftsub() {
    // y=-23.6*(x)+822.2 voltage 
  } // c == 25" b == 20" 
  public double potVoltage(double angle) {
    angle = (1000*Math.sin(angle)- 225)*-1;
    return 23.6*angle+822.2;
  }
  public double getcurrentangle() {
    return Math.asin((logPot() - 6132.2) / -23600);
  }

  public double targetangleandcurrentAngle(final double pitch) {
    return getcurrentangle() + pitch;
  }
  public void startslift(double speed) {
      actuator.set(ControlMode.PercentOutput, speed);
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
  public void inputAngle() {
    final NetworkTableInstance inst = NetworkTableInstance.getDefault();
    //get a reference to the subtable called "datatable"
    final NetworkTable table = inst.getTable("datatable");

    //get a reference to key in "datatable" called "Y"
    final NetworkTableEntry yEntry = table.getEntry("Y");
    inst.startClientTeam(5347);
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  }
