package io.github.evenX86.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with design-pattern-training
 *
 * @author xuyifei
 * @date 2019-01-20 9:33 PM
 */
public class SolutionIsValidBST {

    public   boolean isValidBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        getInOrderList(root, list);
        if (list.size() <= 1) {
            return true;
        }
        int preVal = list.get(0);
        for (int i=1;i<list.size();i++) {
            if (preVal<list.get(i)) {
                preVal = list.get(i);
            } else {
                return false;
            }

        }
        return true;
    }
    public void getInOrderList(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        getInOrderList(node.left,list);
        list.add(node.val);
        getInOrderList(node.right, list);
    }

    public boolean isValid(TreeNode node, Integer min, Integer max) {
        if (node == null) {
            return true;
        }
        if (min != null && node.val <= min) {
            return false;
        }
        if (max != null && node.val >= max) {
            return false;
        }
        return isValid(node.left, min,node.val) && isValid(node.right, node.val, max);

    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(5);
        TreeNode t2 = new TreeNode(4);
        TreeNode t3 = new TreeNode(3);
        TreeNode t6 = new TreeNode(6);
        treeNode.left = new TreeNode(1);
        treeNode.right = t2;
        t2.left = t3;
        t2.right = t6;
        SolutionIsValidBST solutionIsValidBST = new SolutionIsValidBST();
        System.out.println(solutionIsValidBST.isValidBST(treeNode));
    }

}
