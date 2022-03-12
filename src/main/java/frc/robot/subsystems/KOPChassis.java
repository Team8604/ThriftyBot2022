// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class KOPChassis extends SubsystemBase {
  /** Creates a new Drivetrain. */
  
  private CANSparkMax leftLeader;
  private CANSparkMax rightLeader;
  private CANSparkMax leftFollower;
  private CANSparkMax rightFollower;
  private MotorControllerGroup leftMotors;
  private MotorControllerGroup rightMotors;
  private DifferentialDrive differentialDrive;

  public KOPChassis() {
    // Init Left Leader
    leftLeader  = new CANSparkMax(Constants.kLeftLeader, MotorType.kBrushed);
    // Init Right Leader
    rightLeader  = new CANSparkMax(Constants.kRightLeader, MotorType.kBrushed);

    // init left follower
    leftFollower  = new CANSparkMax(Constants.kLeftFollower, MotorType.kBrushed);
    //init right followers
    rightFollower  = new CANSparkMax(Constants.kRightFollower, MotorType.kBrushed);

    leftMotors = new MotorControllerGroup(leftLeader, leftFollower);
    rightMotors = new MotorControllerGroup(rightLeader, rightFollower);
    differentialDrive = new DifferentialDrive(leftMotors, rightMotors);
  }

  public void arcadeDrive(double moveSpeed, double rotateSpeed) {
    differentialDrive.arcadeDrive(moveSpeed, rotateSpeed);
  }

  public void set(double leftspeed, double rightspeed){
    leftMotors.set(leftspeed);
    rightMotors.set(rightspeed);
  }
  
  @Override
  public void periodic() {
    
  }
}
