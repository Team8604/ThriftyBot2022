// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class TestMechanism extends SubsystemBase {
  public WPI_VictorSPX motor;

  public TestMechanism() {
    motor = new WPI_VictorSPX(Constants.kTestMotor);
  }

  @Override
  public void periodic() {
  }
}
