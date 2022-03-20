package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.RobotContainer;

public class DriveMode extends InstantCommand {

  private boolean climb;
  private boolean unlock;

  public DriveMode(boolean climb, boolean unlock) {
    this.climb = climb;
    this.unlock = unlock;
  }

  @Override
  public void initialize() {
    RobotContainer.chassis.climb = climb;
    RobotContainer.chassis.unlock = unlock;
  }
}
