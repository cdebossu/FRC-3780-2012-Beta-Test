
package org.frc3780.robot.components;

import org.frc3780.library.LinkedList;

/**
 * A Robot Drive that shifts
 * @author Oliver Graff (Team 3780)
 */
public class ShiftingRobotDrive extends edu.wpi.first.wpilibj.RobotDrive {
    LinkedList shifters;
    
    public ShiftingRobotDrive(Shifter leftShifter, Shifter rightShifter) {
        super(leftShifter, rightShifter);
        shifters = new LinkedList();
        shifters.addToBeggining(leftShifter);
        shifters.addToBeggining(rightShifter);
    }
    public ShiftingRobotDrive(Shifter frontLeftShifter, Shifter rearLeftShifter, Shifter frontRightShifter, Shifter rearRightShifter) {
        super(frontLeftShifter, rearLeftShifter, frontRightShifter, rearRightShifter);
        shifters = new LinkedList();
        shifters.addToBeggining(frontLeftShifter);
        shifters.addToBeggining(rearLeftShifter);
        shifters.addToBeggining(frontRightShifter);
        shifters.addToBeggining(rearRightShifter);
    }
    public int getGear() {
        Shifter s = (Shifter) shifters.get(0);
        return s.getGear();
    }
    public void shiftUp() {
        for(int i = 0; i < shifters.size(); i++) {
            Shifter s = (Shifter) shifters.get(i);
            s.shiftUp();
        }
    }
    public void shiftDown() {
        for(int i = 0; i < shifters.size(); i++) {
            Shifter s = (Shifter) shifters.get(i);
            s.shiftDown();
        }
    }
    
    
}
