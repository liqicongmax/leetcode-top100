package dynamicprogram.leetcode198;

/**
 * @author liqicong@myhexin.com
 * @date 2020/2/20 10:12
 */
public class Solution {
    /**
     * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
     * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
     *
     * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
     *
     * 示例 1:
     *
     * 输入: [1,2,3,1]
     * 输出: 4
     * 解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
     *      偷窃到的最高金额 = 1 + 3 = 4 。
     * 示例 2:
     *
     * 输入: [2,7,9,3,1]
     * 输出: 12
     * 解释: 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
     *      偷窃到的最高金额 = 2 + 9 + 1 = 12 。
     *
     * 链接：https://leetcode-cn.com/problems/house-robber
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        if(nums.length==1){
            return nums[0];
        }
        int[] dp=new int[nums.length];//偷到第n个房间可偷的最大值
        dp[0]=nums[0];
        dp[1]=nums[1];
        int max=dp[0];
        //偷到第三间的偷法，前面的最大值加上第三间可偷值
        //偷到第四间，1,2的最大值加上第四间
        //不一定偷到最后一间是最大的
        for(int i=2;i<nums.length;i++){
            dp[i]=nums[i]+max;//0~i-2之间可偷的最大值
            max=Math.max(max,dp[i-1]);//更新max，比较max和dp[i-1]，
        }
        return Math.max(max,dp[nums.length-1]);
    }
    public static void main(String[] args){
        int[] arr=new int[]{1,2,3,1};
        System.out.println(new Solution().rob(arr));
    }
}
