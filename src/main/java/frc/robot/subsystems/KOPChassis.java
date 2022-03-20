// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class KOPChassis extends SubsystemBase {
  /** Creates a new Drivetrain. */
  
  private WPI_VictorSPX leftLeader;
  private WPI_VictorSPX rightLeader;
  private WPI_VictorSPX leftFollower;
  private WPI_VictorSPX rightFollower;
  private MotorControllerGroup leftMotors;
  private MotorControllerGroup rightMotors;
  private DifferentialDrive differentialDrive;

  public boolean climbingMode = false;

  public KOPChassis() {
    // Init Left Leader
    leftLeader  = new WPI_VictorSPX(Constants.kLeftLeader);
    leftLeader.configFactoryDefault();
    // Init Right Leader
    rightLeader  = new WPI_VictorSPX(Constants.kRightLeader);
    rightLeader.configFactoryDefault();

    // init left follower
    leftFollower  = new WPI_VictorSPX(Constants.kLeftFollower);
    leftFollower.configFactoryDefault();

    //init right followers
    rightFollower  = new WPI_VictorSPX(Constants.kRightFollower);
    rightFollower.configFactoryDefault();

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

  public void setMotorSafety(boolean value){
    differentialDrive.setSafetyEnabled(value);
  }

  @Override
  public void periodic() {
    
  }
}
