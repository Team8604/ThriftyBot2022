package frc.robot.commands.Dispenser;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Constants;
import frc.robot.commands.BallTunnel.BallTunnelMotor;

public class Dispense extends SequentialCommandGroup {

  public Dispense(boolean dispense) {
    addCommands(new BallTunnelMotor(dispense ? Constants.kBallTunnelSpeedDuringDispensing : 0), new DispenserMotor(dispense ? Constants.kDispenserSpeed : 0));
  }
}
