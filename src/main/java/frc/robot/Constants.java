package frc.robot;

public final class Constants {

    //CAN IDs
    public static final int kRightLeader = 14;
    public static final int kRightFollower = 7;
    public static final int kLeftLeader = 10;
    public static final int kLeftFollower = 2;
    public static final int[] kBallTunnelMotors = new int[] { 1 };
    public static final int[] kDispenserMotors = new int[] { 3 };
    public static final int kIntakeMotor = 13;
    public static final int kIntakeActuationMotor = 4;

    //Multipliers
    public static final double kDriveModifier = -0.8;
    public static final double kSteerModifier = 0.7;
    public static final double kClimbDriveModifier = -0.5;
    public static final double kClimbSteerModifier = 0.5;
    public static final double kBallTunnelSpeed = 0.25;
    public static final double kDispenserSpeed = -1;
    public static final double kIntakeSpeed = 0.5;
    //Button IDs
    public static final int kButtonA = 1;
    public static final int kButtonB = 2;
    public static final int kButtonX = 3;
    public static final int kButtonY = 4;
    public static final int kBumperL = 5;
    public static final int kBumperR = 6;

    public static final int kLeftStickX = 0;
    public static final int kLeftStickY = 1;
    public static final int kRightStickX = 4;
    public static final int kRightStickY = 5;
    public static final int kLeftTriggerY = 2;
    public static final int kRightTriggerY = 3;

    public static final int kButton1 = 1;
    public static final int kButton2 = 2;
    public static final int kButton3 = 3;
    public static final int kButton4 = 4;

    //PID Constants
    public static final int kPIDLoopIdx = 0;
    public static final int kTimeoutMs = 0;
    public static final int kTimeoutsMs = 0;
    public static final double kGains_Position_kP = 0.5;
    public static final double kGains_Position_kI = 0;
    public static final double kGains_Position_kD = 0;
    public static final double kGains_Position_kF = 0;

    //Other

    /*
     * The talon FX has a built in econder that reports 2048 ticks per rotation.
     * There is an 18 tooth pulley attached to the motor and a 64 tooth pulley attached to the intake arm.
     * The arm needs to rotate 90 degrees.
    */
    public static double kIntakeRotationDegrees = 90;
    public static double kIntakeRotationRevs = kIntakeRotationDegrees/360;
    public static double kIntakeActuatorGearRatio = 64.0/18.0;
    public static double kIntakeRotationRevsAtMotor = kIntakeActuatorGearRatio * kIntakeActuatorGearRatio;
    public static double kIntakeRotationTicks = 2048 * kIntakeRotationRevsAtMotor;
}
