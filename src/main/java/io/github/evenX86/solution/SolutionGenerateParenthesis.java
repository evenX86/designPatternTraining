package io.github.evenX86.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with design-pattern-training
 *
 * 给定括号匹配对数n要求能够生成的有效括号序列
 * 使用DFS求解，遍历出所有的括号序列
 * 本质上是一颗树，每个节点上都是一个二元元素（包含左右两种元素）
 * DFS这棵树需要根据题目给的有效序列做限定
 * @author xuyifei
 * @date 2019-02-26 9:32 PM
 */
public class SolutionGenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> resList = new ArrayList<>();
        genParenthesis(resList,"", n, n);
        return resList;
    }

    private void genParenthesis(List<String> resList,String subList, int left, int right) {
        if (right == 0 && left ==0) {
            resList.add(subList);
            return ;
        }
        if (left>0) {
            // 左括号大于0，随时都可以加入
            genParenthesis(resList, subList+"(",left-1,right);
        }
        if (right>left) {
            // 右括号比左括号多的情况下才允许，添加进序列中,否则属于非法操作
            genParenthesis(resList, subList+")", left, right -1);
        }

    }

}
