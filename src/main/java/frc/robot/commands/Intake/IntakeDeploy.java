package frc.robot.commands.Intake;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Constants;
import frc.robot.commands.BallTunnel.BallTunnelRun;

public class IntakeDeploy extends SequentialCommandGroup {

  public IntakeDeploy() {
    addCommands(new IntakeMotor(Constants.kIntakeSpeed), new BallTunnelRun(1), new IntakeActuator(Constants.kIntakeRotationTicks));
  }
}
