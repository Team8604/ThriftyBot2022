package frc.robot.subsystems;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Constants;

public class IntakePID {

    //Variable
    public double target;

    //Constant
    public double powerLimiter = 0.01;
    public double mul_p = 0.01;
    
    public double cycle(double currentPos) {
        double delta_ticks = target - currentPos;
        double delta_revs = delta_ticks/Constants.kTicksPerRev;

        double factor_p = delta_revs * mul_p;

        double finalResult = factor_p;
        
        SmartDashboard.putNumber("current_intake_target_power", finalResult);

        if(finalResult > powerLimiter){//Protection
            finalResult = powerLimiter;
        }

        SmartDashboard.putNumber("current_intake_power", finalResult);

        return finalResult;
    }

}