package towerofhanoi;
import student.TestCase; 
import java.util.EmptyStackException;

// -------------------------------------------------------------------------
//Virginia Tech Honor Code Pledge:
//
//As a Hokie, I will conduct myself with honor and integrity at all times.
//I will not lie, cheat, or steal, nor will I accept the actions of those 
//who do.
//-- Maitri Pathak (maitripathak14)
/**
 *  This is the test class for the LinkedStack class. 
 * 
 *  @author maitripathak
 *  @version Oct 16, 2023
 */
public class LinkedStackTest extends TestCase
{
    //~ Fields ................................................................
    private LinkedStack<String> stack;
    //~ Constructors ..........................................................

    //~Public  Methods ........................................................
    
    /**
     * set up the test case
     */
    public void setUp() {
        stack = new LinkedStack<>();
    }
    
    /**
     * Tests the clear() method to see if it clears everything.
     */
    public void testClear() {
        stack.push("one");
        stack.push("two");
        stack.clear();
        assertTrue(stack.isEmpty());
        assertEquals(0, stack.size());
    }
    
    /**
     * Tests the peek() method for when there is nothing in the stack,
     * when there is stuff pushed into the stack, and when stuff is popped
     * out of the stack.
     */
    public void testPeek() {
        Exception thrown = null;
        try {
            stack.peek();
        }
        catch (Exception exception) {
            thrown = exception;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof EmptyStackException);
        
        stack.push("one");
        stack.push("two");
        stack.push("three");
        assertEquals("three", stack.peek());
        assertEquals(3, stack.size());
        assertFalse(stack.isEmpty());
        stack.pop();
        assertEquals("two", stack.peek());
    }
    
    /**
     * Tests the the pop() method when there is nothing in the stack,
     * and when there is something in the stack.
     */
    public void testPop() {
        Exception thrown = null;
        try {
            stack.pop();
        }
        catch (Exception exception) {
            thrown = exception;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof EmptyStackException);
        
        stack.push("one");
        stack.pop();
        assertEquals(0, stack.size());
    }
    
    /**
     * Tests the push() method when something is pushed into the stack.
     */
    public void testPush() {
        assertTrue(stack.isEmpty());
        assertEquals(0, stack.size());
        stack.push("one");
        stack.push("two");
        stack.push("three");
        assertFalse(stack.isEmpty());
        assertEquals(3, stack.size());
    }
    
    /**
     * Tests the push() method when the stack is full and something is
     * pushed into it. 
     */
    public void testPush2() {
        for (int i = 0; i < 100; i++) {
            stack.push("object");
        }
        assertEquals(100, stack.size());
        stack.push("anotherObject");
        assertEquals(101, stack.size());
    }
    
    /**
     * Tests the toString() when there is nothing in the stack and when
     * there is something in the stack. 
     */
    public void testToString() {
        assertEquals("[]", stack.toString());
        stack.push("one");
        stack.push("two");
        stack.push("three");
        assertEquals("[three, two, one]", stack.toString());
    }
}
