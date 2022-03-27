package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;

//For some strange reason, automatic drivetrain action refuses to work when being executed from a SequentialCommandGroup.
//Therefore, the entire auto routine has been put into a single file. It sacrifices readability, but it works.
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
    if(timer.hasElapsed(Constants.kAutoDispenseEnd)){
      RobotContainer.chassis.setMotorSafety(false);
      RobotContainer.chassis.arcadeDrive(0, 0.5);
      RobotContainer.dispenser.set(0);
      RobotContainer.ballTunnel.set(0);
    } else if(timer.hasElapsed(Constants.kAutoDeadEnd)) {
      RobotContainer.dispenser.set(Constants.kDispenserSpeed);
      RobotContainer.ballTunnel.set(Constants.kBallTunnelSpeed);
    }
  }

  @Override
  public void end(boolean interrupted) {
    RobotContainer.chassis.set(0, 0);
    RobotContainer.chassis.setMotorSafety(true);
  }

  @Override
  public boolean isFinished() {
    return timer.hasElapsed(Constants.kAutoDriveEnd);
  }
}
