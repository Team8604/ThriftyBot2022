package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Dispenser extends SubsystemBase {

  private CANSparkMax[] dispenserMotors;
  private MotorControllerGroup dispenserGroup;

  public Dispenser() {
    dispenserMotors = new CANSparkMax[Constants.kDispenserMotors.length];
    for(int i = 0;i < Constants.kDispenserMotors.length;i ++){
      dispenserMotors[i] = new CANSparkMax(Constants.kDispenserMotors[i], MotorType.kBrushed);
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
