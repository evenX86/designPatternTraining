package io.github.evenX86.solution;

/**
 * Created with design-pattern-training
 *
 * @author xuyifei
 * @date 2019-08-08 11:20 PM
 */
public class SolutionJump {
    public int jump(int[] nums) {
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for(int i = 0; i < nums.length - 1; i++){
            //找能跳的最远的
            maxPosition = Math.max(maxPosition, nums[i] + i);
            if( i == end){ //遇到边界，就更新边界，并且步数加一
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }


    public static void main(String[] args) {
        SolutionJump solutionJump = new SolutionJump();
        int[] nums =  new int[]{7,0,9,6,9,6,1,7,9,0,1,2,9,0,3};
        System.out.println(solutionJump.jump(nums));
    }
}