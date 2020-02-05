package dynamicprogram.leetcode62;

/**
 * @Author liqicong
 * @Date 2020/2/4 9:54
 * @Description
 */
public class Solution {
    /**
     * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
     *
     * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
     *
     * 问总共有多少条不同的路径？
     *
     * 示例 1:
     *
     * 输入: m = 3, n = 2
     * 输出: 3
     * 解释:
     * 从左上角开始，总共有 3 条路径可以到达右下角。
     * 1. 向右 -> 向右 -> 向下
     * 2. 向右 -> 向下 -> 向右
     * 3. 向下 -> 向右 -> 向右
     * 示例 2:
     *
     * 输入: m = 7, n = 3
     * 输出: 28
     *
     * 链接：https://leetcode-cn.com/problems/unique-paths
     * @param m m列
     * @param n n行
     * @return
     */
    public static int uniquePaths(int m, int n) {
        if(m==0||n==0){
            return 0;
        }
        int[][] dp=new int[n][m];
        for(int i=0;i<m;i++){
            dp[0][i]=1;
        }
        for(int i=0;i<n;i++){
            dp[i][0]=1;
        }
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[n-1][m-1];
    }
    public static void main(String[] args){
        System.out.println(uniquePaths(7,3));
    }
}
