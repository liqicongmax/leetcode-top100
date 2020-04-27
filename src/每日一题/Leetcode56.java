package 每日一题;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author liqicong@myhexin.com
 * @date 2020/4/16 14:57
 */
public class Leetcode56 {
    /**
     * 给出一个区间的集合，请合并所有重叠的区间。
     *
     * 示例 1:
     *
     * 输入: [[1,3],[2,6],[8,10],[15,18]]
     * 输出: [[1,6],[8,10],[15,18]]
     * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
     * 示例 2:
     *
     * 输入: [[1,4],[4,5]]
     * 输出: [[1,5]]
     * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
     *
     * 链接：https://leetcode-cn.com/problems/merge-intervals
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        //按照每个区间的start进行排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        int[][] res=new int[intervals.length][intervals[0].length];
        int index=0;
        
        for(int i=0;i<intervals.length;i++){
            if(res[index][0]==0&&res[index][1]==0){
                res[index]=intervals[i];
                continue;
            }
//            res[index]=intervals[index];
            int[] tmp=intervals[i];
            int preRight=res[index][1];
            int preLeft=res[index][0];
            int nowLeft=tmp[0];
            int nowRight=tmp[1];
            if((preRight>=nowLeft&&preRight<=nowRight)||(nowLeft>=preLeft&&nowLeft<=preRight)){
                //说明有交集或者重合
                res[index][0]=preLeft;
                res[index][1]=Math.max(preRight,nowRight);
            }else{
                index++;
            }

        }
        return res;
    }
    public static void main(String[] args){
        int[][] arr=new int[][]{{1,3},{2,6},{8,10},{15,18}};
        int[][] res=new Leetcode56().merge(arr);
        for(int[] tmp:res){
            System.out.println(Arrays.toString(tmp));
        }
    }
}
