package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Constants;

public class Dispense extends SequentialCommandGroup {

  public Dispense(boolean dispense) {
    addCommands(new BallTunnelMotor(dispense ? Constants.kBallTunnelSpeed : 0), new DispenserMotor(dispense ? Constants.kDispenserSpeed : 0));
  }
}
