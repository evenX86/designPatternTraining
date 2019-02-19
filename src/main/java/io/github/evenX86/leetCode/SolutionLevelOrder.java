package io.github.evenX86.leetCode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Created with design-pattern-training
 *
 * @author xuyifei
 * @date 2019-02-19 9:12 PM
 */
public class SolutionLevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> resultList = new ArrayList<>();
        if (root == null) return resultList;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> rootList = new ArrayList<>();
            List<TreeNode> tmpList= new ArrayList<>();
            while (!queue.isEmpty()) {
                TreeNode tmpNode = queue.poll();
                rootList.add(tmpNode.val);
                if (tmpNode.left != null) {
                    tmpList.add(tmpNode.left);
                }
                if (tmpNode.right != null) {
                    tmpList.add(tmpNode.right);
                }
            }
            queue.addAll(tmpList);
            resultList.add(rootList);
        }
        return resultList;
    }

    public List<List<Integer>> levelOrder2(TreeNode root) {

        List<List<Integer>> resList = new ArrayList<>();
        dfs(resList,root,0);
        return resList;
    }


    public void dfs(List<List<Integer>> resList, TreeNode root, int height) {
        if (root == null) return;
        if (height >= resList.size()) {
            resList.add(new ArrayList<Integer>());
        }
        resList.get(height).add(root.val);
        dfs(resList, root.left, height +1);
        dfs(resList, root.right, height +1);
    }


    public static void main(String[] args) {
        SolutionLevelOrder solutionLevelOrder = new SolutionLevelOrder();
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(9);
        treeNode.right = new TreeNode(20);
        treeNode.right.left = new TreeNode(15);
        treeNode.right.right = new TreeNode(7);
        System.out.println(solutionLevelOrder.levelOrder2(treeNode));

    }
}
