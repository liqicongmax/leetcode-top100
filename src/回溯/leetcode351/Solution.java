package 回溯.leetcode351;

/**
 * @author liqicong@myhexin.com
 * @date 2020/3/9 13:08
 */
public class Solution {
    /**
     * 我们都知道安卓有个手势解锁的界面，是一个 3 x 3 的点所绘制出来的网格。
     *
     * 给你两个整数，分别为 m 和 n，其中 1 ≤ m ≤ n ≤ 9，那么请你统计一下有多少种解锁手势，是至少需要经过 m 个点，但是最多经过不超过 n 个点的。
     *
     * 先来了解下什么是一个有效的安卓解锁手势:
     *
     * 每一个解锁手势必须至少经过 m 个点、最多经过 n 个点。
     * 解锁手势里不能设置经过重复的点。
     * 假如手势中有两个点是顺序经过的，那么这两个点的手势轨迹之间是绝对不能跨过任何未被经过的点。
     * 经过点的顺序不同则表示为不同的解锁手势。
     *
     * 解释:
     *
     * | 1 | 2 | 3 |
     * | 4 | 5 | 6 |
     * | 7 | 8 | 9 |
     * 无效手势：4 - 1 - 3 - 6 连接点 1 和点 3 时经过了未被连接过的 2 号点。
     *
     * 无效手势：4 - 1 - 9 - 2 连接点 1 和点 9 时经过了未被连接过的 5 号点。
     *
     * 有效手势：2 - 4 - 1 - 3 - 6 连接点 1 和点 3 是有效的，因为虽然它经过了点 2 ，但是点 2 在该手势中之前已经被连过了。
     *
     * 有效手势：6 - 5 - 4 - 1 - 9 - 2 连接点 1 和点 9 是有效的，因为虽然它经过了按键 5 ，但是点 5 在该手势中之前已经被连过了。
     * @param m
     * @param n
     * @return
     */
    int valid=0;
    int m;
    int n;
    private int[][] matrix=new int[3][3];
    {
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                matrix[i][j]=3*i+j+1;
            }
        }
    }
    public int numberOfPatterns(int m,int n){
        this.m=m;
        this.n=n;
        int[][] dp=new int[9][9];//保存a到b有几种走法
        boolean[][] visited=new boolean[9][9];
        for(int i=1;i<=9;i++){
            for(int j=1;j<=9;j++){
                helper(i,1,j/3,(j-1)%3,dp,visited);
            }
        }
        return valid;
    }

    /**
     * 从i,j表示当前从matrix[i][j]开始走，走到target就可以停了
     *
     */
    public void helper(int target,int step,int i,int j,int[][] dp,boolean[][] visited){
        if(i<0||j<0||i>=3||j>=3||visited[i][j]||step>n){
            return;
        }
        if(matrix[i][j]==target){
            if(step>=m&&step<=n) {
                valid++;
            }
            return;
        }
        //处理当前点位
        visited[i][j]=true;

        //有八个方向
        helper(target,step+1,i+1,j+1,dp,visited);
        visited[i][j]=false;

        helper(target,step+1,i-1,j-1,dp,visited);
        visited[i][j]=false;

        helper(target,step+1,i-1,j+1,dp,visited);
        visited[i][j]=false;

        helper(target,step+1,i+1,j-1,dp,visited);
        visited[i][j]=false;

        helper(target,step+1,i,j+1,dp,visited);
        visited[i][j]=false;

        helper(target,step+1,i+1,j-1,dp,visited);
        visited[i][j]=false;

        helper(target,step+1,i+1,j,dp,visited);
        visited[i][j]=false;

        helper(target,step+1,i-1,j,dp,visited);
        visited[i][j]=false;


    }

    public static void main(String[] args){
        System.out.println(new Solution().numberOfPatterns(3,5));
    }
}
