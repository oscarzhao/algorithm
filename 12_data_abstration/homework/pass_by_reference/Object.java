/******************************************************************************
 * Compilation:  javac -cp .:../../../algs4.jar Object.java
 * Execution:    java -cp .:../../../algs4.jar Object
 * Dependencies: StdOut.java 
 * Command Line: None
 * Data files:   none
 *  
 * Tests for Java Object 
 * 
 * 1.2.4
 * 1.2.5
 *
 * % java -cp .:../../../algs4.jar Object
 *
 ******************************************************************************/

import edu.princeton.cs.algs4.StdOut;

public class Object {
  public static void main(String[] args) {
    // 1.2.4
    String str1 = "hello";
    String str2 = str1;
    str1 = "world";
    StdOut.println(str1);  // world
    StdOut.println(str2);  // hello

    // 1.2.5
    String s = "Hello World";
    s.toUpperCase();
    s.substring(6, 11);
    StdOut.println(s);   // s does not change
  }
}