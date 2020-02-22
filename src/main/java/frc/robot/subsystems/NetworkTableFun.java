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
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class NetworkTableFun extends SubsystemBase {
  /**
   * Creates a new NetworkTableFun.
   */
  public NetworkTable table;
  public NetworkTableEntry m_yaw;
  public NetworkTableInstance Visiontable;

   

  public NetworkTableFun() {

  }

  public void Tableinit(){
   


  }
  public void TableRun(){
    NetworkTableInstance Visiontable = NetworkTableInstance.getDefault();
    NetworkTable table = Visiontable.getTable("chameleon-vision").getSubTable("Microsoft LifeCam HD-3000");
    NetworkTableEntry m_yaw = table.getEntry("targetYaw");
    SmartDashboard.putNumber("YAW", m_yaw.getDouble(0.0));    
    NetworkTableEntry m_pitch = table.getEntry("targetPitch");
    SmartDashboard.putNumber("YAW", m_pitch.getDouble(0.0));

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
