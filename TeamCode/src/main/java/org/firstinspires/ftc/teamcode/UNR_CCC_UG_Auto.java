package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.vision.UGRectDetector;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

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

        UGRectDetector.Stack stack = UGRectDetector.getStack();

        switch (stack) {
            case ZERO:
                // move the front of the robot 4 tiles forward and 1/2 tile to the right (if on red, left on blue)
                break;
            case ONE:
                // move the front of the robot 5 tiles forward and 1/2 a tile to the left (right on blue)
                break;
            case FOUR:
                // move the front of the robot 6 tiles forward and 1/2 a tile to the right (left on blue)
                break;
            default:
                break;

        }
    }
}
