/******************************************************************************
 *  Compilation:  javac -cp ../../../algs4.jar Binomial.java
 *  Execution:    java -cp .:../../../algs4.jar Binomial < tests/xx
 *  Dependencies: StdIn.java StdOut.java 
 *  Data files:   input.txt
 *    
 *  An implementation of quick Binomial with test client. 
 *
 *
 *  % java -cp .:../../algs4.jar Binomial < tests/xx
 *
 ******************************************************************************/

import java.util.Arrays;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Binomial {
  public static void main(String[] args) {
    int N = StdIn.readInt();
    int k = StdIn.readInt();
    double p = StdIn.readDouble();
    if (p < 0 || p > 1.0) {
      StdOut.printf("invalid p: %f\n", p);
    }
    StdOut.printf("binomial(%d, %d, %f) = %f\n", N, k, p, binomial_quick(N, k, p));
  }
  // the slow version of binomial
  public static double binomial(int N, int k, double p) {
    if (N == 0 && k ==0) return 1.0;
    if (N < 0 || k < 0) return 0.0;
    return (1.0 -p)*binomial(N-1, k, p) + p*binomial(N-1, k-1, p);
  }

  public static double binomial_quick(int N, int k, double p) {
    double[][] results = new double[N+1][k+1];
    results[0][0] = 1.0;
    for (int i=1; i < k+1; i++) {
      results[0][i] = 0.0;
    }
    double q = 1.0 -p;
    for (int i=1; i < N+1; i++) {
      results[i][0] = results[i-1][0] * q;
    }
    for(int i = 1; i < N+1; i++) {
      for (int j = 1; j < k+1; j++) {
        results[i][j] = q * results[i-1][j] + p * results[i-1][j-1];
      }
    }
    return results[N][k];
  }
}