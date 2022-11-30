package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.Drive;
import frc.robot.commands.SwitchMode;
import frc.robot.commands.TestBedControl;
import frc.robot.commands.TestBedToggle;
import frc.robot.subsystems.KOPChassis;
import frc.robot.subsystems.TestMechanism;

public class RobotContainer {
  public static final KOPChassis chassis = new KOPChassis();
  public static final TestMechanism test = new TestMechanism(); 

  public static Joystick driverController = new Joystick(0);

  public RobotContainer() {
    configureButtonBindings();

    // chassis.setDefaultCommand(new Drive());
    test.setDefaultCommand(new TestBedControl());
  }

  private void configureButtonBindings() {
    JoystickButton driverAButton = new JoystickButton(driverController, Constants.kButtonA);
    JoystickButton driverBButton = new JoystickButton(driverController, Constants.kButtonB);
    JoystickButton driverXButton = new JoystickButton(driverController, Constants.kButtonX);
    JoystickButton driverYButton = new JoystickButton(driverController, Constants.kButtonY);
  
    driverAButton.whenPressed(new SwitchMode(0));
    driverBButton.whenPressed(new SwitchMode(1));
    driverYButton.whenPressed(new SwitchMode(3));

    driverXButton.whenPressed(new TestBedToggle(true));
    driverXButton.whenReleased(new TestBedToggle(false));
  }

  public Command getAutonomousCommand() {
    return null;
  }
}
