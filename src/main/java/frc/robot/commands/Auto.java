// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class Auto extends CommandBase {

  private Timer timer;

  public Auto() {
    addRequirements(RobotContainer.chassis, RobotContainer.dispenser);
    timer = new Timer();
    timer.start();
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    if(timer.hasElapsed(2)){
      RobotContainer.chassis.setMotorSafety(false);
      RobotContainer.chassis.arcadeDrive(0, 0.5);
      RobotContainer.dispenser.set(0);
    } else {
      RobotContainer.dispenser.set(Constants.kDispenserSpeed);
    }
  }

  @Override
  public void end(boolean interrupted) {
    RobotContainer.chassis.set(0, 0);
    RobotContainer.chassis.setMotorSafety(true);
  }

  @Override
  public boolean isFinished() {
    return timer.hasElapsed(5);
  }
}
