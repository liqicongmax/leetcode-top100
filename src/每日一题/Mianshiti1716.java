package 每日一题;

/**
 * @author liqicong@myhexin.com
 * @date 2020/3/24 16:52
 */
public class Mianshiti1716 {
    /**
     * 一个有名的按摩师会收到源源不断的预约请求，每个预约都可以选择接或不接。在每次预约服务之间要有休息时间，因此她不能接受相邻的预约。给定一个预约请求序列，替按摩师找到最优的预约集合（总预约时间最长），返回总的分钟数。
     *
     * 注意：本题相对原题稍作改动
     *
     *  
     *
     * 示例 1：
     *
     * 输入： [1,2,3,1]
     * 输出： 4
     * 解释： 选择 1 号预约和 3 号预约，总时长 = 1 + 3 = 4。
     * 示例 2：
     *
     * 输入： [2,7,9,3,1]
     * 输出： 12
     * 解释： 选择 1 号预约、 3 号预约和 5 号预约，总时长 = 2 + 9 + 1 = 12。
     * 示例 3：
     *
     * 输入： [2,1,4,5,3,1,1,3]
     * 输出： 12
     * 解释： 选择 1 号预约、 3 号预约、 5 号预约和 8 号预约，总时长 = 2 + 4 + 3 + 3 = 12。
     *
     * 链接：https://leetcode-cn.com/problems/the-masseuse-lcci
     * @param nums
     * @return
     */
    public int massage(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        int len=nums.length;
        int[][]dp =new int[len+1][2];
        dp[0][0]=0;
        dp[0][1]=0;
        dp[1][0]=0;//第一天不接客
        dp[1][1]=nums[0];//第一天接客
        for(int i=1;i<len;i++){
            dp[i+1][0]=Math.max(dp[i][0],dp[i][1]);
            //今天接客能有的最大时长
            dp[i+1][1]=nums[i]+dp[i][0];
        }
        return Math.max(dp[len][0],dp[len][1]);
    }

    public static void main(String[] args){
        int[] arr=new int[]{2,1,4,5,3,1,1,3};
        System.out.println(new Mianshiti1716().massage(arr));
    }
}
