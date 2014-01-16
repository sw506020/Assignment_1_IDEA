/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parser;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.StringTokenizer;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author weiweisu
 */
public class Parser {

    private static int ONE = 1;
    private static int TWO = 2;
    private static Date begin;
    private static Date finish;

    public static Stack chooseStackImplementation() {
        Stack stack = null;
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println();
            System.out.println("<--Second Step-->:");
            System.out.println("  2> Select a Stack Implementation(Enter the number prefix options):\n");
            System.out.println("  1--Array Implementation;");
            System.out.println("  2--Linked-list Implementation. \n");
            System.out.print("  Make choise: ");
            System.out.flush();
            String chosen = scanner.nextLine();
            //String chosen = System.console().readLine();
            //System.out.println();
            int chosenInt = 0;
            try {
                chosenInt = Integer.parseInt(chosen);
            } catch (Exception e) {
                System.out.println("Invalid input, please try again.");
                continue;
            }

            if (chosenInt == ONE) {
                stack = new ArrayStack(20);
                System.out.println("Array Implementation has been chosen!\n");
                break;
            } else if (chosenInt == TWO) {
                stack = new LinkStack();
                System.out.println("Linked Implementation has been chosen!\n");
                break;
            } else {
                System.out.println("Invalid input, please try again.\n");
                continue;
            }
        }
        scanner.close();
        return stack;
    }

    public static File scanInput() {
        File file = null;
        String filename = null;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("<--First Step-->:");
            System.out.println("  1> Select a java file to be tested: \n");
            System.out.println("  1--Test.java");
            System.out.println("  2--Test1.java\n");
            System.out.print("  Please select: ");
            System.out.flush();
            String chosen = scanner.nextLine();
            System.out.println(chosen);
            int chosenInt = 0;
            try {
                chosenInt = Integer.parseInt(chosen);
                System.out.print("  Parsing");
            } catch (Exception e) {
                System.out.println("Invalid input, please try again.");
                continue;
            }

            if (chosenInt == ONE) {
                filename = "Test.java";
                break;
            } else if (chosenInt == TWO) {
                filename = "Test1.java";
                break;
            } else {
                System.out.println("Invalid input, please try again.\n");
                continue;
            }
        }
        if (filename != null)
            file = new File(filename);

        return file;
    }

    public static String tokenizerFile(File file) {
        String fileString = null;
        try {
            fileString = FileUtils.readFileToString(file);
        } catch (IOException e) {
            System.out.println("file is not existed!");
            e.printStackTrace();
        }
        return fileString;
    }

    //为什么要把warning存在变量里？
    static String warning;
    static String warningC;
    static int count = 0;

    public static boolean isBracketMatch(String s, Stack stack) {
        begin = new Date();
        boolean hasCitation = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            hasCitation = (c == '"' ? false : true);

            if (!hasCitation) {
                switch (c) {
                    case '{' : stack.push(c);
                        break;

                    case '}':
                        try {
                            stack.pop();
                        } catch (NoSuchElementException e) {
                            warning = "Begin with closing curly bracket.";
                            return false;
                        }
                        break;

                    // you can also add some other case here, such as '<' '>' match

                    default: // may be some other logic
                }
            }
        }

        if (!stack.isEmpty())
            warning = "Too many opening curly brackets.";

        if (hasCitation)
            warningC = "Unmatched citations";

        return stack.isEmpty() && !hasCitation;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        File file = scanInput();
        if (file == null) {
            System.out.print("file is null");
            return;
        }
        String fileString = tokenizerFile(file);
        Stack stack = chooseStackImplementation();
        if (stack == null) {
            System.out.println("stack is null");
            return;
        }

        if (fileString == null) {
            System.out.println("fileString is null!!!");
        }
        StringTokenizer st = new StringTokenizer(fileString);
        while (st.hasMoreTokens()) {
            st.nextToken();
            count++;
        }



        boolean isMatch = isBracketMatch(fileString, stack);
        System.out.println("<--Third Step-->: (Enjoy the output)");
        System.out.println();
        if (isMatch) {
            System.out.println("---The curly brackets in this java class file are matched.\n");
        } else {
            System.out.println("---The full curly brackets pattern is: \n");
            System.out.println(fileString);
            System.out.println("---The curly brackets in this java class file are not matched.\n");
            System.out.println("---The reason is: " + warning + "\n");
            System.out.println("---Condition of citations is: " + (warningC == null ? "Good" : warningC) + "\n");
            System.out.println("---Number of tokens are: " + count + "\n");
        }

        finish = new Date();
        System.out.println("---Begin time in milliseconds is: " + finish.getTime() + "\n");
        System.out.println("---Finish time in milliseconds is: " + finish.getTime() + "\n");
        System.out.println("---The millseconds of the process is: " + (finish.getTime() - begin.getTime()) + "\n");
        System.out.println("---Thanks!");
    }
}
