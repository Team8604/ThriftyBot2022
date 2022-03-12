package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.ArcadeDrive;
import frc.robot.subsystems.BallTunnel;
import frc.robot.subsystems.Dispenser;
import frc.robot.subsystems.KOPChassis;

public class RobotContainer {
  public static final KOPChassis chassis = new KOPChassis();
  public static final BallTunnel ballTunnel = new BallTunnel();
  public static final Dispenser dispenser = new Dispenser();

  public static Joystick driverController = new Joystick(0);

  public RobotContainer() {
    configureButtonBindings();

    chassis.setDefaultCommand(new ArcadeDrive());
  }

  private void configureButtonBindings() {}

  public Command getAutonomousCommand() {
    return null;
  }
}
