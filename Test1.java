/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.StringTokenizer;

/**
 *
 * @author Administrator
 */
public class Test1 {
    { public static void main(String[] args) {
        StringTokenizer st = new StringTokenizer("this is a test");
        while (st.hasMoreTokens()) {
            System.out.println(st.nextToken());
        }
    }
}
