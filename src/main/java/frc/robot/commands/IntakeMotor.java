package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.RobotContainer;

public class IntakeMotor extends InstantCommand {
  private double speed;

  public IntakeMotor(double speed) {
    addRequirements(RobotContainer.intake);
    this.speed = speed;
  }

  @Override
  public void initialize() {
    RobotContainer.intake.set(speed);
  }
}
