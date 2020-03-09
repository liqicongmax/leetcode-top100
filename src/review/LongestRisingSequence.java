package review;

/**
 * @author liqicong@myhexin.com
 * @date 2020/3/5 10:33
 */
public class LongestRisingSequence {
    /**
     * 矩阵中求最长子序列的长度
     * @param matrix
     * @return
     */
    static int rows;
    int cols;
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix.length==0||matrix[0].length==0){
            return 0;
        }
        rows=matrix.length;
        cols=matrix[0].length;
        int[][] dp=new int[rows][cols];
        int max=0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                max=Math.max(max,helper(dp,matrix,Integer.MIN_VALUE,i,j));
            }
        }

        return max;
    }
    public int helper(int[][] dp,int[][] matrix,int pre,int i,int j){
        if(i<0||j<0||i>=rows||j>=cols||matrix[i][j]<pre)return 0;
        if(dp[i][j]>0){
            return dp[i][j];
        }
        int max=0;
        max=Math.max(max,helper(dp,matrix,matrix[i][j],i+1,j));
        max=Math.max(max,helper(dp,matrix,matrix[i][j],i-1,j));
        max=Math.max(max,helper(dp,matrix,matrix[i][j],i,j+1));
        max=Math.max(max,helper(dp,matrix,matrix[i][j],i,j-1));

        dp[i][j]=max+1;

        return dp[i][j];
    }

}
