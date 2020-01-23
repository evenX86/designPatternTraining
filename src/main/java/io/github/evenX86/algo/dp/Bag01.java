package io.github.evenX86.algo.dp;

/**
 * Created with design-pattern-training
 *
 * 0-1背包问题
 * @author xuyifei
 * @date 2020-01-13 10:15 下午
 */
public class Bag01 {

    /**
     *
     * @param weight 物体的重量
     * @param n 物品个数
     * @param w 背包可承载重量
     */
    public static int solve(int[] weight, int n, int w) {
        boolean[][] states = new boolean[n][w+1];
        states[0][0] = true;
        for (int i =1; i<n;i++) {
            // 不把第i个物品放入背包
            for (int j = 0 ; j<=w; j++) {
                if (states[i-1][j] == true) {
                    states[i][j] = states[i-1][j];
                }
            }
            // 把第i个物品放入背包
            for (int j=0;j<= w - weight[i];j++) {
                if(states[i-1][j] == true) {
                    states[i][j+weight[i]] = true;
                }
            }
        }

        for (int i = w; i >=0; i--) {
            if (states[n-1][i] == true) {
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] weight = new int[]{2,2,4,6,3};
        int n = 5;
        int w = 9;
        System.out.println(solve(weight, n , w));
    }
}
