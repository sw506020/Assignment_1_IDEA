/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parser;

import java.util.NoSuchElementException;

/**
 *
 * @author weiweisu
 */
public class LinkStack implements Stack {
    private Node first = null;
    
    private class Node {
        Character item;
        Node next;
    }
    
    public boolean isEmpty() {
        return first == null;
    }
    
    public void push(Character item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
    }
    
    public Character pop() throws NoSuchElementException {
        if (isEmpty())
            throw new NoSuchElementException("Stack underflow");

        Character item = first.item;
        first = first.next;
        return item;
    }
    
    public Character peek() {
        return first.item;
    }
    
}
