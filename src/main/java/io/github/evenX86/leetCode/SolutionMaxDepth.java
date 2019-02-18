package io.github.evenX86.leetCode;

/**
 * Created with design-pattern-training
 *
 * @author xuyifei
 * @date 2019-02-18 9:20 PM
 */
public class SolutionMaxDepth {
    public int maxDepth(TreeNode root) {
        int i = 0;
        int max = 0;
        return dfs(root, i, max);
    }

    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int i = 1;
        int min = Integer.MAX_VALUE;
        return dfsII(root, i, min);
    }
    private int dfsII(TreeNode root, int i, int min) {
        if (root == null) return min;
        if (root.left == null && root.right == null) {
            if (min > i) {
                min = i;
            }
            return min;
        }
        int minleft =  dfsII(root.left, i+1 , min);
        if (min > minleft) min = minleft;
        int minright = dfsII(root.right, i+1 , min);
        if (min > minright) min = minright;
        return min;
    }

    private int dfs(TreeNode root, int i,int max) {
        if (root == null) {
            return i;
        }
        i = i+1;
        int depthLeft = dfs(root.left,i,max);
        if (max <depthLeft) {
            max = depthLeft;
        }
        int depthRight = dfs(root.right,i,max);
        if (max <depthRight) {
            max = depthRight;
        }
        return max;
    }
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(9);
        treeNode.left.left = new TreeNode(19);
        treeNode.left.left.left = new TreeNode(29);
        treeNode.left.left.left.left = new TreeNode(39);
        SolutionMaxDepth solutionMaxDepth = new SolutionMaxDepth();
        System.out.println(solutionMaxDepth.minDepth(treeNode));
    }

}
