package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.ArcadeDrive;
import frc.robot.commands.BallTunnelMotor;
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

  private void configureButtonBindings() {
    JoystickButton driverAButton = new JoystickButton(driverController, Constants.kButtonA);
    JoystickButton driverBButton = new JoystickButton(driverController, Constants.kButtonB);
    JoystickButton driverXButton = new JoystickButton(driverController, Constants.kButtonX);
    JoystickButton driverYButton = new JoystickButton(driverController, Constants.kButtonY);
    JoystickButton driverRBumper = new JoystickButton(driverController, Constants.kBumperR);
    JoystickButton driverLBumper = new JoystickButton(driverController, Constants.kBumperL);
  
    driverLBumper.whenPressed(new BallTunnelMotor(-Constants.kBallTunnelSpeed));
    driverLBumper.whenReleased(new BallTunnelMotor(0));
    driverRBumper.whenPressed(new BallTunnelMotor(Constants.kBallTunnelSpeed));
    driverRBumper.whenReleased(new BallTunnelMotor(0));
  }

  public Command getAutonomousCommand() {
    return null;
  }
}
