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
            return myPow(x * x, n / 2);
        }
        if (n < 0) return 1 / myPow(x, -n);
        if (n % 2 != 0) {
            return x * myPow(x, n - 1);
        }
        return myPow(x * x, n / 2);
    }

    /**
     * fast pow
     * 快速幂解法，将n转换为二进制位
     * 3^11
     * 11 = 1011
     * 3^(2^3+2^1+2^0)
     * 3^8+3^2+3^1
     *
     * @param x
     * @param n
     * @return
     */
    public double myPow2(double x, int n) {
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        double pow = 1;
        while (n > 0) {
            if (n % 2 != 0) {
                pow *= x;
            }
            x *= x;
            n >>= 1;
        }
        return pow;
    }

    public static void main(String[] args) {
        SolutionMyPow solutionMyPow = new SolutionMyPow();
        double res = solutionMyPow.myPow2(2, 11);
        System.out.println(res);
    }
}
