package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

public class IntakeRetract extends SequentialCommandGroup {

  public IntakeRetract() {
    addCommands(new IntakeMotor(0), new IntakeActuator(0));
  }
}
