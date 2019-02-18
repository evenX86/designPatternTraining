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
        treeNode.right = new TreeNode(20);
        treeNode.right.left = new TreeNode(15);
        treeNode.right.right = new TreeNode(7);
        SolutionMaxDepth solutionMaxDepth = new SolutionMaxDepth();
        System.out.println(solutionMaxDepth.maxDepth(treeNode));
    }

}
