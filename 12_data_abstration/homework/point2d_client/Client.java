/******************************************************************************
 *  Compilation:  javac -cp .:../../../algs4.jar Client.java
 *  Execution:    java -cp .:../../../algs4.jar Client 4
 *  Dependencies: StdIn.java StdOut.java 
 *  Command Line: An Integer
 *  Data files:   none
 *    
 *  A Point2D client 
 *  
 *  1.2.1
 *
 *  % java -cp .:../../../algs4.jar Client 4
 *
 ******************************************************************************/

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Point2D;

public class Client {
  public static void main(String[] args) {
    if (args.length == 0) {
      StdOut.printf("you must assign N as the first cmd param, which is an Integer\n");
      return;
    }
    int N = Integer.parseInt(args[0]);
    Point2D[] points = new Point2D[N];
    for(int i = 0; i < N; i++) {
      points[i] = new Point2D(StdRandom.uniform(), StdRandom.uniform());
    }

    StdOut.printf("shortest distance:%f\n", closest(points));
  }

  // a very slow function to calculate shortest distance between points
  public static double closest(Point2D[] points) {
    int len = points.length;
    double shortest = 1.0;
    for (int i = 0; i < len-1; i++) {
      for (int j = i+1; j < len; j++) {
        double dist = points[i].distanceTo(points[j]);
        if (dist < shortest) shortest = dist;
      }
    }
    return shortest;
  }
}