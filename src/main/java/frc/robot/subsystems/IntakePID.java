package frc.robot.subsystems;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Constants;

public class IntakePID {

    //Variable
    public double target = 0;

    //Constant
    public double powerLimiter = 0.075;
    
    public double mul_p = 0.00;
    public double mul_g = 0.10;
    
    public double cycle(double currentPos) {
        double delta_ticks = target - currentPos;
        double delta_revs = delta_ticks/Constants.kTicksPerRev;

        double factor_p = delta_revs * mul_p;

        double factor_g = gravityAdjustment(currentPos);

        double finalResult = factor_p + factor_g;
        
        SmartDashboard.putNumber("current_intake_target_power", finalResult);

        if(finalResult > powerLimiter){//Protection
            finalResult = powerLimiter;
        } else if(finalResult < -powerLimiter){
            finalResult = -powerLimiter;
        }

        SmartDashboard.putNumber("current_intake_power", finalResult);

        return finalResult;
    }

    private double gravityAdjustment(double currentPos){
        double angle = currentPos / Constants.kTicksPerDegree;
        angle += Constants.kIntakeZeroedAngle;

        SmartDashboard.putNumber("current_intake_angle", angle);

        double cosine = Math.cos(Math.toRadians(angle));

        return cosine * mul_g;
    }

}