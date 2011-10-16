
package org.frc3780.robot.components;

import edu.wpi.first.wpilibj.SpeedController;

/**
 *
 * @author Oliver Graff (Team 3780)
 */
public interface Shifter extends SpeedController {
    /**
     * Gets the current gear of the Shifter. Starting at one
     * @return Current Gear
     */
    public int getGear();
    
    /**
     * Shifts the shifter up one
     */
    public void shiftUp();
    
    /**
     * Shifts the shifter down one
     */
    public void shiftDown();
}
