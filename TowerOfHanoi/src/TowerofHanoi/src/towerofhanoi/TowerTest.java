package towerofhanoi;  
// -------------------------------------------------------------------------
//Virginia Tech Honor Code Pledge:
//
//As a Hokie, I will conduct myself with honor and integrity at all times.
//I will not lie, cheat, or steal, nor will I accept the actions of those 
//who do.
//-- Maitri Pathak (maitripathak14)
/**
 *  This class tests all the methods in the Tower class.
 * 
 *  @author maitripathak
 *  @version Oct 16, 2023
 */
public class TowerTest extends TestCase
{
    //~ Fields ................................................................
    
    private Tower tower;
    
    //~ Constructors ..........................................................

    //~Public  Methods ........................................................
    
    /**
     * Set up for this test class
     */
    public void setUp() {
        tower = new Tower(Position.RIGHT);
    }
    
    /**
     * This method tests the position() method for the position.
     */
    public void testPosition() {
        assertTrue(tower.position().equals(Position.RIGHT));
    }
    
    /**
     * This method tests the push() method for when the disk is null
     */
    public void testPush1() {
        Exception thrown = null;
        try {
            tower.push(null);
        } 
        catch (Exception e) {
            thrown = e;
        }
        assertTrue(thrown instanceof IllegalArgumentException);
    }
    
    /**
     * This method tests the push() method for determining which
     * disk is smaller or when the tower is empty.
     */
    public void testPush2() {
        assertTrue(tower.isEmpty());
    }
    
    /**
     * This method tests the push() method the tower isn't empty and
     * when the disk on top is not being compared to the dish being pushed
     */
    public void testPush3() {
        Disk disk1 = new Disk(2);
        Disk disk2 = new Disk(3);
        
        tower.push(disk1);
        Exception thrown = null;
        try
        {
            tower.push(disk2);
        }
        catch (Exception e)
        {
            thrown = e;
        }
        assertTrue(thrown instanceof IllegalStateException);
    }
}
