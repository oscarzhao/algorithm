/******************************************************************************
 *  Compilation:  javac -cp ../../../algs4.jar ArrayPrime.java
 *  Execution:    java -cp .:../../../algs4.jar ArrayPrime < tests/xx
 *  Dependencies: StdIn.java StdOut.java 
 *  Data files:   input.txt
 *    
 *  Initialize a two-dimensional array, if i and j is prime to each other
 *  set a[i][j] = true, false otherwise.
 *  
 *  1.1.30
 *
 *  % java -cp .:../../algs4.jar ArrayPrime < tests/xx
 *
 ******************************************************************************/

import java.util.Arrays;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class ArrayPrime {
  public static void main(String[] args) {
    int M = StdIn.readInt();
    int N = StdIn.readInt();
    StdOut.printf("createArray(%d, %d)\n", M, N);
    boolean[][] results = createArray(M, N);
    StdOut.printf("   ");
    for(int i = 0; i < N; i++) StdOut.printf("%-3d", i);
    StdOut.println();
    for(int i = 0; i < M; i++) {
      StdOut.printf("%-3d", i);
      for(int j = 0; j < N; j++) {
        if (results[i][j]) StdOut.printf("T  ");
        else StdOut.printf("F  ");
      }
      StdOut.println();
    }
  }

  public static boolean[][] createArray(int M, int N) {
    boolean[][] results = new boolean[M][N];
    for (int i = 0; i < M; i++) {
      for (int j = 0; j < N; j++) {
        if (i == 0 || j == 0) continue;
        if (i > j && i % j != 0) {
          results[i][j] = true;
        } else if (i < j && j % i != 0) {
          results[i][j] = true;
        }
      }
    }
    return results;
  }
}