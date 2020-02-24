package dynamicprogram.leetcode221;

/**
 * @author liqicong@myhexin.com
 * @date 2020/2/21 14:48
 */
public class Solution {
    /**
     * 在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
     * <p>
     * 示例:
     * <p>
     * 输入:
     * <p>
     * 1 0 1 0 0
     * 1 1 1 1 1
     * 1 1 1 1 1
     * 1 0 0 1 0
     * <p>
     * 输出: 4
     * <p>
     * 链接：https://leetcode-cn.com/problems/maximal-square
     *
     * @param matrix
     * @return
     */
    public int maximalSquare(char[][] matrix) {
        //从这个点开始，要想是1x1的矩形，这个点必须是1吧，要想是2x2的矩形，起始点也必须是1，要想是3x3的矩形，起始必须是2x2的矩形吧
        //递推公式怎么来
        //先确定0,0位置的点，如果是0，dp[0][0]=0，1则继续判断是否为
        if (matrix.length == 0) {
            return 0;
        }
        int len = matrix.length;
        int wid = matrix[0].length;
        int[][] dp = new int[len+1][wid+1];
        int max = 0;
        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= wid; j++) {
                if(matrix[i-1][j-1]=='1'){
                    //到我这个点能形成的最大正方形边长由左上角，上，左三个点的能形成的最小边长决定
                    dp[i][j]=1+Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]));
                    max=Math.max(max,dp[i][j]);
                }
            }
        }
        return max * max;
    }

    public static void main(String[] args) {
        char[][] chars = new char[][]{
                {'0', '0', '0', '1'},
                {'1', '1', '0', '1'},
                {'1', '1', '1', '1'},
                {'0', '1', '1', '1'},
                {'0', '1', '1', '1'}
        };
        System.out.println(new Solution().maximalSquare(chars));
    }
}
