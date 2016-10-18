/******************************************************************************
 *  Compilation:  javac -cp ../../../algs4.jar RandomConnection.java
 *  Execution:    java -cp .:../../../algs4.jar RandomConnection < tests/xx
 *  Dependencies: StdIn.java StdOut.java StdDraw.java StdRandom.java
 *    
 *  An implementation of drawing dots on a circle and randomly connecting them. 
 *  
 *  1.1.31
 *
 *  % java -cp .:../../algs4.jar RandomConnection
 *
 ******************************************************************************/

import java.util.Arrays;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

public class RandomConnection {
  public static void main(String[] args) {
    int N = StdIn.readInt();
    double p = StdIn.readDouble();
    if (p < 0 || p > 1.0) {
      StdOut.printf("invalid p: %f\n", p);
    }
    StdOut.printf("draw(%d, %f)\n", N, p);
    // draw a circle with n dots, and randomly connects them
    draw(N, p);
  }
  // draw
  public static void draw(int N, double p) {
    StdDraw.setXscale(-210.0, 210.0);
    StdDraw.setYscale(-210.0, 210.0);
    double r = 200.0;
    double[] xs = new double[N];
    double[] ys = new double[N];
    double radianUnit = Math.PI * 2.0 / N;
    // StdDraw.setPenRadius(0.05);
    for (int i = 0; i < N; i++) {
      xs[i] = Math.cos(radianUnit*i) * r;
      ys[i] = Math.sin(radianUnit*i) * r;
      StdDraw.point(xs[i], ys[i]);
    }
    StdDraw.setPenColor(StdDraw.GRAY);
    for (int i = 1; i < N; i++) {
      for (int j = 0; j < i; j++) {
        if (StdRandom.bernoulli(p)) StdDraw.line(xs[i], ys[i], xs[j], ys[j]);
      }
    }

  }
}