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

//        canarybotto.driveMotorsForwards(69, this);
//        canarybotto.driveMotorsRight(-12, this);

        telemetry.addData("Mode", "waiting");
        telemetry.update();



        telemetry.addData("Mode", "running");
        telemetry.update();


        // set motor power to zero to turn off motors. The motors stop on their own but
        // power is still applied so we turn off the power.

        canarybotto.frontLeftDrive.setPower(0.0);
        canarybotto.frontRightDrive.setPower(0.0);
        canarybotto.backLeftDrive.setPower(0.0);
        canarybotto.backRightDrive.setPower(0.0);

        canarybotto.moveArmDown();

        UGRectDetector.Stack stack = UGRectDetector.getStack();

        switch (stack) {
            case ZERO:
//                // move the front of the robot 4 tiles forward and 1/2 tile to the right (if on red, left on blue)
                telemetry.addData("Status", "I see 0 rings");
                canarybotto.driveMotorsForwards(72, this);
                canarybotto.driveMotorsRight(-12, this);
                break;
            case ONE:
//                // move the front of the robot 5 tiles forward and 1/2 a tile to the left (right on blue)
                telemetry.addData("Status", "I see 1 ring");
                canarybotto.driveMotorsForwards(96, this);
                canarybotto.driveMotorsRight(12,this);
                canarybotto.moveArmUp();
                canarybotto.driveMotorsForwards(-24, this);
                break;
            case FOUR:
//                // move the front of the robot 6 tiles forward and 1/2 a tile to the right (left on blue)
                telemetry.addData("Status", "I see 4 rings");
                canarybotto.driveMotorsForwards(110,this);
                canarybotto.driveMotorsRight(-12,this);
                canarybotto.moveArmUp();
                canarybotto.driveMotorsForwards(-44, this);
//                seems to only see 4 rings in the garage lights
                break;
              default:
                telemetry.addData("Status", "I am a blind bird");
                break;

        }
        telemetry.update();
        sleep(5000);
    }
}
