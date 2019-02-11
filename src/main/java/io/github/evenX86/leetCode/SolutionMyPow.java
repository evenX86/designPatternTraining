package io.github.evenX86.leetCode;

/**
 * Created with design-pattern-training
 *
 * @author xuyifei
 * @date 2019-02-06 9:14 AM
 */
public class SolutionMyPow {
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        if (n == Integer.MIN_VALUE) {
            return myPow(x*x,n/2);
        }
        if (n < 0) return 1 / myPow(x, -n);
        if (n % 2 != 0) {
            return x * myPow(x, n - 1);
        }
        return myPow(x * x, n / 2);

    }

    public static void main(String[] args) {
        SolutionMyPow solutionMyPow = new SolutionMyPow();
        double res = solutionMyPow.myPow(1, -2147483648);
        System.out.println(res);
    }
}
