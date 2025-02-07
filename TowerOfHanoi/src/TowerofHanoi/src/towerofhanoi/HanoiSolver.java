package towerofhanoi;
import java.util.Observable;
// -------------------------------------------------------------------------
//Virginia Tech Honor Code Pledge:
//
//As a Hokie, I will conduct myself with honor and integrity at all times.
//I will not lie, cheat, or steal, nor will I accept the actions of those 
//who do.
//-- Maitri Pathak (maitripathak14)
/**
 *  The HanoiSolver represents a Tower of Hanoi puzzle. 
 * 
 *  @author maitripathak
 *  @version Oct 17, 2023
 */
public class HanoiSolver extends Observable
{
    //~ Fields ................................................................
    private Tower left;
    private Tower middle;
    private Tower right;
    private int numDisks;
    //~ Constructors ..........................................................
    /**
     * This is the constructor for this class that create a new
     * HanoiSolver.
     * @param numDisks is an integer parameter.
     */
    public HanoiSolver(int numDisks) {
        left = new Tower(Position.LEFT);
        middle = new Tower(Position.MIDDLE);
        right = new Tower(Position.RIGHT);
        this.numDisks = numDisks;
    }
    //~Public  Methods ........................................................
    /**
     * This method returns the number of disks.
     * @return numDisks which is the number of disks left.
     */
    public int disks() {
        return numDisks;
    }
    
    /**
     * This method returns the position of the tower.
     * @param position is the position of the tower.
     * @return the position of the tower.
     */
    public Tower getTower(Position position) {
        switch (position) {
            case LEFT:
                return left;
            case MIDDLE:
                return middle;
            case RIGHT:
                return right;
            default:
                return middle;
        }
    }
    
    /**
     * This is the toString method that shows the width of the disks
     * as strings. 
     * @return the toString.
     */
    public String toString() {
        return left.toString() + middle.toString() + right.toString();
    }
    
    /**
     * This method moves the disk.
     * @param source is the starting tower.
     * @param desitination is the ending tower.
     */
    private void move(Tower source, Tower destination) {
        Disk disk = source.pop();
        destination.push(disk);
        setChanged();
        notifyObservers(destination.position());
    }
    
    /**
     * This is the method that solves the tower.
     * @param currentDisks is the current number of disks.
     * @param startPole is the starting pole.
     * @param tempPole is the temp pole.
     * @param endPole is the ending pole. 
     */
    private void solveTowers(int currentDisks, Tower startPole, 
        Tower tempPole, Tower endPole) {
        if (currentDisks == 1) {
            move(startPole, endPole);
        }
        else {
            solveTowers(currentDisks - 1, startPole, endPole, tempPole);
            move(startPole, endPole);
            solveTowers(currentDisks - 1, tempPole, startPole, endPole);
        }
    }
    
    /**
     * This method helps solve the HanoiTower.
     */
    public void solve() {
        solveTowers(numDisks, left, middle, right);
    }
}
