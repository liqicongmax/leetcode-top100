package 回溯.leetcode22;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liqicong@myhexin.com
 * @date 2020/3/3 9:21
 */
public class Solution {
    /**
     * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
     *
     * 例如，给出 n = 3，生成结果为：
     *
     * [
     *   "((()))",
     *   "(()())",
     *   "(())()",
     *   "()(())",
     *   "()()()"
     * ]
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
        helper(res,n,"",0,0);
        return res;
    }

    public void helper(List<String> res,int n,String word,int left,int right){
       if(word.length()==(n*2)){
           res.add(word);
           return;
       }

       if(right>left){
           return;
       }
       if(left<n){
           helper(res,n,word+"(",left+1,right);
       }
       if(right<n){
           helper(res,n,word+")",left,right+1);
       }
    }
}
