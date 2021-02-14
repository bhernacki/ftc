package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import org.firstinspires.ftc.robotcore.external.Telemetry;

public class ServoState {
    public Servo servo;
    public String name;
    public boolean goingUp;
    public double position;
    private Telemetry telemetry;

    static final double INCREMENT   = 0.01;     // amount to slew servo each CYCLE_MS cycle
    static final int    CYCLE_MS    =   50;     // period of each cycle
    static final double MAX_POS     =  1.0;     // Maximum rotational position
    static final double MIN_POS     =  0.0;     // Minimum rotational position

    public ServoState(String myName, HardwareMap hardwareMap) {
        name = myName;
        servo = hardwareMap.get(Servo.class, name);

        if (servo == null) {
            telemetry.log().add("unable to map servo "+name+". might not exist");
            return;
        }
        goingUp = true;
        position = (MAX_POS - MIN_POS) / 2; // Start at halfway position
        servo.setPosition(position);
    }


    public void moveServo(boolean up) {
        goingUp = up;
        this.moveServo();
    }

    public void moveServo() {

        if (servo == null) {
            telemetry.log().add("servo "+name+" not initialized, cannot move");
            return;
        }

        if (goingUp) {
            // Keep stepping up until we hit the max value.
            position += INCREMENT;
            if (position >= MAX_POS) {
                position = MAX_POS;
            }
        } else {
            // Keep stepping down until we hit the min value.
            position -= INCREMENT;
            if (position <= MIN_POS) {
                position = MIN_POS;
            }
        }

        // Set the servo to the new position and pause;
        servo.setPosition(position);
    }
}
