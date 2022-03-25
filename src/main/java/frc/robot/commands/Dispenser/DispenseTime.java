// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Dispenser;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class DispenseTime extends CommandBase {

  private double duration;
  private Timer timer;

  public DispenseTime(double duration) {
    addRequirements(RobotContainer.dispenser);
    this.duration = duration;
    this.timer = new Timer();
    timer.start();
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    RobotContainer.dispenser.set(Constants.kDispenserSpeed);
  }

  @Override
  public void end(boolean interrupted) {
    RobotContainer.dispenser.set(0);
  }

  @Override
  public boolean isFinished() {
    return timer.hasElapsed(duration);
  }
}
