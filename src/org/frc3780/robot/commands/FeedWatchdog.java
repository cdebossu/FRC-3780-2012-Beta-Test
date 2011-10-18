/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.frc3780.robot.commands;

import edu.wpi.first.wpilibj.Watchdog;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 * @author ograff
 */
public class FeedWatchdog extends Command {
    Watchdog m_watchDog;
    public FeedWatchdog() {
        m_watchDog = Watchdog.getInstance();
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        m_watchDog.feed();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
