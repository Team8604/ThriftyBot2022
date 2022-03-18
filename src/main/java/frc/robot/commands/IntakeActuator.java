package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

//This command is designed to run constantly, always targetting the correct orientation.
public class IntakeActuator extends CommandBase {

  private double target;

  public IntakeActuator(double target) {
    addRequirements(RobotContainer.intake);
    this.target = target;
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    RobotContainer.intake.setActuator(target);
  }

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return false;
  }
}
