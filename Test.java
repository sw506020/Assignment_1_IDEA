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
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        StringTokenizer st = new StringTokenizer("{{{{{this is a test");
        while (st.hasMoreTokens()) {
            System.out.println(st.nextToken());
            System.out.println();
        }
    }
}
}
}
}
