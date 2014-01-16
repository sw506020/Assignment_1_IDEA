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
public class ArrayStack implements Stack {
    private int maxSize;
    private int emptyIndex;
    private int topIndex;
    //private String[] items;
    private Character[] items;
    
    public ArrayStack(int size) {
        maxSize = size;
        emptyIndex = -1;
        topIndex = emptyIndex;
        items = new Character[maxSize];
    }
    
    public void push(Character c) {
        if(maxSize == items.length)
            resize(2*items.length);
        topIndex++;
        items[topIndex] = c;
    }
    
    public Character pop() throws NoSuchElementException {
        if(isEmpty())
            throw new NoSuchElementException("Stack underflow");

        Character c = items[topIndex];
        items[topIndex] = null;
        topIndex--;
        
        if(maxSize > 0 && maxSize == items.length/4)
            resize(items.length/2);
        return c;
    }
    
    public boolean isEmpty() {
        return topIndex == emptyIndex;
    }
    
    public Character peek() {
        if (isEmpty()) return null;
        return items[topIndex];
    }
    
    private void resize(int capacity) {
        assert capacity >= maxSize;
        Character[] temp = new Character[capacity];
        for (int i = 0; i < maxSize; i++) {
            temp[i] = items[i];
        }
        items = temp;
    }

    
}
