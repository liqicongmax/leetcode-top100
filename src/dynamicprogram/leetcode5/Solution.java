package dynamicprogram.leetcode5;

/**
 * @Author liqicong
 * @Date 2020/2/3 10:35
 * @Description
 */
public class Solution {

    /**
     * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
     *
     * 示例 1：
     *
     * 输入: "babad"
     * 输出: "bab"
     * 注意: "aba" 也是一个有效答案。
     * 示例 2：
     *
     * 输入: "cbbd"
     * 输出: "bb"
     *
     * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
     * @param s
     * @return
     *
     *    b  a  d  c  a  b
     * b  0
     * a     1
     * c
     * d
     * a
     * b
     */
    public static String longestPalindrome(String s) {
        if(s.length()==0){
            return "";
        }
        int len=s.length();
        String str="";
        String reverse=new StringBuilder(s).reverse().toString();
        int max=0;
        int[][] dp=new int[len][len];
        for(int i=0;i<len;i++){
            for(int j=0;j<len;j++){
                if(reverse.charAt(i)==s.charAt(j)){
                    if(i>0&&j>0){
                        dp[i][j]=dp[i-1][j-1]+1;
                    }else{
                        dp[i][j]=1;
                    }
                    if(dp[i][j]>max) {
                        int pre=len-i-1;
                        if(pre+dp[i][j]-1==j) {
                            max = dp[i][j];
                            str = s.substring(j - max + 1, j + 1);
                        }
                    }
                }
            }
        }
        return str;
    }

    public static void main(String[] args){
        System.out.println(longestPalindrome("badddcab"));
    }
}
