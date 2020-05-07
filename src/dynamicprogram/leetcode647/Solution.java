package dynamicprogram.leetcode647;

/**
 * @author liqicong@myhexin.com
 * @date 2020/5/7 18:59
 */
public class Solution {
    /**
     * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
     * <p>
     * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被计为是不同的子串。
     * <p>
     * 示例 1:
     * <p>
     * 输入: "abc"
     * 输出: 3
     * 解释: 三个回文子串: "a", "b", "c".
     * 示例 2:
     * <p>
     * 输入: "aaa"
     * 输出: 6
     * 说明: 6个回文子串: "a", "a", "a", "aa", "aa", "aaa".
     * 注意:
     * <p>
     * 输入: "aaca"
     * 输出： 6
     * 说明: "a","a","c","a","aa","aca"
     * 输入的字符串长度不会超过1000。
     * <p>
     * 链接：https://leetcode-cn.com/problems/palindromic-substrings
     *
     * @param s
     * @return
     */
    public int countSubstrings(String s) {
        //暴力解法
        //for i从2到s.length-1,每次截取i长度的字符串去判断是否回文，复杂度n^2
        //acac
        //dp[i][j],i到j是否为回文子串
        if (s.length() == 1) {
            return 1;
        }
        int[] dp = new int[s.length() + 1];//代表截取到第i个字符有dp[i]个回文子串
        dp[0] = 0;
        dp[1] = 1;
        //aaa
        for (int i = 2; i <= s.length(); i++) {
            String str = s.substring(0, i);
            //aa
            for (int j = 1; j <= i; j++) {
                String tmp = str.substring(str.length() - j);
                //检验是否为回文，回文就+1
                if (check(tmp)) {
                    dp[i] += 1;
                }
            }
            dp[i] += dp[i - 1];
        }
        return dp[s.length()];
    }

    public int solution(String s) {
        if (s.length() == 1) {
            return 1;
        }
        int total = 0;
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {//判断从0到j是否满足
                if (s.charAt(i) == s.charAt(j) && ((i - j) < 2 || dp[j + 1][i - 1])) {
                    dp[j][i] = true;
                    total++;
                }
            }
        }
        return total;
    }

    //让中心向右移，然后while遍历中心左右到最大范围。
    public int solution1(String s){

    }

    public boolean check(String word) {
        if (word.length() == 1) {
            return true;
        }
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) != word.charAt(word.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().check("aa"));
        System.out.println(new Solution().solution("aaca"));
    }
}
