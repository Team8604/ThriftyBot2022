package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class BallTunnel extends SubsystemBase {

  private WPI_VictorSPX[] ballTunnelMotors;
  private MotorControllerGroup ballTunnelGroup;

  public BallTunnel() {
    ballTunnelMotors = new WPI_VictorSPX[Constants.kBallTunnelMotors.length];
    for(int i = 0;i < Constants.kBallTunnelMotors.length;i ++){
      ballTunnelMotors[i] = new WPI_VictorSPX(Constants.kBallTunnelMotors[i]);
    }
    ballTunnelGroup = new MotorControllerGroup(ballTunnelMotors);
  }

  public void set(double speed){
    ballTunnelGroup.set(speed);
  }

  @Override
  public void periodic() {

  }
}
