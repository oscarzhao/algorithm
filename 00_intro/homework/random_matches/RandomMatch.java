/******************************************************************************
 *  Compilation:  javac -cp ../../../algs4.jar RandomMatch.java
 *  Execution:    java -cp .:../../../algs4.jar RandomMatch 4
 *  Dependencies: StdIn.java StdOut.java StdRandom.java
 *    
 *  Random generate two arrays of N randomly generated positive
 *  six-digit int values, and get the number of values that 
 *  appears in both arrays.
 *
 *  Print a table giving the average of this quantity over the
 *  T trials (pass by command line) for each value of N.
 *  
 *  1.1.39
 *
 *  % java -cp .:../../algs4.jar RandomMatch 10
 *
 ******************************************************************************/
import java.util.Arrays;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class RandomMatch {
  public static void main(String[] args) {
    int T = Integer.parseInt(args[0]);
    int[] Ns = new int[4];
    Ns[0] = 1000;
    Ns[1] = 10000;
    Ns[2] = 100000;
    Ns[3] = 1000000;

    int[] avgcounts = new int[4];
    for (int i = 0; i < Ns.length; i++) {
      for(int j = 0; j < T; j++) {
        avgcounts[i] += intersection_count(Ns[i]);
      }
      avgcounts[i] /= T;
    }
    StdOut.printf("trial times: %d\n", T);
    for (int i = 0; i < 4; i++) {
      StdOut.printf("%-8d", Ns[i]);
    }
    StdOut.println();
    for (int i = 0; i < 4; i++) {
      StdOut.printf("%-8d", avgcounts[i]);
    }
    StdOut.println();
  }

  public static int intersection_count(int size) {
    int[] a = new int[size];
    for(int i = 0; i < size; i++) {
      a[i] = StdRandom.uniform(100000, 1000000);
    }
    Arrays.sort(a);
    int count = 0;
    for(int i = 0; i < size; i++) {
      if (binary_search(StdRandom.uniform(100000, 1000000), a) != -1) count++;
    }
    return count;
  }

  public static int binary_search(int key, int[] a) {
    int lo = 0;
    int hi = a.length -1;
    while(lo <= hi) {
      int mid = (lo + hi) / 2;
      if (key < a[mid]) hi = mid -1;
      else if (key > a[mid]) lo = mid + 1;
      else return mid;
    }
    return -1;
  }
}