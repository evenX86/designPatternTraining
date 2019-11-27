package io.github.evenX86.algo;

import io.github.evenX86.solution.TreeNode;


/**
 * Created with design-pattern-training
 * [0,1,2,3,4,3,4]
 * [2,2,1,null,1,0,null,0]
 * [25,1,3,1,3,0,2]
 *
 * @author xuyifei
 * @date 2019-11-11 8:00 PM
 */
public class Graph {
    private String maxSb = "~";


    public void hepler(TreeNode root, StringBuilder sb) {
        char ch = (char) (root.val + 97);
        sb.append(ch);
        if (root.left == null && root.right == null) {
            // 当前是叶子节点了，判断左右子树的string，对比字典序
            String s = sb.reverse().toString();
            sb.reverse();
            if (s.compareTo(maxSb) < 0) {
                maxSb = s;
            }
            return;
        }
        if (root.left != null) {
            // 遍历左子树找到最短子串
            hepler(root.left, sb);
            sb.deleteCharAt(sb.length() - 1);

        }
        if (root.right != null) {
            // 查找右子树的最短子串
            hepler(root.right, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
