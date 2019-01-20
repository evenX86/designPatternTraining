package io.github.evenX86.leetCode;

import java.util.*;

public class SolutionThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> reslist = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return reslist;
        }
        Arrays.sort(nums);
        int length = nums.length;
        Set<String> stringSet = new HashSet<>();
        for (int i = 0 ; i < length; i++) {
            Set<Integer> numSet = new HashSet<>(length);
            for (int j = i +1 ; j < length ; j++) {
                if (numSet.contains(nums[j]) && !stringSet.contains(""+nums[i]+nums[j]+(-nums[i]-nums[j]))) {
                    List<Integer> tmpList = new ArrayList<>();
                    tmpList.add(nums[i]);
                    tmpList.add(nums[j]);
                    tmpList.add(-nums[i]-nums[j]);
                    reslist.add(tmpList);
                    stringSet.add(""+nums[i]+nums[j]+(-nums[i]-nums[j]));
                } else {
                    numSet.add(-nums[i]-nums[j]);
                }
            }
        }
        return reslist;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums));
    }
}
