package ua.edu.ucu.collections;


import org.junit.Before;
import org.junit.Test;

import java.util.InputMismatchException;

import static org.junit.Assert.*;

public class StackTest {
    private Stack st;
    private Object[] exampleArray;
    private Object[] invalidArray;

    @Before
    public void setUp() {
        st = new Stack();
        exampleArray = new Object[]{6, 7, 2, 4, 1, 3, 7, 1};
        invalidArray = new Object[]{6, 7, 2, null, 1};
    }

    @Test
    public void testStack() {
        for (Object val : exampleArray) {
            st.push(val);
        }
        int temp = 0;
        while (temp < exampleArray.length) {
            assertEquals(exampleArray[exampleArray.length - 1 - temp], st.peek());
            assertEquals(exampleArray[exampleArray.length - 1 - temp], st.pop());
            temp = temp + 1;
        }
    }

    @Test(expected = InputMismatchException.class)
    public void testStackInvalid() {
        for (Object val : invalidArray) {
            st.push(val);
        }
        int temp = 0;
        while (temp < exampleArray.length) {
            assertEquals(exampleArray[exampleArray.length - 1 - temp], st.peek());
            assertEquals(exampleArray[exampleArray.length - 1 - temp], st.pop());
            temp = temp + 1;
        }
    }
}