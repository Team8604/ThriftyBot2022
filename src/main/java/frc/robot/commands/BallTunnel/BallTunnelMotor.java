package frc.robot.commands.BallTunnel;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.RobotContainer;

public class BallTunnelMotor extends InstantCommand {
  private double speed;

  public BallTunnelMotor(double speed) {
    addRequirements(RobotContainer.ballTunnel);
    this.speed = speed;
  }

  @Override
  public void initialize() {
    RobotContainer.ballTunnel.set(speed);
  }
}
