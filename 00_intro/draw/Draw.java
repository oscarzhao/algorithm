/******************************************************************************
 *  Compilation:  javac -cp ../../algs4.jar Draw.java
 *  Execution:    java -cp .:../../algs4.jar Draw
 *  Dependencies: StdIn.java StdDraw.java StdRandom.java  
 *  Data files:   input.txt
 *    
 *  A test client for testing StdDraw. 
 *
 *  % more input.txt
 *  8
 *
 *  % java -cp .:../../algs4.jar Draw < input.txt
 *  render a graph
 ******************************************************************************/
import java.util.Arrays;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

public class Draw {
  public static void main(String[] args) {
    String t = StdIn.readString();
    int n = StdIn.readInt();
    if (n < 100) n = 100;
    switch(t) {
      case "l":
      case "lines":
        drawLines(n);
        break;
      case "ra":
      case "random-array":
        drawRandomArray(n);
        break;
      case "sa":
      case "sorted-array":
        drawSortedArray(n);
        break;
      default:
        drawLines(n);
    }
  }

  public static void drawLines(int n) {
    StdOut.printf("shall draw a line with %d points\n", n);
    StdDraw.setXscale(0, n);
    StdDraw.setYscale(0, n*n);
    StdDraw.setPenRadius(.01);
    for (int i = 0; i <= n; i++) {
      StdDraw.point(i, i);
      StdDraw.point(i, i*i);   
      StdDraw.point(i, i*Math.log(i));
    }
  }

  public static void drawRandomArray(int n) {
    StdOut.printf("shall draw a random array with %d elements\n", n);
    double[] a = new double[n];
    for(int i = 0; i < n; i++) a[i] = StdRandom.uniform();
    for(int i = 0; i < n; i++) {
      double x = 1.0*i/n;
      double y = a[i]/2.0;
      double rw = 0.5/n;
      double rh = a[i]/2.0;
      StdDraw.filledRectangle(x, y, rw, rh);
    }
  }

  // sort an array 
  public static void drawSortedArray(int n) {
    StdOut.printf("shall draw a sorted array with %d elements\n", n);
    double[] a = new double[n];
    for(int i = 0; i < n; i++) a[i] = StdRandom.uniform();
    Arrays.sort(a);  // shall modify it
    for(int i = 0; i < n; i++) {
      double x = 1.0*i/n;
      double y = a[i]/2.0;
      double rw = 0.5/n;
      double rh = a[i]/2.0;
      StdDraw.filledRectangle(x, y, rw, rh);
    }
  }
}
