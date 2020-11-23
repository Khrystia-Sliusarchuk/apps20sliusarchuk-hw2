package ua.edu.ucu.collections.immutable;

import java.util.Arrays;
import java.util.InputMismatchException;

public final class ImmutableArrayList implements ImmutableList {
    private Object[] immArray;
    private int immArraySize;

    public ImmutableArrayList() {
        immArray = new Object[]{};
        immArraySize = 0;
    }

    public ImmutableArrayList(Object[] arr) {
        checkInput(arr);

        immArray = new Object[arr.length];
        immArraySize = arr.length;

        for (int j = 0; j < arr.length; j++) {
            immArray[j] = arr[j];
        }
    }

    public void checkInput(Object[] arr) {
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] == null) {
                throw new InputMismatchException("Input is incorrect!");
            }
        }
    }

    public void checkIndex(int ind) {
        if (ind > immArraySize || ind < 0) {
            throw new IndexOutOfBoundsException("Invalid index!");
        }
    }

    @Override
    public ImmutableArrayList add(Object e) {
        return add(immArraySize, e);
    }

    @Override
    public ImmutableArrayList add(int index, Object e) {
        return addAll(index, new Object[]{e});
    }

    @Override
    public ImmutableArrayList addAll(Object[] c) {
        return addAll(immArraySize, c);
    }

    @Override
    public ImmutableArrayList addAll(int index, Object[] c) {
        checkIndex(index);
        checkInput(c);

        int newImmArraySize = c.length + immArraySize;
        Object[] newImmArray = new Object[newImmArraySize];

        for (int j = 0; j < newImmArraySize; j++) {
//            adding the elements of the new array
//            in the appropriate index
            if (j >= index && j < index + c.length) {
                newImmArray[j] = c[j - index];
//                adding the elements of the old array
//                in all of the indexes left
            } else {
                if (j > index) {
//                adding the elements of the old
//                array in the indexes after the new array
                    newImmArray[j] = immArray[j - c.length];
                }
//                adding the elements of the old
//                array in the indexes before the new array
                else {
                    newImmArray[j] = immArray[j];
                }
            }
        }

        return new ImmutableArrayList(newImmArray);

    }

    @Override
    public Object get(int index) {
        checkIndex(index);

        return immArray[index];
    }

    @Override
    public ImmutableArrayList remove(int index) {
        checkIndex(index);

        if (immArraySize == 0) {
            throw new IndexOutOfBoundsException();
        }

        int newImmArraySize = immArraySize - 1;
        Object[] newImmArray = new Object[newImmArraySize];

        for (int j = 0; j <= newImmArraySize; j++) {
            if (j != index) {
//                adding the elements that are in the
//                positions before the index to remove
                if (j < index) {
                    newImmArray[j] = immArray[j];
//                adding the elements that are in the
//                positions after the index to remove
                } else {
                    newImmArray[j - 1] = immArray[j];
                }
            }
        }
        return new ImmutableArrayList(newImmArray);
    }

    @Override
    public ImmutableArrayList set(int index, Object e) {
        checkIndex(index);

        Object[] newImmArray = Arrays.copyOf(immArray, immArraySize);
        newImmArray[index] = e;

        return new ImmutableArrayList(newImmArray);
    }

    @Override
    public int indexOf(Object e) {
        for (int j = 0; j < immArraySize; j++) {
            if (immArray[j].equals(e)) {
                return j;
            }
        }

        return -1;
    }

    @Override
    public int size() {
        return immArraySize;
    }

    @Override
    public ImmutableArrayList clear() {
        return new ImmutableArrayList();
    }

    @Override
    public boolean isEmpty() {
        if (immArraySize == 0) {
            return true;
        }
        return false;
    }

    @Override
    public Object[] toArray() {
        Object[] immArrayToArray = Arrays.copyOf(immArray, immArraySize);
        return immArrayToArray;
    }

    @Override
    public String toString() {
        String str = Arrays.toString(toArray());
        return str.substring(1, str.length() - 1);
    }

}


