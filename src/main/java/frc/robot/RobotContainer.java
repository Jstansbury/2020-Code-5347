/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.IntakeCMD;
import frc.robot.commands.ShooterCmd;
import frc.robot.commands.TankDrive;
import frc.robot.commands.sliftCMD;
import frc.robot.subsystems.DriveSub;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.IntakeSub;
import frc.robot.subsystems.liftsub;
import frc.robot.subsystems.Shooter;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  Joystick m_JoystickLeft = new Joystick(Constants.leftJoystickport);
  Joystick m_JoystickRight = new Joystick(Constants.rightJoystickport);
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  private final DriveSub m_driveSub = new DriveSub();
  private final Shooter m_Shooter = new Shooter();
  private final IntakeSub m_intake = new IntakeSub(); 
  private final liftsub m_liftsub = new liftsub();
  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);


  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    m_driveSub.setDefaultCommand(new TankDrive(() -> m_JoystickLeft.getY(),
    () -> m_JoystickRight.getY(), m_driveSub));

    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    new JoystickButton(m_JoystickRight, 1).whileHeld(new ShooterCmd(m_Shooter)); 
    new JoystickButton(m_JoystickLeft, 1).whileHeld(new IntakeCMD(m_intake)); 
    new JoystickButton(m_JoystickLeft, 10).whileHeld(new sliftCMD(m_liftsub));

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
