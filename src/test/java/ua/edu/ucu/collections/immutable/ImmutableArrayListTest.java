package ua.edu.ucu.collections.immutable;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.InputMismatchException;

import static org.junit.Assert.*;

public class ImmutableArrayListTest {
    private ImmutableArrayList oneElemArr;
    private ImmutableArrayList emptyArr;
    private ImmutableArrayList simpleArr;
    private Object[] exampleArr = new Object[]{1, 2, 3, "lol"};
    private Object[] invalidExampleArr = new Object[]{1, 2, 3, null};

    @Before
    public void setUp() {
        oneElemArr = new ImmutableArrayList(new Object[]{1});
        emptyArr = new ImmutableArrayList();
        simpleArr = new ImmutableArrayList(new Object[]{1, 2, 3});
    }

    @Test
    public void testAddOneElemArr() {
        ImmutableList actual = oneElemArr.add(1);

        ImmutableList expected = new ImmutableArrayList(new Object[]{1, 1});

        assertArrayEquals(actual.toArray(), expected.toArray());
        assertArrayEquals(oneElemArr.toArray(), new Object[]{1});
    }

    @Test
    public void testAddEmptyArr() {
        ImmutableList actual = emptyArr.add(1);

        ImmutableList expected = new ImmutableArrayList(new Object[]{1});

        assertArrayEquals(actual.toArray(), expected.toArray());
        assertArrayEquals(emptyArr.toArray(), new Object[]{});
    }

    @Test
    public void testAddSimpleArr() {
        ImmutableList actual = simpleArr.add(1);

        ImmutableList expected = new ImmutableArrayList(new Object[]{1, 2, 3, 1});

        assertArrayEquals(actual.toArray(), expected.toArray());
        assertArrayEquals(simpleArr.toArray(), new Object[]{1, 2, 3});

    }

    @Test(expected = InputMismatchException.class)
    public void testAddSimpleArrInvalidInput() {
        ImmutableList actual = simpleArr.add(null);
    }

    @Test
    public void testAddWithIndexOneElemArr() {
        ImmutableList actual = oneElemArr.add(0, "lol");

        ImmutableList expected = new ImmutableArrayList(new Object[]{"lol", 1});

        assertArrayEquals(actual.toArray(), expected.toArray());
        assertArrayEquals(oneElemArr.toArray(), new Object[]{1});
    }

    @Test
    public void testAddWithIndexEmptyArr() {
        ImmutableList actual = emptyArr.add(0, 1);

        ImmutableList expected = new ImmutableArrayList(new Object[]{1});

        assertArrayEquals(actual.toArray(), expected.toArray());
        assertArrayEquals(emptyArr.toArray(), new Object[]{});
    }

    @Test
    public void testAddWithIndexSimpleArr() {
        ImmutableList actual = simpleArr.add(3, "lol");

        ImmutableList expected = new ImmutableArrayList(new Object[]{1, 2, 3, "lol"});

        assertArrayEquals(actual.toArray(), expected.toArray());
        assertArrayEquals(simpleArr.toArray(), new Object[]{1, 2, 3});

    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddWithIndexSimpleArrNegativeIndex() {
        ImmutableList actual = simpleArr.add(-1, "lol");
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddWithIndexSimpleArrIndexOutOfRange() {
        ImmutableList actual = simpleArr.add(5, "lol");
    }

    @Test(expected = InputMismatchException.class)
    public void testAddWithIndexSimpleArrInvalidInput() {
        ImmutableList actual = simpleArr.add(2, null);
    }

    @Test
    public void testAddAllOneElemArr() {
        ImmutableList actual = oneElemArr.addAll(exampleArr);

        ImmutableList expected = new ImmutableArrayList(new Object[]{1, 1, 2, 3, "lol"});

        assertArrayEquals(actual.toArray(), expected.toArray());
        assertArrayEquals(oneElemArr.toArray(), new Object[]{1});
    }

    @Test
    public void testAddAllEmptyArr() {
        ImmutableList actual = emptyArr.addAll(exampleArr);

        ImmutableList expected = new ImmutableArrayList(new Object[]{1, 2, 3, "lol"});

        assertArrayEquals(actual.toArray(), expected.toArray());
        assertArrayEquals(emptyArr.toArray(), new Object[]{});
    }

    @Test
    public void testAddAllSimpleArr() {
        ImmutableList actual = simpleArr.addAll(exampleArr);

        ImmutableList expected = new ImmutableArrayList(new Object[]{1, 2, 3, 1, 2, 3, "lol"});

        assertArrayEquals(actual.toArray(), expected.toArray());
        assertArrayEquals(simpleArr.toArray(), new Object[]{1, 2, 3});
    }

    @Test(expected = InputMismatchException.class)
    public void testAddAllSimpleArrInvalidInput() {
        ImmutableList actual = simpleArr.addAll(invalidExampleArr);
    }

    @Test
    public void testAddAllWithIndexOneElemArr() {
        ImmutableList actual = oneElemArr.addAll(0, exampleArr);

        ImmutableList expected = new ImmutableArrayList(new Object[]{1, 2, 3, "lol", 1});

        assertArrayEquals(actual.toArray(), expected.toArray());
        assertArrayEquals(oneElemArr.toArray(), new Object[]{1});
    }

    @Test
    public void testAddAllWithIndexEmptyArr() {
        ImmutableList actual = emptyArr.addAll(0, exampleArr);

        ImmutableList expected = new ImmutableArrayList(new Object[]{1, 2, 3, "lol"});

        assertArrayEquals(actual.toArray(), expected.toArray());
        assertArrayEquals(emptyArr.toArray(), new Object[]{});
    }

    @Test
    public void testAddAllWithIndexSimpleArr() {
        ImmutableList actual = simpleArr.addAll(1, exampleArr);

        ImmutableList expected = new ImmutableArrayList(new Object[]{1, 1, 2, 3, "lol", 2, 3});

        assertArrayEquals(actual.toArray(), expected.toArray());
        assertArrayEquals(simpleArr.toArray(), new Object[]{1, 2, 3});
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddAllWithIndexSimpleArrNegativeIndex() {
        ImmutableList actual = simpleArr.addAll(-1, exampleArr);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddAllWithIndexSimpleArrIndexOutOfRange() {
        ImmutableList actual = simpleArr.addAll(5, exampleArr);
    }

    @Test(expected = InputMismatchException.class)
    public void testAddAllWithIndexSimpleArrInvalidInput() {
        ImmutableList actual = simpleArr.addAll(2, invalidExampleArr);
    }

    @Test
    public void testGetOneElemArr() {
        assertEquals(1, oneElemArr.get(0));
        assertArrayEquals(oneElemArr.toArray(), new Object[]{1});
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetEmptyArr() {
        emptyArr.get(0);
    }

    @Test
    public void testGetSimpleArr() {
        assertEquals(3, simpleArr.get(2));
        assertArrayEquals(simpleArr.toArray(), new Object[]{1, 2, 3});
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetSimpleArrIndexOutOfRange() {
        simpleArr.get(100);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetSimpleArrNegativeIndex() {
        simpleArr.get(-100);
    }

    @Test
    public void testRemoveOneElemArr() {
        ImmutableList actual = oneElemArr.remove(0);
        ImmutableList expected = new ImmutableArrayList();
        assertArrayEquals(actual.toArray(), expected.toArray());
        assertArrayEquals(oneElemArr.toArray(), new Object[]{1});
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveEmptyArr() {
        emptyArr.remove(0);
    }

    @Test
    public void testRemoveSimpleArr() {
        ImmutableList actual = simpleArr.remove(2);
        ImmutableList expected = new ImmutableArrayList(new Object[]{1, 2});
        assertArrayEquals(actual.toArray(), expected.toArray());
        assertArrayEquals(simpleArr.toArray(), new Object[]{1, 2, 3});
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveSimpleArrIndexPutOfRange() {
        simpleArr.remove(100);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveSimpleArrNegativeIndex() {
        simpleArr.remove(-100);
    }

    @Test
    public void testSetOneElemArr() {
        ImmutableList actual = oneElemArr.set(0, 2);
        ImmutableList expected = new ImmutableArrayList(new Object[]{2});
        assertArrayEquals(actual.toArray(), expected.toArray());
        assertArrayEquals(oneElemArr.toArray(), new Object[]{1});
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetEmptyArr() {
        emptyArr.set(0, 1);
    }

    @Test
    public void testSetSimpleArr() {
        ImmutableList actual = simpleArr.set(2, 10);
        ImmutableList expected = new ImmutableArrayList(new Object[]{1, 2, 10});
        assertArrayEquals(actual.toArray(), expected.toArray());
        assertArrayEquals(simpleArr.toArray(), new Object[]{1, 2, 3});
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetSimpleArrIndexPutOfRange() {
        oneElemArr.set(100, 56);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetSimpleArrNegativeIndex() {
        emptyArr.set(-100, null);
    }

    @Test(expected = InputMismatchException.class)
    public void testSetSimpleArrInvalidInput() {
        simpleArr.set(2, null);
    }

    @Test
    public void testIndexExist() {
        int actual = simpleArr.indexOf(2);
        int expected = 1;

        assertEquals(actual, expected);
    }

    @Test
    public void testIndexNotExist() {
        int actual = simpleArr.indexOf(30);
        int expected = -1;

        assertEquals(actual, expected);
    }

    @Test
    public void testIndexEmptyArrayNotExist() {
        int actual = emptyArr.indexOf(30);
        int expected = -1;

        assertEquals(actual, expected);
    }

    @Test
    public void testSizeEmptyArr() {
        int actual = emptyArr.size();
        int expected = 0;
        assertEquals(actual, expected);
    }

    @Test
    public void testSizeOneElemArr() {
        int actual = oneElemArr.size();
        int expected = 1;
        assertEquals(actual, expected);
    }

    @Test
    public void testSizeSimpleArr() {
        int actual = simpleArr.size();
        int expected = 3;
        assertEquals(actual, expected);
    }

    @Test
    public void testSizeSimpleArrAfterAdding() {
        ImmutableList im = simpleArr.add(5);
        int actual = simpleArr.size();
        int expected = 3;
        assertEquals(actual, expected);
    }

    @Test
    public void testClearOneElemArr() {
        ImmutableList actual = oneElemArr.clear();
        Object[] expected = new Object[0];
        assertArrayEquals(actual.toArray(), expected);
        assertArrayEquals(oneElemArr.toArray(), new Object[]{1});
    }

    @Test
    public void testClearEmptyArr() {
        ImmutableList actual = emptyArr.clear();
        Object[] expected = new Object[0];
        assertArrayEquals(actual.toArray(), expected);
        assertArrayEquals(emptyArr.toArray(), new Object[]{});
    }

    @Test
    public void testClearSimpleArr() {
        ImmutableList actual = simpleArr.clear();
        Object[] expected = new Object[0];
        assertArrayEquals(actual.toArray(), expected);
        assertArrayEquals(simpleArr.toArray(), new Object[]{1, 2, 3});
    }

    @Test
    public void isEmptyEmtyArr() {
        boolean actual = emptyArr.isEmpty();
        assertEquals(actual, true);
    }

    @Test
    public void isEmptyOneElemArr() {
        boolean actual = oneElemArr.isEmpty();
        assertEquals(actual, false);
    }

    @Test
    public void isEmptySimpleArr() {
        boolean actual = simpleArr.isEmpty();
        assertEquals(actual, false);
    }

    @Test
    public void toArrayOneElemArr() {
        Object[] actual = oneElemArr.toArray();
        Object[] expected = {1};
        assertArrayEquals(actual, expected);
    }

    @Test
    public void toArrayEmptyArr() {
        Object[] actual = emptyArr.toArray();
        Object[] expected = {};
        assertArrayEquals(actual, expected);
    }

    @Test
    public void toArraySimpleArr() {
        Object[] actual = simpleArr.toArray();
        Object[] expected = {1, 2, 3};
        assertArrayEquals(actual, expected);
    }

    @Test
    public void toArraySimpleArr2() {
        ImmutableList im = simpleArr.add("lol");
        Object[] actual = im.toArray();
        Object[] expected = {1, 2, 3, "lol"};
        assertArrayEquals(actual, expected);
    }

    @Test
    public void testToStringEmpty() {
        assertEquals(emptyArr.toString(), "");
    }

    @Test
    public void testToStringOneElemArr() {
        assertEquals(oneElemArr.toString(), "1");
    }

    @Test
    public void testToStringSimpleArr() {
        assertEquals(simpleArr.toString(), "1, 2, 3");
    }

}