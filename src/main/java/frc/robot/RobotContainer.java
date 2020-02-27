/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.controller.PIDController;
import frc.robot.commands.DriveDistance;
import frc.robot.commands.BeltF;
import frc.robot.commands.ClimbBarCMD;
import frc.robot.commands.ClimbCombo;
import frc.robot.commands.ElevatorDownCMD;
import frc.robot.commands.ElevatorUpCMD;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.GoToColor;
import frc.robot.commands.IntakeCMD;
//import frc.robot.commands.IntakeCMD;
//import frc.robot.commands.Matthewisbestfromjayson;
import frc.robot.commands.ShooterCmd;
import frc.robot.commands.ShootnRoll;
import frc.robot.commands.ShowValues;
import frc.robot.commands.TankDrive;
import frc.robot.subsystems.ColorWheel;
import frc.robot.subsystems.DriveSub;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.IntakeSub;
import frc.robot.subsystems.NetworkTableFun;
//import frc.robot.subsystems.IntakeSub;
import frc.robot.commands.TogglePneu;
import frc.robot.commands.barout;
//import frc.robot.commands.beltCMD;
import frc.robot.commands.sliftDownCMD;
import frc.robot.commands.sliftUpCMD;
import frc.robot.commands.Matthewisbestfromjayson;
import frc.robot.commands.RollerCMD;
import frc.robot.commands.RotationCMD;
import frc.robot.commands.RotationGrp;
import frc.robot.commands.PID2Vision;
import frc.robot.commands.ShooterCmd;
import frc.robot.commands.TankDrive;
import frc.robot.commands.beltCMD;
import frc.robot.commands.happyvalentinesLOSER;
import frc.robot.subsystems.BeaverLift;
import frc.robot.subsystems.ClimbEle;
import frc.robot.subsystems.ClimberBar;
import frc.robot.subsystems.DriveSub;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.IntakeSub;
import frc.robot.subsystems.NetworkTableFun;
import frc.robot.subsystems.RollerSub;
import frc.robot.subsystems.liftsub;
import frc.robot.subsystems.Shooter;
//import frc.robot.subsystems.belt;
import frc.robot.subsystems.belt;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.POVButton;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a "declarative" paradigm, very little robot logic should
 * actually be handled in the {@link Robot} periodic methods (other than the
 * scheduler calls). Instead, the structure of the robot (including subsystems,
 * commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  Joystick m_JoystickLeft = new Joystick(Constants.leftJoystickport);
  Joystick m_JoystickRight = new Joystick(Constants.rightJoystickport);
  private final XboxController m_LogibleghGenericHID = new XboxController(Constants.LogibleghPort);
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  private final DriveSub m_driveSub = new DriveSub();
  private final Shooter m_Shooter = new Shooter();
  private final RollerSub m_Roller = new RollerSub();
  private final IntakeSub m_intake = new IntakeSub();
  private final BeaverLift m_beverLift = new BeaverLift();
  private final liftsub m_liftsub = new liftsub();
  private final belt m_Belt = new belt();
  private final NetworkTableFun m_NetworkTableFun = new NetworkTableFun();
  private final ClimberBar m_ClimberBar = new ClimberBar();
  private final ClimbEle m_ClimbEle = new ClimbEle();
  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);
  private final NetworkTableFun m_networktablefun = new NetworkTableFun();

  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    m_driveSub.setDefaultCommand(new TankDrive(() -> -m_LogibleghGenericHID.getRawAxis(1), () -> -m_LogibleghGenericHID.getRawAxis(0), m_driveSub));
    //m_Belt.setDefaultCommand(new beltCMD(m_Belt));
    m_NetworkTableFun.setDefaultCommand(new ShowValues(m_NetworkTableFun));

    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be
   * created by instantiating a {@link GenericHID} or one of its subclasses
   * ({@link edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then
   * passing it to a {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    new JoystickButton(m_JoystickRight, 1).whileHeld(new ShootnRoll(m_Shooter, m_Roller, m_Belt));
    new JoystickButton(m_LogibleghGenericHID, 7).whileHeld(new ShooterCmd(m_Shooter, 154));
    
    new JoystickButton(m_JoystickLeft, 1).whileHeld(new IntakeCMD(m_intake));
    new JoystickButton(m_LogibleghGenericHID, 8).whileHeld(new IntakeCMD(m_intake));

    new JoystickButton(m_JoystickLeft, 2).whileHeld(new sliftUpCMD(m_liftsub));
    new POVButton(m_LogibleghGenericHID, 0).whileHeld(new sliftUpCMD(m_liftsub));

    new JoystickButton(m_JoystickRight, 2).whileHeld(new sliftDownCMD(m_liftsub));
    new POVButton(m_LogibleghGenericHID, 180).whileHeld(new sliftDownCMD(m_liftsub));

    new JoystickButton(m_JoystickRight, 3).whileHeld(new BeltF(m_Belt));
    new JoystickButton(m_LogibleghGenericHID, 5).whileHeld(new BeltF(m_Belt));

    new JoystickButton(m_JoystickRight, 9).whenPressed(new happyvalentinesLOSER(m_driveSub, 90));
    new JoystickButton(m_LogibleghGenericHID, 9).whenPressed(new happyvalentinesLOSER(m_driveSub, 90));

    new JoystickButton(m_JoystickLeft, 7).whenPressed(new TogglePneu(m_beverLift));
    new JoystickButton(m_LogibleghGenericHID, 4).whenPressed(new TogglePneu(m_beverLift));

    new JoystickButton(m_LogibleghGenericHID, 6).whileHeld(new RollerCMD(m_Roller));

    new JoystickButton(m_LogibleghGenericHID, 10).whenPressed(new RotationGrp(m_networktablefun.GivemeAYaw(), m_driveSub));

    new JoystickButton(m_LogibleghGenericHID, 2).whileHeld(new ElevatorUpCMD(m_ClimbEle));

    new JoystickButton(m_LogibleghGenericHID, 11).whileHeld(new ClimbCombo(m_ClimbEle, m_ClimberBar));

    new JoystickButton(m_JoystickLeft, 11).whileHeld(new ClimbBarCMD(m_ClimberBar));
    new JoystickButton(m_LogibleghGenericHID, 3).whileHeld(new barout(m_ClimberBar));

    new JoystickButton(m_JoystickLeft, 9).whileHeld(new ElevatorDownCMD(m_ClimbEle));

    
  }



  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }
}
