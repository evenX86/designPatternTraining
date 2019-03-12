package io.github.evenX86.leetCode;

/**
 * Created with design-pattern-training
 *
 *
 dp[6] = dp[5] + dp[4]

 dp[n] = dp[n-1] + dp[n-2]

 dp[1] = 1
 dp[2] = 2

 递归+记忆化

 dp[i] 是 有可能被重复计算的

 增加mem[i] 保存中间状态
 dp[3] = dp[2] + dp[1]

 状态转移公式：

 dp[i] = dp[i01]
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
