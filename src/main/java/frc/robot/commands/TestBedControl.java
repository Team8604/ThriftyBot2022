// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class TestBedControl extends CommandBase {
  //Set by TestBedToggle
  public static boolean STATIC_ENABLE = false;

  public TestBedControl() {
    addRequirements(RobotContainer.test);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(STATIC_ENABLE) {
      RobotContainer.test.set(1);
    } else {
      double value = RobotContainer.driverController.getRawAxis(Constants.kLeftTriggerY) - RobotContainer.driverController.getRawAxis(Constants.kRightTriggerY);
      value *= value;
      if(Math.abs(value) >= Constants.kDeadZone) {
        RobotContainer.test.set(value);
      } else {
        RobotContainer.test.set(1);
      }
    }

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
