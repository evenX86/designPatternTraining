package io.github.evenX86.solution;

/**
 * Created with design-pattern-training
 *
 * @author xuyifei
 * @date 2019-02-14 10:35 PM
 */
public class SolutionMaxProfit {
    public int maxProfit(int[] prices) {
        if (prices.length <=1) return 0;
        int profit = 0;
        for (int i =0 ;i<prices.length-1; i++) {
            if (prices[i+1] > prices[i]) profit += prices[i+1] - prices[i];

        }
        return profit;
    }
    public static void main(String[] args) {
        SolutionMaxProfit solutionMaxProfit = new SolutionMaxProfit();
        System.out.println(solutionMaxProfit.maxProfit(new int[]{1,2,3,4,5}));
        System.out.println(solutionMaxProfit.maxProfit(new int[]{7,1,5,3,6,4}));
    }
}
