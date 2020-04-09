package 每日一题;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author liqicong@myhexin.com
 * @date 2020/4/9 14:51
 */
public class Leetcode22 {
    /**
     * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
     *
     *  
     *
     * 示例：
     *
     * 输入：n = 3
     * 输出：[
     *        "((()))",
     *        "(()())",
     *        "(())()",
     *        "()(())",
     *        "()()()"
     *      ]
     *
     * 链接：https://leetcode-cn.com/problems/generate-parentheses
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        List<String> res=new ArrayList<>();
        if(n==0){
            return res;
        }
        helper(res, n, "", 0, 0);
        return res;
    }

    public void helper(List<String> res,int n,String ha,int left,int right){
        if(ha.length()==n*2){
            res.add(ha);
            return;
        }
        if(left<right)return;
        if(left<n){
            helper(res,n,ha+"(",left+1,right);
        }
        if(right<n){
            helper(res,n,ha+")",left,right+1);
        }
    }
}
