package io.github.evenX86.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with design-pattern-training
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 *
 * dp[i][j] = min (dp[i-1][j-1], dp[i-1][j]) + val[i][j];
 *
 *
 * val[i][j] 表示 第i 行 j 列 的值
 * @author xuyifei
 * @date 2019-03-19 10:09 PM
 */
public class SolutionMinimumTotal {
    public   int minimumTotal(List<List<Integer>> triangle) {
        int[][] dp = new int[triangle.size()][triangle.size()];
        int min = Integer.MAX_VALUE;
        for (int i=0;i<triangle.size();i++) {
            for (int j=0;j<triangle.get(i).size(); j++) {
                if (i>0 && i-1<j) {
                    dp[i-1][j] = Integer.MAX_VALUE;
                }
                dp[i][j] = i == 0 ? triangle.get(i).get(j) : j == 0 ? dp[i-1][j] + triangle.get(i).get(j) :
                        Math.min(dp[i-1][j], dp[i-1][j-1]) + triangle.get(i).get(j);
                if (i == triangle.size() -1) {
                    min = Math.min(min, dp[i][j]);
                }
            }
        }
        return min;
    }
    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> tmpList = new ArrayList<>();
        tmpList.add(2);
        triangle.add(tmpList);
        tmpList = new ArrayList<>();
        tmpList.add(3);
        tmpList.add(4);
        triangle.add(tmpList);


    }
}
