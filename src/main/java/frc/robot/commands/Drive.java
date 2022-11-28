package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class Drive extends CommandBase {

  public static int mode = 0;

  public Drive() {
    addRequirements(RobotContainer.chassis);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    double moveSpeed, rotateSpeed;
    switch(mode) {
      case 0://Arcade drive 
        moveSpeed = RobotContainer.driverController.getRawAxis(Constants.kLeftStickY);
        rotateSpeed = RobotContainer.driverController.getRawAxis(Constants.kLeftStickX);
        
        moveSpeed *= Constants.kDriveModifier;
        rotateSpeed *= Constants.kDriveModifier;
    
        RobotContainer.chassis.arcadeDrive(rotateSpeed, moveSpeed);
        break;
      case 1://Tank drive
        double leftSpeed = RobotContainer.driverController.getRawAxis(Constants.kLeftStickY);
        double rightSpeed = RobotContainer.driverController.getRawAxis(Constants.kRightStickY);
        
        leftSpeed *= Constants.kDriveModifier;
        rightSpeed *= Constants.kDriveModifier;
    
        RobotContainer.chassis.set(leftSpeed, rightSpeed);
        break;
      case 3://Arcade drive but uses different sticks 
          moveSpeed = RobotContainer.driverController.getRawAxis(Constants.kLeftStickY);
          rotateSpeed = RobotContainer.driverController.getRawAxis(Constants.kRightStickX);
          
          moveSpeed *= Constants.kDriveModifier;
          rotateSpeed *= Constants.kDriveModifier;
      
          RobotContainer.chassis.arcadeDrive(rotateSpeed, moveSpeed);
          break;
    }
  }

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return false;
  }
}
