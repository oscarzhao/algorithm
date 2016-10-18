// package matrix;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Test {
  public static void main(String[] args) {
    String op = StdIn.readString();
    double[][] a, b;
    double[] x, y;
    switch(op) {
      case "dot":
        x = readVector();
        y = readVector();
        testDot(x, y);
        break;
      case "transpose":
        a = readMatrix();
        testTranspose(a);
        break;
      case "mult":
        String t = StdIn.readString();
        if (t.equals("mm")) {
          a = readMatrix();
          b = readMatrix();
          testMultMM(a, b);
        } else if (t.equals("mv")) {
          a = readMatrix();
          x = readVector();
          testMultMv(a, x);
        } else if (t.equals("vm")) {
          x = readVector();
          a = readMatrix();
          testMultVm(x, a);
        }
        break;
      default:
        StdOut.printf("invalid operation: %s\n", op);
    }
  }

  public static double[] readVector() {
    int size = StdIn.readInt();
    double[] result = new double[size];
    for (int i = 0; i < size;i++) {
      double val = StdIn.readDouble();
      result[i] = val;
    }
    return result;
  }

  public static double[][] readMatrix() {
    int row = StdIn.readInt();
    int col = StdIn.readInt();
    double[][] result = new double[row][col];
    for(int i = 0; i < row; i++) {
      for(int j = 0; j < col;j++) {
        double val = StdIn.readDouble();
        result[i][j] = val;
      }
    }
    return result;
  }

  // print a vector to stdout
  public static void printVector(double[] data) {
    int size = data.length;
    StdOut.println(size);
    for(int i = 0; i < size-1; i++) {
      StdOut.printf("%.0f ", data[i]);
    }
    StdOut.printf("%.0f\n", data[size-1]);
  }

  // print a matrix to stdout
  public static void printMatrix(double[][] data) {
    int row = data.length;
    int col = data[0].length;
    StdOut.printf("%d %d\n", row, col);
    for(int i = 0; i < row; i++) {
      for(int j = 0; j < col-1; j++) {
        StdOut.printf("%.0f ", data[i][j]);
      }
      StdOut.printf("%.0f\n", data[i][col-1]);
    }
  }

  public static void testDot(double[] x, double[] y) {
    double result = Matrix.dot(x,y);
    StdOut.printf("%.0f\n", result);
  }

  public static void testTranspose(double[][] a) {
    double[][] result = Matrix.transpose(a);
    printMatrix(result);
  }

  public static void testMultMM(double[][] a, double[][] b) {
    printMatrix(b);
    double[][] result = Matrix.mult(a, b);
    printMatrix(result);
  }

  public static void testMultMv(double[][] a, double[] x) {
    double[] result = Matrix.mult(a, x);
    printVector(result);
  }

  public static void testMultVm(double[] x, double[][] a) {
    double[] result = Matrix.mult(x, a);
    printVector(result);
  }
}