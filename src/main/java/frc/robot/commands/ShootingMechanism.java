/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.subsystems.IntakeSub;
import frc.robot.subsystems.RollerSub;
import frc.robot.subsystems.belt;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class ShootingMechanism extends ParallelCommandGroup {
  /**
   * Creates a new ShootingMechanism.
   */

  /*private final RollerSub m_rollersub;
  private final IntakeSub m_intakesub;
  private final belt m_beltsub;*/

  public ShootingMechanism(RollerSub m_rollersub, IntakeSub m_intakesub, belt m_beltsub) {
    // Add your commands in the super() call, e.g.
    // super(new FooCommand(), new BarCommand());super();
    addCommands(new RollerCMD(m_rollersub),
                new IntakeCMD(m_intakesub),
                new beltCMD(m_beltsub));
  }
}
