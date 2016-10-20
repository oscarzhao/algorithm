/******************************************************************************
 * Compilation:  javac -cp .:../../../algs4.jar VisualCounter.java
 * Execution:    java -cp .:../../../algs4.jar VisualCounter <Integer> <Interger>
 * Dependencies: StdIn.java StdOut.java 
 * Command Line: Two Intergers
 * Data files:   none
 * 
 * 1.2.10 Develop a class VisualCounter that allows both increment and decrement
 * operations.  Take two arguments N and max in the constructor, where N specifies
 * the maximum number of operations and max specifies the maximum absolute value 
 * for the counter.  As a side effect, create a plot showing the value of the 
 * counter each time its tally changes.
 *
 ******************************************************************************/

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

public class VisualCounter {
  private int operationLimit;
  private int operationConsumed;
  private int tallLimit;
  private int tallCurrent;

  public VisualCounter(int N, int max) {
    operationLimit = N;
    tallLimit = max;

    StdDraw.setXscale(0, N);
    StdDraw.setYscale(0, max);
    StdDraw.setPenRadius(.005);
  }

  public int tally() {
    return tallCurrent;
  }

  public void increment() {
    if (tallCurrent < tallLimit && operationConsumed < operationLimit) tallCurrent++;
    StdDraw.point(operationConsumed++, tallCurrent);
  }

  public void decrement() {
    if (tallCurrent > 0) tallCurrent--;
    else if (tallCurrent < 0 && tallCurrent > -tallLimit && operationConsumed < operationLimit) tallCurrent--;
    StdDraw.point(operationConsumed++, tallCurrent);
  }

  // a test case
  public static void main(String[] args) {
    if (args.length < 2) {
      StdOut.println("two string are required as params");
      return;
    }
    int N = Integer.parseInt(args[0]);
    int max = Integer.parseInt(args[1]);

    VisualCounter vc = new VisualCounter(N, max);
    for (int i = 0; i < N; i++) {
      if (StdRandom.uniform() > 0.3) {
        vc.increment();
      } else {
        vc.decrement();
      }
    }
  }
}