package io.github.evenX86.solution;

/**
 * Created with design-pattern-training
 *
 * @author xuyifei
 * @date 2019-07-31 8:52 AM
 */
public class SolutionAtMostNGivenDigitSet {

    public int atMostNGivenDigitSet(String[] D, int N) {
        int cnt = 0;
        int n = N;
        while (n>0) {
            n = n/10;
            cnt += 1;
        }
        String mStr = String.valueOf(N);
        String[] digitStrArr = mStr.split("");


        int len = D.length;
        int sum = 0;
        // 算出小于其位数的种类数量之和
        for (int i=1;i<cnt;i++) {
            int tmpSum = len;
            for (int j=1;j<i;j++) {
                tmpSum *= len;
            }
            sum += tmpSum;
        }
        // 计算与其位数一致情况下符合的数量


        int lastSum = 0;
        for (int i=0;i<digitStrArr.length ; i++) {
            int val = Integer.valueOf(digitStrArr[i]);
            int tmpCnt = 0;
            for (int j =0; j<D.length;j++) {
                int dVal = Integer.valueOf(D[j]);
                if (j==0 && val<dVal) {
                    lastSum =0;
                    break;
                }
                if (val >= dVal) {
                    tmpCnt ++;
                } else {
                    break;
                }
            }
            if (tmpCnt == 0) {
                break;
            }
            if (lastSum == 0 ){
                lastSum = tmpCnt;
            } else {
                lastSum *= tmpCnt;

            }
        }
        if (lastSum > 0) {
            sum += lastSum;
        }

        return sum;
    }

    public static void main(String[] args) {
        SolutionAtMostNGivenDigitSet solutionAtMostNGivenDigitSet = new SolutionAtMostNGivenDigitSet();
        String[] arr = new String[]{"3","4","5","6"};
        int sum = solutionAtMostNGivenDigitSet.atMostNGivenDigitSet(arr, 64);
        System.out.println(sum);
    }
}
