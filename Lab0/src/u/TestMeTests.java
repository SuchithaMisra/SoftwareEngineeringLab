package u;

import static org.junit.Assert.*;

import java.beans.Transient;

import org.junit.Before;
import org.junit.Test;

import c.TestMe;

public class TestMeTests {

    TestMe testMe;


    @Before
    public void setUp() throws Exception {
        testMe = new TestMe();
    }

    @Test
    public void squareTest() {

        double baseValue = 3.0;
        double expected = baseValue * baseValue;
        testMe.setValue(3.0);
        double actual = testMe.square();

        assertTrue(actual == expected);
    }
    /*
     LAB 0: MAKE TEST ME BIGGER -->  CUBE
     * square roots
     * multiple by twos 
     * screenshot when you run it 
     */

     @Test
     public void cubeTest(){
        double baseValue = 3.0;
        double expected = baseValue * baseValue * baseValue;
        testMe.setValue(3.0);
        double actual = testMe.cube();

        assertTrue(actual == expected);
     }

     @Test
     public void triangleTest(){
        double baseValue = 3.0;
        double expected = baseValue * baseValue * .5;
        testMe.setValue(3.0);
        double actual = testMe.triangle();

        assertTrue(actual == expected);
     }

     @Test
     public void areaTest(){
        double baseValue = 3.0;
        double baseValue2 = 4.0;
        double expected = baseValue * baseValue2;
        TestMe testMe2 = new TestMe();
        testMe2.setValue(baseValue2);
        testMe.setValue(3.0);

        double actual = testMe.area(testMe2);
        assertTrue(actual == expected);
     }

      @Test
     public void doubleSizeTestMeTest(){
        double baseValue = 3.0;
        double expected = baseValue * 2;
        testMe.setValue(3.0);
        TestMe testMe2 = testMe.doubleSizeTestMe();
        double actual = testMe2.getValue();

        assertTrue(actual == expected);
     }
}
