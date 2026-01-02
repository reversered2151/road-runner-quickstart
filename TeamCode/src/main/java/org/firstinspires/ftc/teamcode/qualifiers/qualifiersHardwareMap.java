package org.firstinspires.ftc.teamcode.qualifiers;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.IMU;
import com.qualcomm.robotcore.hardware.Servo;

public class qualifiersHardwareMap {
    public DcMotorEx bl, br, fl, fr, flywheel, intake, uptake;

    //    public NormalizedColorSensor colorSensor;
    public IMU imu;

    public Servo blocker;

//    HuskyLens huskyLens;

    public void init(HardwareMap hardwareMap){
        // Color Sensor
//        colorSensor = hardwareMap.get(NormalizedColorSensor.class, "color");
        // Camera
//        huskyLens  = hardwareMap.get(HuskyLens.class,"huskyLens");

        br = hardwareMap.get(DcMotorEx.class, "backRight");
        bl = hardwareMap.get(DcMotorEx.class, "backLeft");
        fr = hardwareMap.get(DcMotorEx.class, "frontRight");
        fl = hardwareMap.get(DcMotorEx.class, "frontLeft");

        intake = hardwareMap.get(DcMotorEx.class, "intake");
        intake.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        intake.setDirection(DcMotorSimple.Direction.REVERSE);

        uptake = hardwareMap.get(DcMotorEx.class, "uptake");
        uptake.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        uptake.setDirection(DcMotorSimple.Direction.REVERSE);

        imu = hardwareMap.get(IMU.class, "imu");

        flywheel = hardwareMap.get(DcMotorEx.class,"flywheel");
        flywheel.setDirection(DcMotorSimple.Direction.REVERSE);
        flywheel.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);

        blocker = hardwareMap.get(Servo.class, "blocker");

        // Reverse necessary motors
        br.setDirection(DcMotorSimple.Direction.REVERSE);
    }
}