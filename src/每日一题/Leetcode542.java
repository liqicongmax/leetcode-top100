//package 每日一题;
//
///**
// * @author liqicong@myhexin.com
// * @date 2020/4/15 10:30
// */
//public class Leetcode542 {
//    /**
//     * 给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。
//     *
//     * 两个相邻元素间的距离为 1 。
//     *
//     * 示例 1:
//     * 输入:
//     *
//     * 0 0 0
//     * 0 1 0
//     * 0 0 0
//     * 输出:
//     *
//     * 0 0 0
//     * 0 1 0
//     * 0 0 0
//     * 示例 2:
//     * 输入:
//     *
//     * 0 0 0
//     * 0 1 0
//     * 1 1 1
//     * 输出:
//     *
//     * 0 0 0
//     * 0 1 0
//     * 1 2 1
//     * 注意:
//     *
//     * 给定矩阵的元素个数不超过 10000。
//     * 给定矩阵中至少有一个元素是 0。
//     * 矩阵中的元素只在四个方向上相邻: 上、下、左、右。
//     *
//     * 链接：https://leetcode-cn.com/problems/01-matrix
//     * @param matrix
//     * @return
//     */
//    public int[][] updateMatrix(int[][] matrix) {
//        if(matrix.length==0||matrix[0].length==0){
//            return matrix;
//        }
//        int rows=matrix.length;
//        int cols=matrix[0].length;
//        int[][] dp=new int[rows][cols];
//        for(int x=0;x<rows;x++){
//            for(int y=0;y<cols;y++){
//                if(matrix[x][y]==0){
//                    dp[x][y]=0;
//                }else{
//                    dp[x][y]=
//                }
//            }
//        }
//    }
//
//    //回溯上下左右找最小的到0的距离
//    public int helper(int[][] matrix,int[][] dp,int x,int y,int up,int down,int left,int right){
//        int up
//    }
//}
