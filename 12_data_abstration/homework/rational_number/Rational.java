/******************************************************************************
 * Compilation:  javac -cp .:../../../algs4.jar Rational.java
 * Execution:    java -cp .:../../../algs4.jar Rational <Integer> <Interger>
 * Dependencies: StdIn.java StdOut.java 
 * Command Line: Two Intergers
 * Data files:   none
 * 
 * 1.2.16 Rational Numbers.  Implement an immutable data type Rational for
 * rational numbers that supports addition, subtraction, multiplication, and
 * division.
 *
 ******************************************************************************/

import edu.princeton.cs.algs4.StdOut;

public class Rational {
  private long numerator;
  private long denominator;

  private long gcd(long a, long b) {
    if (a == 0 || b == 0) return 0;
    if (a < b) {
      long tmp = a;
      a = b;
      b = tmp;
    }
    while (b != 0) {
      long tmp = b;
      b = a % b;
      a = tmp;
    }
    return a;
  }

  private long lcm(long a, long b) {
    long tmp = gcd(a, b);
    if (tmp == 0) return 0;
    return a/tmp * b;
  }

  public Rational(int num, int den) {
    if (den == 0) throw new IllegalArgumentException("denominator cannot be ZERO!");
    long tmp = gcd(num, den);
    if (tmp == 0) {
      numerator = 0;
      denominator = 1;
    } else {
      numerator = num/tmp;
      denominator = den/tmp;
    }

    if (denominator < 0 ) {
      denominator = - denominator;
      numerator = - numerator;
    }
  }

  public Rational(long num, long den) {
    if (den == 0) throw new IllegalArgumentException("denominator cannot be ZERO!");
    long tmp = gcd(num, den);
    if (tmp == 0) {
      numerator = 0;
      denominator = 1;
    } else {
      numerator = num/tmp;
      denominator = den/tmp;
    }

    if (denominator < 0 ) {
      denominator = - denominator;
      numerator = - numerator;
    }
  }

  public Rational plus(Rational b) {
    if (this.numerator == 0 ) return new Rational(b.numerator, b.denominator);
    if (b.numerator == 0) return new Rational(this.numerator, this.denominator);
    long den = lcm(this.denominator, b.denominator);
    long num = den/this.denominator * this.numerator + den/b.denominator * b.numerator;
    return new Rational(num, den);
  }

  public Rational minus(Rational b) {
    if (this.numerator == 0 ) return new Rational(-b.numerator, b.denominator);
    if (b.numerator == 0) return new Rational(this.numerator, this.denominator);
    long den = lcm(this.denominator, b.denominator);
    long num = den/this.denominator * this.numerator - den/b.denominator * b.numerator;
    return new Rational(num, den);
  }

  public Rational times(Rational b) {
    Rational tmp1 = new Rational(this.numerator, b.denominator);
    Rational tmp2 = new Rational(b.numerator, this.denominator);
    return new Rational(tmp1.numerator * tmp2.numerator, tmp1.denominator * tmp2.denominator);
  }

  public Rational divide(Rational b) {
    return times(new Rational(b.denominator, b.numerator));
  }

  public boolean equals(Rational that) {
    if (this.numerator == 0 && that.numerator == 0) return true;
    return this.numerator == that.numerator && this.denominator == that.denominator; 
  }

  public String toString() {
    return this.numerator + "/" + this.denominator;
  }

  // a test case
  public static void main(String[] args) {
    Rational zero = new Rational(0, 1);
    Rational zero1 = new Rational(0, 2);
    if (zero.equals(zero1) == false) {
      StdOut.printf("zero cannot be different\n");
      return;
    }

    Rational a = new Rational(2, 5);
    Rational b = new Rational(3, 7);
    StdOut.printf("%s + %s = %s\n", a, b, a.plus(b));
    StdOut.printf("%s - %s = %s\n", a, b, a.minus(b));
    StdOut.printf("%s * %s = %s\n", a, b, a.times(b));
    StdOut.printf("%s / %s = %s\n", a, b, a.divide(b));
  }
}