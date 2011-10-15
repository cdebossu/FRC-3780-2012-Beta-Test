/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.frc3780.robot.subsystems;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.frc3780.robot.OI;
import org.frc3780.robot.commands.DriveWithJoystick;

/**
 * @author Oliver Graff (Team 3780)
 */

public class Chassis extends Subsystem {
    public static final int RIGHT_MOTOR_PORT = 8;
    public static final int LEFT_MOTOR_PORT = 1;
    private static Chassis instance = null;

    private RobotDrive drive;
    public static Chassis getInstance() {
        if(instance == null) {
            instance = new Chassis();

            // Set default command here, like this:
            instance.setDefaultCommand(new DriveWithJoystick());
        }
        return instance;
    }

    // Initialize your subsystem here
    private Chassis() {
        drive = new RobotDrive(new Jaguar(LEFT_MOTOR_PORT), new Jaguar(RIGHT_MOTOR_PORT));
        drive.setSafetyEnabled(false);
        
    }
    /**
     * Drive the robot with the main joystick
     */
    public void driveWithJoystick() {
        drive.arcadeDrive(OI.getInstance().getDriveJoystick());
        
    }
}

