package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;

public class SwitchMode extends InstantCommand {
  private int mode;

  public SwitchMode(int mode) {
    this.mode = mode;
  }

  @Override
  public void initialize() {
    Drive.mode = mode;
  }
}
