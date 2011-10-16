/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.frc3780.robot.components;

import com.sun.squawk.util.NotImplementedYetException;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.SpeedController;

/**
 * This class handles Super Shifters that are controlled by a servo. Makes them appear as one motor
 * Anything to do with PID is not dealt with
 * @author Oliver Graff (Team 3780)
 */

public final class ServoSuperShifter implements Shifter {
    private static final double LOW_GEAR_SERVO_SETTING = 0.8;
    private static final double HIGH_GEAR_SERVO_SETTING = 0.2;
    
    private SpeedController m_s1;
    private SpeedController m_s2;
    private Servo m_shifter;
    
    private double m_speed;
    private int m_gear;
    
    
    /**
     * 
     * @param m_s1 Motor 1 on that Super Shifter
     * @param m_s2 Motor 2 on that Super Shifter
     * @param m_shifter The servo that control the shifting
     */
    public ServoSuperShifter(SpeedController s1, SpeedController s2, Servo shifter) {
        this.m_s1 = s1;
        this.m_s2 = s2;
        this.m_shifter = shifter;
        disable();
        
    }
    public double get() {
        return m_speed;
    }
    /**
     * Gets the current gear for the Shifter
     * @return Current robot gear
     */
    public int getGear() {
        return m_gear;
    }
    /**
     * Shifts the Shifter up
     */
    public void shiftUp() {
        setShifter(2);
    }
    /**
     * Shifts the Shifter down
     */
    public void shiftDown() {
        setShifter(1);
    }
    /**
     * Sets the m_shifter to a certain gear
     * @param gear the gear to set the m_shifter to
     */
    private void setShifter(int  gear) {
        if(!(gear == 1 || gear == 2)) { throw new IllegalArgumentException("Gear can only be 1 or 2 not " + gear ); }
        m_gear = gear;
        updateShifter();
    }
    /**
     * Updates the physical position of the m_shifter
     */
    private void updateShifter() {
        if(m_gear == 1) m_shifter.set(LOW_GEAR_SERVO_SETTING);
        if(m_gear == 2) m_shifter.set(HIGH_GEAR_SERVO_SETTING);
    }
    public void set(double speed, byte syncGroup) {
        m_speed = speed;
        m_s1.set(speed, syncGroup);
        m_s2.set(speed, syncGroup);
    }

    public void set(double speed) {
        m_speed = speed;
        m_s1.set(speed);
        m_s2.set(speed);
    }

    public void disable() {
        m_speed = 0;
        m_s1.disable();
        m_s2.disable();
        m_shifter.set(m_shifter.get());
    }

    public void pidWrite(double output) {
        throw new NotImplementedYetException();
    }
    
    
}
