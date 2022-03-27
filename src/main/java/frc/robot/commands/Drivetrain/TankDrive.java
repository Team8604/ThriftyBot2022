package frc.robot.commands.Drivetrain;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class TankDrive extends CommandBase {

  public TankDrive() {
    addRequirements(RobotContainer.chassis);
  }

  @Override
  public void initialize() {
    double leftSpeed = -RobotContainer.driverController.getRawAxis(Constants.kLeftStickY);
    double rightSpeed = -RobotContainer.driverController.getRawAxis(Constants.kRightStickY);
    
    leftSpeed *= Constants.kDriveModifier;
    rightSpeed *= Constants.kDriveModifier;

    RobotContainer.chassis.set(leftSpeed, rightSpeed);
  }

  @Override
  public void execute() {}

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return false;
  }
}
