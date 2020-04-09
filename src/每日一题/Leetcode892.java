package 每日一题;

/**
 * @author liqicong@myhexin.com
 * @date 2020/3/25 10:37
 */
public class Leetcode892 {
    /**
     * 在 N * N 的网格上，我们放置一些 1 * 1 * 1  的立方体。
     *
     * 每个值 v = grid[i][j] 表示 v 个正方体叠放在对应单元格 (i, j) 上。
     *
     * 请你返回最终形体的表面积。
     *
     * 示例 1：
     *
     * 输入：[[2]]
     * 输出：10
     * 示例 2：
     *
     * 输入：[[1,2],[3,4]]
     * 输出：34
     * 示例 3：
     *
     * 输入：[[1,0],[0,2]]
     * 输出：16
     * 示例 4：
     *
     * 输入：[[1,1,1],[1,0,1],[1,1,1]]
     * 输出：32
     * 示例 5：
     *
     * 输入：[[2,2,2],[2,1,2],[2,2,2]]
     * 输出：46
     *  
     *
     * 提示：
     *
     * 1 <= N <= 50
     * 0 <= grid[i][j] <= 50
     *
     * 链接：https://leetcode-cn.com/problems/surface-area-of-3d-shapes
     * @param grid
     * @return
     * 遍历那个二维网格，最多会有50X50X4
     */
    public int surfaceArea(int[][] grid) {
        int total=0;
        int n=grid.length;
        int[][] temp=new int[n][n];
        //上左不处理，只处理右边和下边
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0)continue;
                int cur=grid[i][j]==0?0:(grid[i][j]*4+2);//当前点位上的表面积
                //开始计算前后左右四个方向的表面积是否有重叠
                //右
                if(i+1<n&&grid[i+1][j]!=0){
                    int min=Math.min(grid[i+1][j],grid[i][j]);
                    cur-=min;//减去右边的重叠数
                    temp[i+1][j]+=(-1*min);//添加到右边那个方块堆的左边重叠数
                }
                //后
                if(j+1<n&&grid[i][j+1]!=0){
                    int min=Math.min(grid[i][j+1],grid[i][j]);
                    cur-=min;
                    temp[i][j+1]+=(-1*min);
                }
                //cur只记录了右边和下边的重叠数，上边和左边的重叠数保存在temp中
                total+=cur;
                total+=temp[i][j];
            }
        }
        return total;
    }
}
