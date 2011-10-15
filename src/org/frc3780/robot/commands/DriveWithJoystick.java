/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.frc3780.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.frc3780.robot.subsystems.Chassis;

/**
 *
 * @author ograff
 */
public class DriveWithJoystick extends Command {
    Chassis m_chassis;
    public DriveWithJoystick() {
        m_chassis = Chassis.getInstance();
        // Use requires() here to declare subsystem dependencies
        requires(m_chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        m_chassis.driveWithJoystick();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
