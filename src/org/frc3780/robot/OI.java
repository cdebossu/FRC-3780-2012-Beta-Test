
package org.frc3780.robot;

import org.frc3780.robot.commands.ShiftUp;
import org.frc3780.robot.commands.ShiftDown;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
/**
 * 
 * @author Oliver Graff (Team 3780)
 */
public class OI {
    private static final int DRIVE_JOYSTICK_PORT = 1;
    private static OI instance = null;
    
    private Joystick driveStick;
    
    public final Button shiftUpButton;
    public final Button shiftDownButton;
    private OI() {
        driveStick = new Joystick(DRIVE_JOYSTICK_PORT);
        
        shiftUpButton = new JoystickButton(driveStick, 3);
        shiftDownButton = new JoystickButton(driveStick, 2);
         
        shiftDownButton.whenPressed(new ShiftDown());
        shiftUpButton.whenPressed(new ShiftUp());
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

