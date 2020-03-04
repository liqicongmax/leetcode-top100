package toutiao;

/**
 * @author liqicong@myhexin.com
 * @date 2020/3/4 13:13
 */
public class Leetcode329 {
    /**
     * 给定一个整数矩阵，找出最长递增路径的长度。
     * <p>
     * 对于每个单元格，你可以往上，下，左，右四个方向移动。 你不能在对角线方向上移动或移动到边界外（即不允许环绕）。
     * <p>
     * 示例 1:
     * <p>
     * 输入: nums =
     * [
     * [9,9,4],
     * [6,6,8],
     * [2,1,1]
     * ]
     * 输出: 4
     * 解释: 最长递增路径为 [1, 2, 6, 9]。
     * 示例 2:
     * <p>
     * 输入: nums =
     * [
     * [3,4,5],
     * [3,2,6],
     * [2,2,1]
     * ]
     * 输出: 4
     * 解释: 最长递增路径是 [3, 4, 5, 6]。注意不允许在对角线方向上移动。
     * <p>
     * 链接：https://leetcode-cn.com/problems/longest-increasing-path-in-a-matrix
     *
     * @param matrix
     * @return
     */
    int max = 0;
    int rows;
    int cols;

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;
        rows = matrix.length;
        cols = matrix[0].length;
        int[][] dp = new int[rows][cols];
        //如果从当前点开始，找到了最长的路径，那可以直接去修改当前这个点为已访问，如果遍历到已访问的点就跳过
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                max = Math.max(max, loop(matrix,Integer.MIN_VALUE,dp,i,j));
            }
        }
        return max;
    }

    private int loop(int[][] mat, int pre, int[][] dp, int i, int j) {
        if (i < 0 || j < 0 || i >= mat.length || j >= mat[0].length || mat[i][j] <= pre) {  //停止搜索条件
            return 0;
        }
        if (dp[i][j] != 0) {  //如果有数据，直接返回
            return dp[i][j];
        }
        int max = 0;  //进行搜索
        max = Math.max(max, loop(mat, mat[i][j], dp, i - 1, j));
        max = Math.max(max, loop(mat, mat[i][j], dp, i + 1, j));
        max = Math.max(max, loop(mat, mat[i][j], dp, i, j - 1));
        max = Math.max(max, loop(mat, mat[i][j], dp, i, j + 1));
        dp[i][j] = max + 1;
        return dp[i][j];
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{9,9,4}, {6,6,8}, {2, 1, 1}};
        System.out.println(new Leetcode329().longestIncreasingPath(arr));
    }

}
