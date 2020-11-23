package ua.edu.ucu.collections;


import org.junit.Before;
import org.junit.Test;

import java.util.InputMismatchException;

import static org.junit.Assert.*;

public class QueueTest {
    private Queue q;
    private Object[] exampleArray;
    private Object[] invalidArray;

    @Before
    public void setUp() {
        q = new Queue();
        exampleArray = new Object[]{6, 7, 2, 4, 1, 3, 7, 1};
        invalidArray = new Object[]{6, 7, 2, null, 1};
    }

    @Test
    public void testQueue() {
        for (Object val : exampleArray) {
            q.enqueue(val);
        }
        int temp = 0;
        while (temp < exampleArray.length) {
            assertEquals(exampleArray[temp], q.peek());
            assertEquals(exampleArray[temp], q.dequeue());
            temp = temp + 1;
        }
    }

    @Test(expected = InputMismatchException.class)
    public void testQueueInvalid() {
        for (Object val : invalidArray) {
            q.enqueue(val);
        }
        int temp = 0;
        while (temp < exampleArray.length) {
            assertEquals(exampleArray[temp], q.peek());
            assertEquals(exampleArray[temp], q.dequeue());
            temp = temp + 1;
        }
    }
}