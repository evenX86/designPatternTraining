package io.github.evenX86.solution;

/**
 * Created with design-pattern-training
 *
 * 4, [[1,0],[2,0],[3,1],[3,2]]
 * @author xuyifei
 * @date 2019-08-09 10:40 PM
 */
public class SolutionFindOrder {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        int[] res = new int[numCourses];
        if (prerequisites.length <= 0)  {
            return res;
        }
        int i = 0;
        for (int[] pre1 : prerequisites) {
            int a = pre1[0];
            // 前置课程b
            int b = pre1[1];
            res[i] = b;
            res[i+1] = a;
        }
        return res;
    }
}
