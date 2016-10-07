/******************************************************************************
 *  An implementation of Matrix library 
 *  
 *  1.1.33
 *
 ******************************************************************************/
// package matrix;

public class Matrix {
  // vector dot product (no error handling)
  public static double dot(double[] x, double[] y) {
    double result = 0.0;
    for (int i = 0; i < x.length; i++) {
      result += x[i] * y[i];
    }
    return result;
  }

  // metrix-metrix product
  public static double[][] mult(double[][] a, double[][] b) {
    if (a.length == 0 || a[0].length ==0 || b.length == 0 || b[0].length == 0) return null;
    int r = a.length;
    int c = b[0].length;
    double[][] result = new double[r][c];
    for(int i = 0; i < r; i++ ) {
      for (int j = 0; j < c; j++ ){
        for (int k = 0; k < a[r].length; k++) {
          result[i][j] += a[i][k] * b[k][j];
        }
      }
    }
    return result;
  }

  public static double[][] transpose(double[][] a) {
    if (a.length == 0||a[0].length == 0) return null;
    int row = a.length;
    int col = a[0].length;
    double[][] result = new double[col][row];
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        result[j][i] = a[i][j];
      }
    }
    return result;
  }

  // metrix-vector product
  public static double[] mult(double [][] a, double[] x) {
    int row = a.length;
    double[] result = new double[row];
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < x.length; j ++) {
        result[i] += a[i][j] * x[j];
      }
    }
    return result;
  }

  // vector-metrix product
  public static double[] mult(double[] x, double[][] a) {
    int col = x.length;
    double[] result = new double[col];
    for(int i = 0; i < col; i++) {
      for(int j = 0; j < a.length; j++) {
        result[i] += a[i][j] * x[i];
      }
    }
    return result;
  }
}