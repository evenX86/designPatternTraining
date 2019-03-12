package io.github.evenX86.leetCode;

/**
 * Created with design-pattern-training
 *
 * @author xuyifei
 * @date 2019-03-12 11:13 PM
 */
public class SolutionClimbStairs {
    public static int climbStairs(int n) {
        if (n<=2) return n;
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i=3;i<=n;i++) {
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
    public static void main(String[] args) {
        System.out.println(climbStairs(3));
    }
}
