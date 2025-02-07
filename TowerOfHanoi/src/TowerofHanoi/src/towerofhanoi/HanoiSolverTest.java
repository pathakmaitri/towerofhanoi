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
 *  This is the test class for the HanoiSolver class. 
 * 
 *  @author maitripathak
 *  @version Oct 17, 2023
 */
public class HanoiSolverTest extends TestCase
{
    //~ Fields ................................................................
    private HanoiSolver solver;
    private Disk disk1;
    private Disk disk2;
    private Disk disk3;
    //~ Constructors ..........................................................

    //~Public  Methods ........................................................
    /**
     * This is the setUp for this test class.
     */
    public void setUp() {
        solver = new HanoiSolver(3);
        disk1 = new Disk(1);
        disk2 = new Disk(2);
        disk3 = new Disk(3);
    }
    
    /**
     * This method tests the disks() method to see if it returns the
     * number of disks.
     */
    public void testDisks() {
        assertEquals(3, solver.disks());
    }
    
    /**
     * This method tests the getTower() method to see what tower it returns.
     */
    public void testGetTower() {
        assertEquals(Position.LEFT, solver.getTower(Position.LEFT)
            .position());
        assertEquals(Position.MIDDLE, solver.getTower(Position.MIDDLE)
            .position());
        assertEquals(Position.RIGHT, solver.getTower(Position.RIGHT)
            .position());
        assertEquals(Position.MIDDLE, solver.getTower(Position.MIDDLE)
            .position());
    }
    
    /**
     * This method tests the toString() method to see what string it returns.
     */
    public void testToString() {
        solver.getTower(Position.LEFT).push(disk3);
        solver.getTower(Position.LEFT).push(disk2);
        solver.getTower(Position.LEFT).push(disk1);
        assertEquals("[1, 2, 3][][]", solver.toString());
    }
    
    /**
     * This method tests the solve() method to see if it solves it.
     */
    public void testSolve() {
        solver.getTower(Position.LEFT).push(disk3);
        solver.getTower(Position.LEFT).push(disk2);
        solver.getTower(Position.LEFT).push(disk1);
        
        solver.solve();
        
        assertEquals(3, solver.disks());
    }

}
