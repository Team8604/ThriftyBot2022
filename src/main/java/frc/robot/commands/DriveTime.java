// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class DriveTime extends CommandBase {

  private double moveSpeed;
  private double duration;
  private Timer timer;

  public DriveTime(double moveSpeed, double duration) {
    addRequirements(RobotContainer.chassis);
    this.moveSpeed = moveSpeed;
    this.duration = duration;
    timer = new Timer();
    timer.start();
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    RobotContainer.chassis.setMotorSafety(false);
    RobotContainer.chassis.arcadeDrive(moveSpeed, 0);
  }

  @Override
  public void end(boolean interrupted) {
    RobotContainer.chassis.set(0, 0);
    RobotContainer.chassis.setMotorSafety(true);
  }

  @Override
  public boolean isFinished() {
    return timer.hasElapsed(duration);
  }
}
