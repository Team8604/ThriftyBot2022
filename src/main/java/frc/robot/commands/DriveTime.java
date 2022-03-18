// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class DriveTime extends CommandBase {

  private double moveSpeed;
  private double rotateSpeed;
  private int duration;
  private int counter;

  public DriveTime(double moveSpeed, double rotateSpeed, int duration) {
    addRequirements(RobotContainer.chassis);
    this.moveSpeed = moveSpeed;
    this.rotateSpeed = rotateSpeed;
    this.duration = duration;
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    counter++;
    RobotContainer.chassis.arcadeDrive(moveSpeed, rotateSpeed);
  }

  @Override
  public void end(boolean interrupted) {
    RobotContainer.chassis.arcadeDrive(0, 0);
  }

  @Override
  public boolean isFinished() {
    return counter > duration;
  }
}
