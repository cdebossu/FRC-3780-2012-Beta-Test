/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.frc3780.robot.subsystems;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.util.AllocationException;
import org.frc3780.robot.OI;
import org.frc3780.robot.commands.DriveWithJoystick;
import org.frc3780.robot.components.ServoSuperShifter;
import org.frc3780.robot.components.ShiftingRobotDrive;

/**
 * @author Oliver Graff (Team 3780)
 */

public class Chassis extends Subsystem {
    public static final int RIGHT_MOTOR_PORT_1 = 8;
    public static final int RIGHT_MOTOR_PORT_2 = 8;
    public static final int RIGHT_SHIFTER_PORT = 9;
            
    public static final int LEFT_MOTOR_PORT_1 = 1;
    public static final int LEFT_MOTOR_PORT_2 = 1;
    public static final int LEFT_SHIFTER_PORT = 10;
    
    private static Chassis instance = null;

    private ShiftingRobotDrive m_drive;
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
        if(LEFT_MOTOR_PORT_1 == LEFT_MOTOR_PORT_1 && RIGHT_MOTOR_PORT_1 == RIGHT_MOTOR_PORT_2) {
            Jaguar left = new Jaguar(LEFT_MOTOR_PORT_1);
            Jaguar right = new Jaguar(RIGHT_MOTOR_PORT_1);
            m_drive = new ShiftingRobotDrive(new ServoSuperShifter(left, left, new Servo(LEFT_SHIFTER_PORT)), new ServoSuperShifter(right, right, new Servo(RIGHT_SHIFTER_PORT)));
        } else {
            try {
                m_drive = new ShiftingRobotDrive(new ServoSuperShifter(new Jaguar(LEFT_MOTOR_PORT_1), new Jaguar(LEFT_MOTOR_PORT_2), new Servo(LEFT_SHIFTER_PORT)), new ServoSuperShifter(new Jaguar(RIGHT_MOTOR_PORT_1), new Jaguar(RIGHT_MOTOR_PORT_2), new Servo(RIGHT_SHIFTER_PORT)));
            } catch (AllocationException ax) {
                System.err.println("Double allocation");
                System.err.println(ax);
            }
            m_drive.setSafetyEnabled(false);
        }
        
    }
    /**
     * Drive the robot with the main joystick
     */
    public void driveWithJoystick() {
        m_drive.arcadeDrive(OI.getInstance().getDriveJoystick());
    }
    /**
     * Gets the current gear
     * @return The current gear
     */
    public int getGear() {
        return m_drive.getGear();
    }
    /**
     * Shifts the Drive up
     */
    public void shiftUp() {
        m_drive.shiftUp();
    }
    /**
     * Shifts the Drive down
     */
    public void shiftDown() {
        m_drive.shiftDown();
    }
    
}

