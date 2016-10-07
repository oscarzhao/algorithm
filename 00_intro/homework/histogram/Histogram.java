/******************************************************************************
 *  Compilation:  javac -cp ../../../algs4.jar Histogram.java
 *  Execution:    java -cp .:../../../algs4.jar Histogram 100 0.0 100.0 < tests/xx
 *  Dependencies: StdIn.java StdOut.java StdDraw.java
 *    
 *  An implementation of drawing a histogram
 *  command line params: an integer N and two double values l and r (r-l is divied by N parts)
 *  standard input: a sequence of double values
 *  
 *  1.1.32
 *
 *  % java -cp .:../../algs4.jar Histogram tests/1.cmd < tests/1
 *
 ******************************************************************************/

import java.util.Arrays;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

public class Histogram {
  public static void main(String[] args) {
    if (args.length < 1) {
      StdOut.println("invalid command, command line file need to be set");
      return;
    }

    double[] cmds = In.readDoubles(args[0]);
    int N = (int)Math.round(cmds[0]);
    double l = cmds[1];
    double r = cmds[2];

    double[] data = StdIn.readDoubles();
    double[] results = calculate(N, l, r, data);
    draw(results);
  }

  public static double[] calculate(int N, double l, double r, double[] data) {
    double[] results = new double[N];
    double unit = (r - l)/N;
    for (int i = 0; i < data.length; i++) {
      int idx = (int)((data[i] - l) / unit);
      results[idx]++;
    }
    for (int i = 0; i < results.length; i++) {
      results[i] /= N;
    }
    return results;
  }

  public static void draw(double[] data) {
    int N = data.length;
    for (int i = 0; i < N; i++) {
      double x = 1.0 * i / N;
      double y = data[i] / 2.0;
      double rw = 0.5 / N;
      double rh = data[i]/2.0;
      StdDraw.filledRectangle(x, y, rw, rh);
    }
  }

  // the following functions are used to generate test data (according to tests/xxx.cmd)
  // java -cp .;../../../algs4.jar Histogram tests/2.cmd > tests/2


  // public static void main(String[] args) {
  //   double[] inputs = In.readDoubles(args[0]);
  //   int count = (int)Math.round(inputs[0] * Math.random() * 10);
  //   printDoubles(count, inputs[1], inputs[2]);
  // }

  // printDoubles generates a list of doubles, which is [min,max)
  public static void printDoubles(int count, double min, double max) {
    for(int i = 0; i < count; i++) StdOut.println(randomDouble(min, max));
  }

  public static double randomDouble(double min, double max) {
    return Math.random() * (max - min) + min;
  }
}