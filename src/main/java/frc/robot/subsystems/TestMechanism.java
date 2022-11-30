// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class TestMechanism extends SubsystemBase {
  public WPI_VictorSPX motor1;
  public WPI_VictorSPX motor2;

  public TestMechanism() {
    motor1 = new WPI_VictorSPX(Constants.kTestMotor1);
    motor2 = new WPI_VictorSPX(Constants.kTestMotor2);

  }

  public void set(double value) {
    motor1.set(value * Constants.kTestMul1);
    motor2.set(value * Constants.kTestMul2);
  }

  @Override
  public void periodic() {
  }
}
