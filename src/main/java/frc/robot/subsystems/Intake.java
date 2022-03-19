package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.TalonFXFeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Intake extends SubsystemBase {

  private WPI_TalonFX intakeActuatorMotor;
  private WPI_VictorSPX intakeMotor;

  public Intake() {
    intakeMotor = new WPI_VictorSPX(Constants.kIntakeMotor);

    /*intakeActuatorMotor = new WPI_TalonFX(Constants.kIntakeActuationMotor);

    intakeActuatorMotor.configFactoryDefault();
    intakeActuatorMotor.configSelectedFeedbackSensor(TalonFXFeedbackDevice.IntegratedSensor, Constants.kPIDLoopIdx,
        Constants.kTimeoutsMs);
        intakeActuatorMotor.config_kF(Constants.kPIDLoopIdx, Constants.kGains_Position_kF, Constants.kTimeoutsMs);
    intakeActuatorMotor.config_kP(Constants.kPIDLoopIdx, Constants.kGains_Position_kP, Constants.kTimeoutsMs);
    intakeActuatorMotor.config_kI(Constants.kPIDLoopIdx, Constants.kGains_Position_kI, Constants.kTimeoutsMs);
    intakeActuatorMotor.config_kD(Constants.kPIDLoopIdx, Constants.kGains_Position_kD, Constants.kTimeoutsMs);*/
  }

  @Override
  public void periodic() {

  }

  public void setActuator(double position) {
    //intakeActuatorMotor.set(TalonFXControlMode.Position, position);
  }
  
  public void set(double speed){
    intakeMotor.set(speed);
  }
}
