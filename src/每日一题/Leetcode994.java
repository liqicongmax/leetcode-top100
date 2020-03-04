package 每日一题;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author liqicong@myhexin.com
 * @date 2020/3/4 9:16
 */
public class Leetcode994 {
    /**
     * 在给定的网格中，每个单元格可以有以下三个值之一：
     * <p>
     * 值 0 代表空单元格；
     * 值 1 代表新鲜橘子；
     * 值 2 代表腐烂的橘子。
     * 每分钟，任何与腐烂的橘子（在 4 个正方向上）相邻的新鲜橘子都会腐烂。
     * <p>
     * 返回直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1。
     * <p>
     *  
     * <p>
     * 示例 1：
     * 2  1  1
     * 1  1  0
     * 0  1  1
     * <p>
     * 输入：[[2,1,1],[1,1,0],[0,1,1]]
     * 输出：4
     * 示例 2：
     * <p>
     * 输入：[[2,1,1],[0,1,1],[1,0,1]]
     * 输出：-1
     * 解释：左下角的橘子（第 2 行， 第 0 列）永远不会腐烂，因为腐烂只会发生在 4 个正向上。
     * <p>
     * 链接：https://leetcode-cn.com/problems/rotting-oranges
     *
     * @param grid
     * @return
     */
    public int orangesRotting(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return -1;
        }
        int time = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited=new boolean[rows][cols];
        //存储上下左右位移方向
        int[][] next = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Queue<Node> queue = new LinkedList<>();
        Node node = null;
        //先把所有发霉的点放到队列里
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    node = new Node(i, j);
                    queue.offer(node);
                    visited[i][j]=true;
                }

            }
        }
        int size=queue.size();//这轮size个消耗完，才能考虑次数是否+1
        int temp=0;
        boolean flag=false;
        while (!queue.isEmpty()) {
            Node node1 = queue.poll();
            //这轮queue消耗完才算次数+1
            //遍历上下左右过程中，如果有个从1变到2了，次数就可以+1
            for (int i = 0; i < 4; i++) {
                int newr = node1.x + next[i][0];
                int newc = node1.y + next[i][1];
                if (newr < 0 || newc < 0 || newr >= rows || newc >= cols) continue;
                if(visited[newr][newc])continue;
                visited[newr][newc]=true;
                if (grid[newr][newc] == 1) {
                    grid[newr][newc] = 2;
                    flag=true;
                    queue.offer(new Node(newr, newc));
                }
            }
            temp++;
            if(temp==size){
                temp=0;
                size=queue.size();
                if(flag) {
                    time++;
                    flag=false;
                }
            }

        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    //没发霉的说明不可能
                    return -1;
                }
            }
        }
        return time;
    }
}

class Node {
    int x;
    int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}