
package org.frc3780.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.frc3780.robot.Global;
import org.frc3780.robot.subsystems.Chassis;

/**
 * Shifts the robot down
 * @author Oliver Graff (Team 3780)
 */
public class ShiftDown extends Command {
    Chassis m_chassis;
    int initialGear;
    int attempts;
    public ShiftDown() {
        m_chassis = Chassis.getInstance();
        // Use requires() here to declare subsystem dependencies
        requires(m_chassis);
        attempts = 0;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        if(Global.DEBUG) System.out.println("About to shift down");
        initialGear = m_chassis.getGear();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if(Global.DEBUG) System.out.println("Shifting down");
        m_chassis.shiftDown();
        attempts++;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        
        if(m_chassis.getGear() == initialGear-1 || m_chassis.getGear() == Global.LOWEST_GEAR)
            return true;
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
        if(Global.DEBUG) {
            System.out.println("Successfully shifted down");
        }
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        if(Global.DEBUG) System.out.println("Shift Down Interrupted");
    }
}
