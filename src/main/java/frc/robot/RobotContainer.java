package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.KOPChassis;

public class RobotContainer {
  public final KOPChassis chassis = new KOPChassis();

  public RobotContainer() {
    configureButtonBindings();

    
  }

  private void configureButtonBindings() {}

  public Command getAutonomousCommand() {
    return null;
  }
}
