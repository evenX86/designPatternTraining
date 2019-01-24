package io.github.evenX86.leetCode;

/**
 * Created with design-pattern-training
 *
 * @author xuyifei
 * @date 2019-01-23 11:47 PM
 */
public class SolutionLowestCommonAncestor {

    /**
     * 在root树种寻找p节点和q节点的最近公共祖先
     * 思路: 如果p和q分别在root的左子树和右子树，则说明root为p与q的公共祖先
     * 问题1: 如何递归，为什么是递归的时候遇到p或者q的时候就返回呢
     * 问题2: 递归终止条件
     * @param root 当前节点
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null || root == q || root == p) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if (left == null) {
            // 如果左子树为空, 就是说LCA不在左子树,返回右子树继续递归查询
            // 题目规定肯定存在， 所以不会出现left和right同时为null的case出现
            return right;
        } else {
            if (right == null) {
                // 如果右子树为空, 则说明
                return left;
            } else {
                // 左右子树均不为空，这时候root即为最近公共祖先节点，返回
                return root;
            }

        }

    }
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val > root.val && q.val > root.val) {
            // p与q都比root大，则lca在右子树中
            return lowestCommonAncestor1(root.right,p,q);
        }
        if (p.val< root.val && q.val > root.val) {
            return lowestCommonAncestor1(root.left,p,q);
        }
        return root;

    }
}


