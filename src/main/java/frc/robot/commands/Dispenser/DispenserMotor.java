package frc.robot.commands.Dispenser;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.RobotContainer;

public class DispenserMotor extends InstantCommand {
  private double speed;

  public DispenserMotor(double speed) {
    addRequirements(RobotContainer.dispenser);
    this.speed = speed;
  }

  @Override
  public void initialize() {
    RobotContainer.dispenser.set(speed);
  }
}
