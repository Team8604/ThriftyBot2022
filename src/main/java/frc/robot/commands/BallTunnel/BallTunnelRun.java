package frc.robot.commands.BallTunnel;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Constants;
import frc.robot.commands.Dispenser.DispenserMotor;

public class BallTunnelRun extends SequentialCommandGroup {
  //If direction is 0, stop. If direction is 1, run forwards. If direction is -1, run backwards. If direction is not 0, stop.
  public BallTunnelRun(int direction) {
    if(direction == 1){
      addCommands(new BallTunnelMotor(Constants.kBallTunnelSpeed), new DispenserMotor(Constants.kDispenserSpeedDuringBallTunnel));
    } else if(direction == -1){
      addCommands(new BallTunnelMotor(-Constants.kBallTunnelSpeed), new DispenserMotor(0));
    } else {
      addCommands(new BallTunnelMotor(0), new DispenserMotor(0));
    }
  }
}
