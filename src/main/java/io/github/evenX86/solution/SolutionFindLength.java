package io.github.evenX86.solution;

/**
 * Created with design-pattern-training
 * A: [1,2,3,2,1]
 * B: [3,2,1,4,7]
 *
 * dp[i][j] 表示A的第i位置和B的第j个位置的最长子序列长度
 * 依赖于dp[i-1][j-1] 即A的第i-1个位置和B的第j-1个位置的最长子序列的长度
 *
 * 前提是A[i-1] == B[j-1]
 * @author xuyifei
 * @date 2019-03-21 1:12 PM
 */
public class SolutionFindLength {
    public int findLength(int[] A, int[] B) {
        int max = 0;
        if (A.length <=0 || B.length <=0) return 0;
        int dp[][] = new int[A.length+1][B.length+1];
        for (int i=0;i<A.length +1; i++) {
            for (int j=0;j<B.length+1; j ++) {
                if(i==0 || j==0) {
                    dp[i][j] = 0;
                    continue;
                }
                if (A[i-1] == B[j-1]) {
                    dp[i][j] = dp[i-1][j-1] +1;
                    max = max > dp[i][j]? max: dp[i][j];
                }
            }
        }
        return max;
    }
    public static void main(String[] args) {
        SolutionFindLength solutionFindLength = new SolutionFindLength();
        int A[] = new int[]{1,2,3,2,1};
        int B[] = new int[]{3,2,1,67,5,31};
        System.out.println(solutionFindLength.findLength(A,B));
    }
}
