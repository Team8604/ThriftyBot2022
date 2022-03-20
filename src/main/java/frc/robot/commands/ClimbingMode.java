package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.RobotContainer;

public class ClimbingMode extends InstantCommand {

  private boolean value;

  public ClimbingMode(boolean value) {
    this.value = value;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    RobotContainer.chassis.climbingMode = value;
  }
}
