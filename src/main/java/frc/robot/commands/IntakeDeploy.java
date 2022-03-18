package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Constants;

public class IntakeDeploy extends SequentialCommandGroup {

  public IntakeDeploy() {
    addCommands(new IntakeMotor(Constants.kIntakeSpeed), new IntakeActuator(Constants.kIntakeRotationTicks));
  }
}
