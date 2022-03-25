package frc.robot.commands.Intake;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.BallTunnel.BallTunnelRun;

public class IntakeRetract extends SequentialCommandGroup {

  public IntakeRetract() {
    addCommands(new IntakeMotor(0), new BallTunnelRun(0), new IntakeActuator(0));
  }
}
