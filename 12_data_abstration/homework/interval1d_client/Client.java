/******************************************************************************
 *  Compilation:  javac -cp .:../../../algs4.jar Client.java
 *  Execution:    java -cp .:../../../algs4.jar Client 10 < tests/10
 *  Dependencies: StdIn.java StdOut.java 
 *  Command Line: An Integer
 *  Data files:   tests/10
 *    
 *  A Interval1D client 
 *  
 *  1.2.2 read N interval1D values, and print all intersection pairs.
 *
 ******************************************************************************/

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Interval1D;

public class Client {
  public static void main(String[] args) {
    if (args.length == 0) {
      StdOut.printf("you must assign N as the first cmd param, which is an Integer\n");
      return;
    }
    int N = Integer.parseInt(args[0]);
    Interval1D[] intervals = new Interval1D[N];
    for(int i = 0; i < N; i++) {
      double x = StdIn.readDouble();
      double y = StdIn.readDouble();
      intervals[i] = new Interval1D(x, y);
    }

    intersections(intervals);
  }

  // a very slow function to print all Interval1D intersecting with each other
  public static void intersections(Interval1D[] intervals) {
    int len = intervals.length;
    for (int i = 0; i < len-1; i++) {
      for (int j = i+1; j < len; j++) {
        if (intervals[i].intersects(intervals[j])) {
          StdOut.printf("%s, %s\n", intervals[i], intervals[j]);
        }
      }
    }
  }
}