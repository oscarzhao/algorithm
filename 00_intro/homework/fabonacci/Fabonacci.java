/******************************************************************************
 *  Compilation:  javac -cp ../../../algs4.jar Fabonacci.java
 *  Execution:    java -cp .:../../../algs4.jar Fabonacci
 *  Dependencies: StdOut.java
 *  Data files:   none
 *    
 *  An quick implementation and a test client for testing Fabonacci.
 *  1.1.19
 *
 *  % java -cp .:../../../algs4.jar Fabonacci
 *  print Fabonacci number of from 1 to 100 (slow version and quick version)
 *
 *  warning: when N is too big, overflow happens
 ******************************************************************************/

import edu.princeton.cs.algs4.StdOut;

public class Fabonacci {
  // F is the slow version, which is very slow, implemented by recursion
  public static long F(int N) {
    if (N == 0) return 0;
    if (N == 1) return 1;
    return F(N-1) + F(N-2);
  }

  // FQuick is the fast version, implemented via iteration
  public static long FQuick(int N) {
    long a = 1, b = 0;
    if (N == 0) return b;
    if (N == 1) return a;
    while(N > 1) {
      long t = a;
      a = a + b;
      b = t;
      N--;
    }
    return a;
  }

  public static void main(String[] args) {
    for (int N = 0; N < 100; N++) {
      StdOut.println(N + " " + FQuick(N));
    }
  }
}
