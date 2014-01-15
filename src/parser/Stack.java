/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parser;

/**
 *
 * @author weiweisu
 */
public interface Stack {
    public abstract void push(Character c);
    public abstract Character pop();
    public abstract boolean isEmpty();
    public abstract Character peek();
}
