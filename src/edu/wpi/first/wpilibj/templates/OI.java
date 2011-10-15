
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Joystick;

public class OI {
    private static final int DRIVE_JOYSTICK_PORT = 1;
    private static OI instance = null;
    
    private Joystick driveStick;
    private OI() {
        driveStick = new Joystick(DRIVE_JOYSTICK_PORT);
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

