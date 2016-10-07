/******************************************************************************
 *  Compilation:  javac -cp ../../algs4.jar BinarySearch.java
 *  Execution:    java -cp .:../../algs4.jar BinarySearch tinyW.txt < tinyT.txt
 *  Dependencies: In.java StdIn.java StdOut.java 
 *  Data files:   input.txt
 *    
 *  An implementation of BinarySearch with test client. 
 *
 *  % more input.txt
 *  8
 *
 *  % java -cp .:../../algs4.jar BinarySearch tinyW.txt < tinyT.txt
 *
 ******************************************************************************/

import java.util.Arrays;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class BinarySearch {
  public static int rank(int key, int[] a) {
    // Array must be sorted
    int lo = 0;
    int hi = a.length - 1;
    while(lo <= hi) {
      // key is in a[lo..hi] or not present
      int mid = (lo + hi) / 2;
      if (key < a[mid]) hi = mid - 1;
      else if (key > a[mid]) lo = mid + 1;
      else return mid;
    }
    return -1;
  }

  public static void main(String[] args) {
    int[] whitelist = In.readInts(args[0]);

    Arrays.sort(whitelist);
    while(!StdIn.isEmpty()) {
      // Read key, print if not in whitelist 
      int key = StdIn.readInt();
      if (rank(key, whitelist) < 0) {
        StdOut.println(key);
      }
    }
  }
}