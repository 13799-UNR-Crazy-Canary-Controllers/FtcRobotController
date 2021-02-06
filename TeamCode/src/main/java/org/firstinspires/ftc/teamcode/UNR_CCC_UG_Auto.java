package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.vision.UGRectDetector;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcontroller.external.samples.HardwarePushbot;

@Autonomous(name="UNR_CCC_UG", group="Pushbot")

public class UNR_CCC_UG_Auto extends LinearOpMode {

    private CanaryBot canarybotto = new CanaryBot();
    //  Use a Pushbot's hardware
    private ElapsedTime runtime = new ElapsedTime();

    @Override
    public void runOpMode() {

        canarybotto.init(hardwareMap);

//        initializing stack detector
        com.arcrobotics.ftclib.vision.UGRectDetector UGRectDetector = new UGRectDetector(hardwareMap);

        UGRectDetector.init();

        // Send telemetry message to signify robot waiting;
        telemetry.addData("Status", "Ready to run");    //
        telemetry.update();

        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        // reset encoder counts kept by motors.
        // reset encoder counts kept by motors.
        canarybotto.frontLeftDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        canarybotto.frontRightDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        canarybotto.backLeftDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        canarybotto.backRightDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        // set motors to run forward for 5000 encoder counts.
        canarybotto.frontLeftDrive.setTargetPosition(2493);
        canarybotto.frontRightDrive.setTargetPosition(2493);
        canarybotto.backLeftDrive.setTargetPosition(2493);
        canarybotto.backRightDrive.setTargetPosition(2493);

        // set motors to run to target encoder position and stop with brakes on.
        canarybotto.frontLeftDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        canarybotto.frontRightDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        canarybotto.backLeftDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        canarybotto.backRightDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        telemetry.addData("Mode", "waiting");
        telemetry.update();

        // wait for start button.

        waitForStart();

        telemetry.addData("Mode", "running");
        telemetry.update();

        // set both motors to 25% power. Movement will start. Sign of power is
        // ignored as sign of target encoder position controls direction when
        // running to position.

        canarybotto.frontLeftDrive.setPower(0.25);
        canarybotto.frontRightDrive.setPower(0.25);
        canarybotto.backLeftDrive.setPower(0.25);
        canarybotto.backRightDrive.setPower(0.25);

        // wait while opmode is active and left motor is busy running to position.

        while (opModeIsActive() && canarybotto.frontLeftDrive.isBusy())   //leftMotor.getCurrentPosition() < leftMotor.getTargetPosition())
        {
            idle();
        }
        while (opModeIsActive() && canarybotto.frontRightDrive.isBusy())   //leftMotor.getCurrentPosition() < leftMotor.getTargetPosition())
        {
            idle();
        }while (opModeIsActive() && canarybotto.backLeftDrive.isBusy())   //leftMotor.getCurrentPosition() < leftMotor.getTargetPosition())
        {
            idle();
        }while (opModeIsActive() && canarybotto.backRightDrive.isBusy())   //leftMotor.getCurrentPosition() < leftMotor.getTargetPosition())
        {
            idle();
        }

        // set motor power to zero to turn off motors. The motors stop on their own but
        // power is still applied so we turn off the power.

        canarybotto.frontLeftDrive.setPower(0.0);
        canarybotto.frontRightDrive.setPower(0.0);
        canarybotto.backLeftDrive.setPower(0.0);
        canarybotto.backRightDrive.setPower(0.0);

        UGRectDetector.Stack stack = UGRectDetector.getStack();

//        switch (stack) {
//            case ZERO:
//                // move the front of the robot 4 tiles forward and 1/2 tile to the right (if on red, left on blue)
//                telemetry.addData("Status", "I see 0 rings");
//                canarybotto.moveNumFeet(2.0);
//                break;
//            case ONE:
//                // move the front of the robot 5 tiles forward and 1/2 a tile to the left (right on blue)
//                telemetry.addData("Status", "I see 1 ring");
//                break;
//            case FOUR:
//                // move the front of the robot 6 tiles forward and 1/2 a tile to the right (left on blue)
//                telemetry.addData("Status", "I see 4 rings");
//                canarybotto.moveNumFeet(2.0);
//                seems to only see 4 rings in the garage lights
//                break;
//            default:
//                telemetry.addData("Status", "I am a blind bird");
//                break;
//
//        }
//        telemetry.update();
//        sleep(5000);
    }
}
