/******************************************************************************
 * Compilation:  javac -cp .:../../../algs4.jar Circular.java
 * Execution:    java -cp .:../../../algs4.jar Circular <str1> <str2>
 * Dependencies: StdIn.java StdOut.java 
 * Command Line: None
 * Data files:   none
 *  
 * A string s is a circular rotation of a string t if it matches when the characters
 * are circularly shifted by any number of positions; e.g. ACTGACG is a circular shift 
 * of TGACGAC, and vice versa. 
 * 
 * 1.2.6
 *
 * % java -cp .:../../../algs4.jar Circular <str1> <str2>
 *
 ******************************************************************************/

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Circular {
  public static void main(String[] args) {
    if (args.length < 2) {
      StdOut.println("two string are required as params");
      return;
    }
    String s = args[0];
    String t = args[1];
    StdOut.printf("String \"%s\" is a circular rotation of String \"%s\": %s\n", s, t, isCircular(s, t));
  }

  public static boolean isCircular(String s, String t) {
    if (s.length() != t.length()) return false;
    s = s + s;
    return s.contains(t);
  }
}