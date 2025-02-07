package towerofhanoi; 
// -------------------------------------------------------------------------
//Virginia Tech Honor Code Pledge:
//
//As a Hokie, I will conduct myself with honor and integrity at all times.
//I will not lie, cheat, or steal, nor will I accept the actions of those 
//who do.
//-- Maitri Pathak (maitripathak14)
/**
 *  This is the ProjectRunner class where the main method lives.
 * 
 *  @author maitripathak
 *  @version Oct 17, 2023
 */
public class ProjectRunner
{
    //~ Fields ................................................................

    //~ Constructors ..........................................................

    //~Public  Methods ........................................................
    public static void main(String[] arg)
    {
        int disks = 6;
        if (arg.length == 1)
        {
            disks = Integer.parseInt(arg[0]);
        }
        
        HanoiSolver solver = new HanoiSolver(disks);
        PuzzleWindow game = new PuzzleWindow(solver);
        
    }
}
