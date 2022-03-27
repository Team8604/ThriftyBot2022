package frc.robot.commands.Drivetrain;

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
    double moveSpeed = -RobotContainer.driverController.getRawAxis(Constants.kLeftStickY);
    double rotateSpeed = RobotContainer.driverController.getRawAxis(Constants.kLeftStickX);
    
    if(RobotContainer.chassis.climb) {
      moveSpeed *= Constants.kClimbDriveModifier;
      rotateSpeed *= Constants.kClimbSteerModifier;
    } else if(!RobotContainer.chassis.unlock) {
      moveSpeed *= Constants.kDriveModifier;
      rotateSpeed *= Constants.kSteerModifier;
    }

    RobotContainer.chassis.arcadeDrive(rotateSpeed, moveSpeed);
  }

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return false;
  }
}
