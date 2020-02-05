package dynamicprogram.leetcode64;

/**
 * @Author liqicong
 * @Date 2020/2/4 10:09
 * @Description
 */
public class Solution {
    /**
     * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
     *
     * 说明：每次只能向下或者向右移动一步。
     *
     * 示例:
     *
     * 输入:
     * [
     *   [1,3,1],
     *   [1,5,1],
     *   [4,2,1]
     * ]
     * 输出: 7
     * 解释: 因为路径 1→3→1→1→1 的总和最小。
     *
     * 链接：https://leetcode-cn.com/problems/minimum-path-sum
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        if(grid.length==0){
            return 0;
        }
        int rows=grid.length;
        int cols=grid[0].length;
        int[][] dp=new int[rows][cols];

        dp[0][0]=grid[0][0];
        for(int i=1;i<cols;i++){
            dp[0][i]=grid[0][i]+dp[0][i-1];
        }
        for(int i=1;i<rows;i++){
            dp[i][0]=grid[i][0]+dp[i-1][0];
        }
        for(int i=1;i<rows;i++){
            for(int j=1;j<cols;j++){
                dp[i][j]=grid[i][j]+Math.min(dp[i-1][j],dp[i][j-1]);
            }
        }

        return dp[rows-1][cols-1];
    }
}
