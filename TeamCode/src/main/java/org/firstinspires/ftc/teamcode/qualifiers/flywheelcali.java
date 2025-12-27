
package org.firstinspires.ftc.teamcode.qualifiers;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorEx;


@TeleOp(name = "Flywheel Cali", group = "qualifiers")
public class flywheelcali extends LinearOpMode {

    qualifiersHardwareMap hardware = new qualifiersHardwareMap();


    private double targetRpm = 0.0;

    boolean startup = false;
    boolean lb_prev = false;
    boolean rb_prev = false;


    DcMotorEx flywheel;
    DcMotorEx intake;
    DcMotorEx uptake;

    @Override
    public void runOpMode() throws InterruptedException{
        //init stuff
        hardware.init(hardwareMap);

        flywheel = hardware.flywheel;
        intake = hardware.intake;
        uptake = hardware.uptake;


        waitForStart();

        while (opModeIsActive()) {
            final boolean lb = gamepad1.left_bumper;
            final boolean rb = gamepad1.right_bumper;
            final boolean dpad_up = gamepad1.dpad_up;

            if (dpad_up) {
                flywheel.setPower(.7);
                startup = true;
            }

            if (lb && !lb_prev) {
                if (startup){
                    flywheel.setPower(0);
                    startup = false;
                }
                targetRpm += 100;
            }

            if (rb && !rb_prev) {
                if (startup){
                    flywheel.setPower(0);
                    startup = false;
                }
                targetRpm = 500;
            }

            if (gamepad1.y){
                intake.setPower(100);
                uptake.setPower(100);
            } else if (gamepad1.a) {
                intake.setPower(0);
                uptake.setPower(0);
            }


            if (!startup) {flywheel.setVelocity(targetRpm);}
            telemetry.addLine("Controls: LB = increase speed, RB = reset speed");
            telemetry.addLine("Target RPM:"+ targetRpm);
            telemetry.update();

            // Update previous button states
            lb_prev = lb;
            rb_prev = rb;
        }
    }
}