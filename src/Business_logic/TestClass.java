package Business_logic;
import junit.framework.*;

public class TestClass extends TestCase {
    protected int value1, value2;

    // assigning the values
    public void setUp(){
        value1 = 3;
        value2 = 3;
    }

    // test method to add two values
    public void testAdd(){
        double result = value1 + value2;
        assertTrue(result == 6);
    }

    //test amount of ticket is larger than 0 and less than limit
    public void testAmount(int a, int limit, int count) {
        assertTrue(a > 0);
        assertTrue(a <= (limit - count));
    }
}
