package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Stack {
    private ImmutableLinkedList stack;

    public Stack() {
        stack = new ImmutableLinkedList();
    }

    public Object peek() {
        return stack.getLast();
    }

    public Object pop() {
        Object result = peek();
        stack = stack.removeLast();
        return result;
    }

    public void push(Object e) {
        stack = stack.addLast(e);
    }
}
