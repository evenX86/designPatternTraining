package io.github.evenX86.solution;

/**
 * Created with design-pattern-training
 *
 * @author xuyifei
 * @date 2019-07-30 8:32 PM
 */
public class SolutionDistributeCoins {
    private Integer cnt = 0;
    public int distributeCoins(TreeNode root) {
        lrd(root);
        return cnt;

    }

    private int lrd(TreeNode node) {
        if (node == null) {
            return 0;
        }
        if (node.left != null) {
            node.val += lrd(node.left);
        }
        if (node.right != null) {
            node.val += lrd(node.right);
        }
        cnt += Math.abs(node.val -1);
        return node.val -1;
    }

    public static void main(String[] args) {
        SolutionDistributeCoins solutionDistributeCoins = new SolutionDistributeCoins();
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(0);
        treeNode.right = new TreeNode(0);
        treeNode.left.right = new TreeNode(3);
        solutionDistributeCoins.distributeCoins(treeNode);
        System.out.println(solutionDistributeCoins.cnt);
    }
}
