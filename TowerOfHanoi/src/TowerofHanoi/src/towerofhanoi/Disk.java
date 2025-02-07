package towerofhanoi;

import cs2.Shape;
import java.awt.Color;
import student.TestableRandom;

// -------------------------------------------------------------------------
//Virginia Tech Honor Code Pledge:
//
//As a Hokie, I will conduct myself with honor and integrity at all times.
//I will not lie, cheat, or steal, nor will I accept the actions of those 
//who do.
//-- Maitri Pathak (maitripathak14)
/**
 *  Disk class extends Shape because we are thinking of Disks are
 *  rectangles of various widths. Disk also implements the Comparable<Disk>
 *  interface to allow Disks to be compared to one another. 
 * 
 *  @author maitripathak
 *  @version Oct 9, 2023
 */
public class Disk extends Shape
{
    //~ Fields ................................................................

    //~ Constructors ..........................................................
    /**
     * Constructor for this class. 
     * @param width is the width of the disk and an integer parameter
     */
    public Disk(int width) {
        super(0, 0, width, PuzzleWindow.DISK_HEIGHT);
        TestableRandom random = new TestableRandom();
        int red = random.nextInt(256);
        int blue = random.nextInt(256);
        int green = random.nextInt(256);
        Color color = new Color(red, blue, green);
        this.setBackgroundColor(color);
    }
    //~Public  Methods ........................................................
    
    /**
     * Compares disk to other disks
     * @param otherDisk is the other disk that is being compared to
     * @return the number of the width when comparing the two disks. 
     */
    public int compareTo(Disk otherDisk) {
        if (otherDisk == null) {
            throw new IllegalArgumentException();
        }
        return this.getWidth() - otherDisk.getWidth();
    }
    
    /**
     * toString method for this class. 
     * @return the width of this disk as a string. 
     * REVIEW THIS METHOD COULD BE WRONG!!!!!!!!!!!!!!! (the valueOf part)
     */
    public String toString() {
        return String.valueOf(this.getWidth());
    }
    
    /**
     * Equals method to see is the new disk is the same width as 
     * another disk
     * @param obj is the object being compared to.
     * @return if the disks are the same width, it should return true
     */
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj == null) || (obj.getClass() != this.getClass())) {
            return false;
        }
        Disk otherDisk = (Disk) obj;
        return this.getWidth() == otherDisk.getWidth();
    }
}
