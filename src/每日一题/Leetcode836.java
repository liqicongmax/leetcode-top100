package 每日一题;

/**
 * @author liqicong@myhexin.com
 * @date 2020/3/18 13:13
 */
public class Leetcode836 {
    /**
     * 矩形以列表 [x1, y1, x2, y2] 的形式表示，其中 (x1, y1) 为左下角的坐标，(x2, y2) 是右上角的坐标。
     *
     * 如果相交的面积为正，则称两矩形重叠。需要明确的是，只在角或边接触的两个矩形不构成重叠。
     *
     * 给出两个矩形，判断它们是否重叠并返回结果。

     * 示例 1：
     *
     * 输入：rec1 = [0,0,2,2], rec2 = [1,1,3,3]
     * 输出：true
     * 示例 2：
     *
     * 输入：rec1 = [0,0,1,1], rec2 = [1,0,2,1]
     * 输出：false
     *
     * 提示：
     *
     * 两个矩形 rec1 和 rec2 都以含有四个整数的列表的形式给出。
     * 矩形中的所有坐标都处于 -10^9 和 10^9 之间。
     * x 轴默认指向右，y 轴默认指向上。
     * 你可以仅考虑矩形是正放的情况。
     * @param rec1
     * @param rec2
     * @return
     * [4, 0, 6, 6]
     * [-5,-3,4,2]
     */
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        //求矩阵重叠面积
        //遍历矩阵A的长，截取矩阵B中符合条件的长，如果没有直接return false
        //遍历矩阵A的宽，
        int alongStart=rec1[0];
        int alongEnd=rec1[2];
        int awidthStart=rec1[1];
        int awidthEnd=rec1[3];
        int blongStart=rec2[0];
        int blongEnd=rec2[2];
        int bwidthStart=rec2[1];
        int bwidthEnd=rec2[3];
        boolean flag=false;
        //判断矩阵A的长上面有没有矩阵B的可能重叠长度
        for(int i=alongStart+1;i<alongEnd;i++){
            if(i>=blongStart&&i<=blongEnd){
                flag=true;
                break;
            }
        }
        if(!flag){
            return false;
        }
        //
        for(int i=awidthStart+1;i<awidthEnd;i++){
            if(i>=bwidthStart&&i<=bwidthEnd){
                return true;
            }
        }
        return false;
    }
}
