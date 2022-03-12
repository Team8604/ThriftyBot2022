package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class ArcadeDrive extends CommandBase {

  public ArcadeDrive() {
    addRequirements(RobotContainer.chassis);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    double moveSpeed = RobotContainer.driverController.getRawAxis(Constants.kLeftStickY);
    double rotateSpeed = RobotContainer.driverController.getRawAxis(Constants.kLeftStickX);
    
    moveSpeed *= Constants.kDriveModifier;
    rotateSpeed *= Constants.kDriveModifier;

    RobotContainer.chassis.arcadeDrive(rotateSpeed, moveSpeed);
  }

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return false;
  }
}
