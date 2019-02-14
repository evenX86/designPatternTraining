package io.github.evenX86.leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with design-pattern-training
 *
 * @author xuyifei
 * @date 2019-02-14 10:26 PM
 */
public class SolutionMajorityElement {
    public int majorityElement(int[] nums) {
        Map<Integer,Integer> numsMap = new HashMap<>();
        for (int i: nums) {
            if (numsMap.containsKey(i)) {
                numsMap.put(i,numsMap.get(i)+1);
            } else {
                numsMap.put(i,1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : numsMap.entrySet()) {
            if (entry.getValue() > nums.length / 2) {
                return entry.getKey();
            }
        }
        return 0;
    }
}
