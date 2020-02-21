/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class NetworkTableFun extends SubsystemBase {
  /**
   * Creates a new NetworkTableFun.
   */
  public NetworkTable table;
  public NetworkTableEntry yaw;
  public NetworkTableInstance Visiontable;

   

  public NetworkTableFun() {

  }

  public void Tableinit(){
    NetworkTableInstance Visiontable = NetworkTableInstance.getDefault();
    NetworkTable table = Visiontable.getTable("chameleon-vision").getSubTable("Microsoft LifeCam HD-3000");
    NetworkTableEntry yaw = table.getEntry("yaw");

  }

  @Override
  public void periodic() {
    //System.out.println(yaw.getDouble(0.0));

    // This method will be called once per scheduler run
  }
}
