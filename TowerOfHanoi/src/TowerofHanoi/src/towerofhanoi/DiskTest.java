package towerofhanoi; 
import student.TestCase;
// -------------------------------------------------------------------------
//Virginia Tech Honor Code Pledge:
//
//As a Hokie, I will conduct myself with honor and integrity at all times.
//I will not lie, cheat, or steal, nor will I accept the actions of those 
//who do.
//-- Maitri Pathak (maitripathak14)
/**
 *  This is the test class for the Disk class and tests all the methods
 *  to make sure everything is running smoothly.
 * 
 *  @author maitripathak
 *  @version Oct 16, 2023
 */
public class DiskTest extends TestCase
{
    //~ Fields ................................................................
    /**
     * This is the disk.
     */
    private Disk disk;
    //~ Constructors ..........................................................

    //~Public  Methods ........................................................
    
    /**
     * This is the setUp() method for the DiskTest class
     */
    public void setUp() {
        disk = new Disk(6);
    }
    
    /**
     * This method tests the compareTo() method. It tests for when
     * the disk width is equal to each other, one the original disk is
     * smaller than the new disk, when the original disk is larger than
     * the new disk, and when there is no other disk to compare it to. 
     */
    public void testCompareTo() {
        Disk disk1 = new Disk(6);
        assertEquals(0, disk.compareTo(disk1));
        
        Disk disk2 = new Disk(7);
        int result1 = disk.compareTo(disk2);
        assertTrue(result1 < 0);
        
        Disk disk3 = new Disk(5);
        int result2 = disk.compareTo(disk3);
        assertTrue(result2 > 0);
        
        Disk disk4 = null;
        Exception exception = null;
        try {
            disk.compareTo(disk4);
        }
        catch (Exception e) {
            exception = e;
        }
        assertNotNull(exception);
    }
    
    /**
     * Tests the toString() method to make sure that the string version
     * of the width is returned and not the integer version.
     */
    public void testToString() {
        assertEquals("6", disk.toString());
    }
    
    /**
     * Tests the equals() method for all things. 
     */
    @SuppressWarnings("unlikely-arg-type")
    public void testEquals() {
        // tests when it is equal with same disk instance
        assertTrue(disk.equals(disk));
        
        // tests when it is equal with null
        assertFalse(disk.equals(null));
        
        // tests when it is with a different type of object
        String notDisk = "This is a different object";
        assertFalse(disk.equals(notDisk));
        
        // tests when disks have equal widths
        Disk disk2 = new Disk(6);
        assertTrue(disk.equals(disk2));
        
        //tests when disks have unequal widths
        Disk disk3 = new Disk(7);
        assertFalse(disk.equals(disk3));
    }
}
