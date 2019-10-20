package io.github.evenX86.solution;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created with design-pattern-training
 *
 * 算法是 a-z = 1-26 给一个数组，比如123，求能解析出多少种组合 12可以连着看成一个
 * 123
 * 1 2 3
 * 1 23
 * 12 3
 *
 * 122223
 *
 * 1
 * F[0] = 1
 * 1 12 2
 * F[1] = F[0] + 1 (if not exist)
 * F[2] = F[1] + F[0]
 *
 * F[i] = F[i-1] + F[i-2]
 *
 * 1 2  3
 * 12 2 3
 *
 * 1 22 3
 * 12 22 3
 *
 * 12 22 23
 * 1 22 23
 * 1 2 23
 * 12 2 23
 *
 * F[3] = F[3] + F[23] = 4 + 4 = 8
 * F[23] = F[2] + F[22] = 2 + 2 = 4
 * F[2] = F[1] + F[12] = 1 + 1 = 2
 * F[22] = F[1] + F[12] = 1 + 1 = 2
 *
 * =>
 *
 * F[i] = F
 *
 *
 *
 * @author xuyifei
 * @date 2019-10-20 5:13 PM
 */
public class SolutionAz extends BaseSolution{
    public Integer countArr(int[] arr) {
        int num = 0;
        if (arr == null || arr.length <= 0) {
            return num;
        }
        Set<Integer> charSet = new HashSet<>(26);
        int singleNum = 0;
        int[] F = new int[arr.length];
        Arrays.fill(F, 0);
        F[0] = 1;
        F[1] = 2;
        for (int i = 2;i<arr.length;i++) {
            // check i if occurs
            if (!charSet.contains(i)) {
                singleNum ++;
                charSet.add(i);
            }
            F[i] = F[i-1] + F[i-2];
        }
        return num;
    }


}
