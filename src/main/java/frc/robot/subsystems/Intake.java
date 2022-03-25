package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Intake extends SubsystemBase {

  private WPI_TalonFX intakeActuatorMotor;
  private WPI_VictorSPX intakeMotor;
  public IntakePID intakePID;

  public Intake() {
    intakeMotor = new WPI_VictorSPX(Constants.kIntakeMotor);

    intakeActuatorMotor = new WPI_TalonFX(Constants.kIntakeActuationMotor);

    intakePID = new IntakePID();
  }

  @Override
  public void periodic() {
    double currentPos = intakeActuatorMotor.getSelectedSensorPosition();
    SmartDashboard.putNumber("current_intake_value", currentPos);
    intakeActuatorMotor.set(intakePID.cycle(currentPos));
    //intakePID.cycle(currentPos);
  }

  public void setActuator(double position) {
    intakePID.target = position;
    SmartDashboard.putNumber("target_intake_value", position);
  }
  
  public void set(double speed){
    intakeMotor.set(speed);
  }
}
