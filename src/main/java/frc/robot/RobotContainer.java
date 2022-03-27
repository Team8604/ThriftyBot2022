package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.Auto;
import frc.robot.commands.BallTunnel.BallTunnelRun;
import frc.robot.commands.Dispenser.Dispense;
import frc.robot.commands.Drivetrain.ArcadeDrive;
import frc.robot.commands.Drivetrain.DriveMode;
import frc.robot.commands.Intake.IntakeDeploy;
import frc.robot.commands.Intake.IntakeRetract;
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
  //public static Joystick buttonBoard = new Joystick(1);

  public RobotContainer() {
    configureButtonBindings();

    chassis.setDefaultCommand(new ArcadeDrive());
  }

  @SuppressWarnings("unused")
  private void configureButtonBindings() {
    JoystickButton driverAButton = new JoystickButton(driverController, Constants.kButtonA);
    JoystickButton driverBButton = new JoystickButton(driverController, Constants.kButtonB);
    JoystickButton driverXButton = new JoystickButton(driverController, Constants.kButtonX);
    JoystickButton driverYButton = new JoystickButton(driverController, Constants.kButtonY);
    JoystickButton driverRBumper = new JoystickButton(driverController, Constants.kBumperR);
    JoystickButton driverLBumper = new JoystickButton(driverController, Constants.kBumperL);

    /*JoystickButton buttonBoardAButton = new JoystickButton(buttonBoard, Constants.kButtonA);
    JoystickButton buttonBoardBButton = new JoystickButton(buttonBoard, Constants.kButtonB);
    JoystickButton buttonBoardXButton = new JoystickButton(buttonBoard, Constants.kButtonX);
    JoystickButton buttonBoardYButton = new JoystickButton(buttonBoard, Constants.kButtonY);
    JoystickButton buttonBoardRBumper = new JoystickButton(buttonBoard, Constants.kBumperR);
    JoystickButton buttonBoardLBumper = new JoystickButton(buttonBoard, Constants.kBumperL);*/
  
    driverYButton.whenPressed(new DriveMode(true, false));
    driverYButton.whenReleased(new DriveMode(false, false));
    driverBButton.whenPressed(new DriveMode(false, true));
    driverBButton.whenReleased(new DriveMode(false, false));

    driverXButton.whenPressed(new Dispense(true));
    driverXButton.whenReleased(new Dispense(false));

    driverAButton.whenPressed(new IntakeDeploy());
    driverAButton.whenReleased(new IntakeRetract());

    driverLBumper.whenPressed(new BallTunnelRun(1));
    driverLBumper.whenReleased(new BallTunnelRun(0));
    driverRBumper.whenPressed(new BallTunnelRun(-1));
    driverRBumper.whenReleased(new BallTunnelRun(0));


    /*buttonBoardBButton.whenPressed(new Dispense(true));
    buttonBoardBButton.whenReleased(new Dispense(false));

    buttonBoardAButton.whenPressed(new IntakeDeploy());
    buttonBoardAButton.whenReleased(new IntakeRetract());

    buttonBoardXButton.whenPressed(new BallTunnelRun(1));
    buttonBoardXButton.whenReleased(new BallTunnelRun(0));
    buttonBoardYButton.whenPressed(new BallTunnelRun(-1));
    buttonBoardYButton.whenReleased(new BallTunnelRun(0));*/
  }

  public Command getAutonomousCommand() {
    return new Auto();
  }
}
