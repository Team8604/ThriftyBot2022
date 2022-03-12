package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Dispenser extends SubsystemBase {

  private CANSparkMax[] ballTunnelMotors;
  private MotorControllerGroup ballTunnelGroup;

  public Dispenser() {
    ballTunnelMotors = new CANSparkMax[Constants.kBallTunnelMotors.length];
    for(int i = 0;i < Constants.kBallTunnelMotors.length;i ++){
      ballTunnelMotors[i] = new CANSparkMax(Constants.kBallTunnelMotors[i], MotorType.kBrushed);
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
