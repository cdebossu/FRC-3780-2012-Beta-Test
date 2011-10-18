
package org.frc3780.robot;

import org.frc3780.robot.commands.ShiftUp;
import org.frc3780.robot.commands.ShiftDown;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import org.frc3780.robot.commands.DisableFineControl;
import org.frc3780.robot.commands.EnableFineControl;
import org.frc3780.robot.commands.FeedWatchdog;
/**
 * 
 * @author Oliver Graff (Team 3780)
 */
public class OI {
    private static final int DRIVE_JOYSTICK_PORT = 1;
    
    private static final int TRIGGER = 1;
    private static final int FINE_CONTROL = TRIGGER;
    private static OI instance = null;
    
    private Joystick driveStick;
    
    public final Button shiftUpButton;
    public final Button shiftDownButton;
    
    private final Button feedWatchdogButton;
    
    private final Button fineControlButton;
    private OI() {
        driveStick = new Joystick(DRIVE_JOYSTICK_PORT);
        
        shiftUpButton = new JoystickButton(driveStick, 3);
        shiftDownButton = new JoystickButton(driveStick, 2);
        
        feedWatchdogButton = new JoystickButton(driveStick, 7);
        feedWatchdogButton.whileHeld(new FeedWatchdog());
        
        shiftUpButton.whenPressed(new ShiftUp());
        shiftUpButton.whenReleased(new ShiftDown());
        
        fineControlButton = new JoystickButton(driveStick, FINE_CONTROL);
        fineControlButton.whenPressed(new EnableFineControl());
        fineControlButton.whenReleased(new DisableFineControl());
    }
    
    public static OI getInstance() {
    if (instance == null) 
            instance = new OI();
        return instance;
    }
    
    public Joystick getDriveJoystick() {
        return driveStick;
    }
}

