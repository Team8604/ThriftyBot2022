package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.ArcadeDrive;
import frc.robot.commands.Auto;
import frc.robot.commands.BallTunnelMotor;
import frc.robot.commands.DriveMode;
import frc.robot.commands.Dispense;
import frc.robot.commands.DispenserMotor;
import frc.robot.commands.DriveTime;
import frc.robot.commands.IntakeDeploy;
import frc.robot.commands.IntakeRetract;
import frc.robot.subsystems.BallTunnel;
import frc.robot.subsystems.Dispenser;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.KOPChassis;

public class RobotContainer {
  public static final KOPChassis chassis = new KOPChassis();
  public static final BallTunnel ballTunnel = new BallTunnel();
  public static final Dispenser dispenser = new Dispenser();
  public static final Intake intake = new Intake();

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
  
    driverXButton.whenPressed(new DispenserMotor(Constants.kDispenserSpeed));
    driverXButton.whenReleased(new DispenserMotor(0));
    driverYButton.whenPressed(new DriveMode(true, false));
    driverYButton.whenReleased(new DriveMode(false, false));
    driverBButton.whenPressed(new DriveMode(false, true));
    driverBButton.whenReleased(new DriveMode(false, false));

    /*driverAButton.whenPressed(new IntakeDeploy());
    driverAButton.whenReleased(new IntakeRetract());*/

    /*driverLBumper.whenPressed(new BallTunnelMotor(Constants.kBallTunnelSpeed));
    driverLBumper.whenReleased(new BallTunnelMotor(0));
    driverRBumper.whenPressed(new BallTunnelMotor(-Constants.kBallTunnelSpeed));
    driverRBumper.whenReleased(new BallTunnelMotor(0));*/
  }

  public Command getAutonomousCommand() {
    return new Auto();
    //return new DriveTime(1, 1);
  }
}
