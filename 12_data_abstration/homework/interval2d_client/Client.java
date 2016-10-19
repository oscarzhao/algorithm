/******************************************************************************
 * Compilation:  javac -cp .:../../../algs4.jar Client.java
 * Execution:    java -cp .:../../../algs4.jar Client N min max
 * Dependencies: StdIn.java StdOut.java StdRandom.java Interval1D Interval2D
 * Command Line: Three Intergers
 * Data files:   none
 *  
 * A Interval2D client 
 * 
 * 1.2.3 Random generating N Interval2D objects
 * 1. draw them
 * 2. print all intersection pairs
 * 3. print all interval pairs of which one contains another
 *
 ******************************************************************************/

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.Interval2D;


public class Client {
  public static void main(String[] args) {
    if (args.length < 3) {
      StdOut.printf("you must assign N as the first cmd param, which is an Integer\n");
      return;
    }
    int N = Integer.parseInt(args[0]);
    double min = Double.parseDouble(args[1]);
    double max = Double.parseDouble(args[2]);
    if (min > max) {
      StdOut.printf("min %d cannot be bigger than max %d\n", min, max);
      return;
    }

    Interval2D[] intervals = new Interval2D[N];
    for(int i = 0; i < N; i++) {
      Interval1D x, y;

      double a1 = StdRandom.uniform(min, max);
      double a2 = StdRandom.uniform(min, max);
      if (a1 < a2) x = new Interval1D(a1, a2);
      else  x = new Interval1D(a2, a1);

      a1 = StdRandom.uniform(min, max);
      a2 = StdRandom.uniform(min, max);
      if (a1 < a2) y = new Interval1D(a1, a2);
      else  y = new Interval1D(a2, a1);

      intervals[i] = new Interval2D(x, y);
    }

    StdOut.printf("intersections: %d\n", countIntersections(intervals));

    // print contains
    // StdOut.printf("contains: %d\n", countContains(intervals));

    // draw all intervals
    StdDraw.setXscale(min, max);
    StdDraw.setYscale(min, max);
    draw(intervals);
  }

  public static void draw(Interval2D[] intervals) {
    for (int i = 0; i < intervals.length; i++) {
      intervals[i].draw();
    }
  }

  // a very slow function to count all Interval2D intersecting with each other
  public static int countIntersections(Interval2D[] intervals) {
    int len = intervals.length;
    int count = 0;
    for (int i = 0; i < len-1; i++) {
      for (int j = i+1; j < len; j++) {
        if (intervals[i].intersects(intervals[j])) {
          count++;
        }
      }
    }
    return count;
  }

  // a very slow function to count the pairs of intervals of which one contains another
  // Interval2D only implements contains(Point2D), so skip this problem
  // public static int countContains(Interval2D[] intervals) {
  //   int count = 0;
  //   int len = intervals.length;
  //   for (int i = 0; i < len; i++) {
  //     for (int j = i+1; j < len; j++) {
  //       if (intervals[i].contains(intervals[j]) || intervals[j].contains(intervals[i])) {
  //         count ++;
  //       }
  //     }
  //   }
  //   return count;
  // }
}