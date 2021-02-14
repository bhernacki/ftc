## DriveTest Test Op Mode

This op mode is designed to help mechanical teams test their designs while building without needing
to wait for their software teams to build the production software for your robot. It presents a
simple set of controls that allow you to control a basic two-motor left/right drive system and
move a few other servos and motors.

It is intended to be very simple, very robust and not require any coding to get your bot up and
running. All you need to do is install this op mode on your robot controller and configure your
bot (via your driver control app) so the motors and servos have some "standard names" (see below)
and you will be able to control and test them.

This op mode is really meant just for test. It doesn't do many things you will need in real
competition. It's not tuned for any kind of performance and doesn't handle concurrent operations
well or support multiple drivers. Also, you need to write your own software for competition anyways!

It can also serve as a bit of sample code for software teams new to writing FTC OpModes. It's not
meant to be especially elegant or efficient, but it will give you the basic idea of how to control
the bot with software.


In order for this OpMode to work you need to use the FTC Driver Control app and Configure your
robot so the various motors, servos, etc have some standard names this Op Mode expects:

* motor_left
* motor_right
* motor_one
* motor_two
* servo_one
* servo_two
* servo_three
* servo_four

Note that only regular Servo not CRServo ("continuous rotation" servos... have "CR" on the end of
their model number) are supported. If you want to use those, you will need to modify the code. And
remember that those work more like DcMotors than regular servos!

It doesnt really matter what you're using the various parts for. Those are just names but they will
map as below to buttons on your controller. One thing to note though is that motor_left and
motor_right are special in that they operate in opposite directions under the assumption you made
mounted them in opposite directions on your bot to drive left and right side wheels. The rest all
have manual controls to move in each direction but the drive wheels are bound to the joysticks to
give you a drive control like you're used to in most video games

* left stick:
* right stick:
* left trigger:
* left shoulder:
* right trigger:
* right shoulder:
* x:
* b:
* y:
* a:
* dpad up:
* dpad down:
* dpad left:
* dpad right:

The op mode is pretty robust. If you don't define one of the expected names, it just ignores it and
the buttons won't do anything. If it fails for some reason it tries to ignore it and log it safely
so you can keep testing. The drive controls (power) show as telemetry in the driver app. The other
information it reports shows up in the robot log. You can access this from the driver app too.


TBDs
------
* sensor support
* CRServo support