package towerofhanoi; 
// -------------------------------------------------------------------------
//Virginia Tech Honor Code Pledge:
//
//As a Hokie, I will conduct myself with honor and integrity at all times.
//I will not lie, cheat, or steal, nor will I accept the actions of those 
//who do.
//-- Maitri Pathak (maitripathak14)
/**
 *  This class is the towers class on which we store
 *  disks function as stacks. Towers offer a unqiue
 *  extension to a normal stack - they only allow smaller
 *  disks to be placed on top of larger ones. 
 * 
 *  @author maitripathak
 *  @version Oct 16, 2023
 */
public class Tower extends LinkedStack<Disk>
{
    //~ Fields ................................................................
    
    private Position position;
    
    //~ Constructors ..........................................................
    
    /**
     * This is the constructor for this class that creates a new tower.
     * @param position is a Position parameter.
     */
    public Tower(Position position) {
        super();
        this.position = position;
    }
    
    //~Public  Methods ........................................................
    
    /**
     * This method gives you the position of the tower.
     * @return the position of the tower.
     */
    public Position position() {
        return position;
    }
    
    /**
     * This method pushes a disc on top of the tower (stack).
     * @param disk is the Disk that is being added to the tower. 
     */
    @Override
    public void push(Disk disk) {
        if (disk == null) {
            throw new IllegalArgumentException();
        }
        if (isEmpty() || disk.compareTo(peek()) < 0) { 
            super.push(disk);
        }
        else {
            throw new IllegalStateException();
        }
    }
}
