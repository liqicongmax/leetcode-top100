package dynamicprogram.leetcode72;

/**
 * @Author liqicong
 * @Date 2020/2/5 9:33
 * @Description
 */
public class Solution {
    /**
     * 给定两个单词 word1 和 word2，计算出将 word1 转换成 word2 所使用的最少操作数 。
     *
     * 你可以对一个单词进行如下三种操作：
     *
     * 插入一个字符
     * 删除一个字符
     * 替换一个字符
     * 示例 1:
     *
     * 输入: word1 = "horse", word2 = "ros"
     * 输出: 3
     * 解释:
     * horse -> rorse (将 'h' 替换为 'r')
     * rorse -> rose (删除 'r')
     * rose -> ros (删除 'e')
     * 链接：https://leetcode-cn.com/problems/edit-distance
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        if("".equals(word1)&&"".equals(word2)){
            return 0;
        }
        if("".equals(word1)){
            return word2.length();
        }
        if("".equals(word2)){
            return word1.length();
        }
        int m=word1.length();
        int n=word2.length();
        int[][] dp=new int[m+1][n+1];
        //dp是从word1的x到word2的y需要动几手
        for(int i=1;i<=m;i++){
            dp[i][0]=dp[i-1][0]+1;
        }
        for(int i=1;i<=n;i++){
            dp[0][i]=dp[0][i-1]+1;
        }
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                //遍历字符，如果字符相同，不需要任何改动，这个dp值等于上个dp值
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }else{
                    //如果不相同，就三种改法
                    //1.增dp[i-1][j]+1
                    //2.删dp[i][j-1]+1
                    //3.改=dp[i-1][j-1]+1
                    dp[i][j]=Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]))+1;
                }
            }
        }
        return dp[m][n];

    }
}
