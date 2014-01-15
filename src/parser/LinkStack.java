/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parser;

/**
 *
 * @author weiweisu
 */
public class LinkStack implements Stack{
    private Node first = null;
    
    private class Node {
        Character item;
        Node next;
    }
    
    public boolean isEmpty() {
        return first == null;
    }
    
    public void push(Character item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
    }
    
    public Character pop() {
        Character item = first.item;
        first = first.next;
        return item;
    }
    
    public Character peek() {
        return first.item;
    }
    
}
