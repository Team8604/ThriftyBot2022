package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Dispenser extends SubsystemBase {

  private WPI_VictorSPX[] dispenserMotors;
  private MotorControllerGroup dispenserGroup;

  public Dispenser() {
    dispenserMotors = new WPI_VictorSPX[Constants.kDispenserMotors.length];
    for(int i = 0;i < Constants.kDispenserMotors.length;i ++){
      dispenserMotors[i] = new WPI_VictorSPX(Constants.kDispenserMotors[i]);
    }
    dispenserGroup = new MotorControllerGroup(dispenserMotors);
  }

  public void set(double speed){
    dispenserGroup.set(speed);
  }

  @Override
  public void periodic() {

  }
}
