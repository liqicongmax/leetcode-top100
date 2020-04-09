package 每日一题;

/**
 * @author liqicong@myhexin.com
 * @date 2020/3/14 9:47
 */
public class Leetcode300 {
    /**
     * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
     *
     * 示例:
     *
     * 输入: [10,9,2,5,3,7,101,18]
     * 输出: 4
     * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
     * 说明:
     *
     * 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
     * 你算法的时间复杂度应该为 O(n2) 。
     * 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
     *
     * 链接：https://leetcode-cn.com/problems/longest-increasing-subsequence
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        if(nums.length<2){
            return nums.length;
        }
        int[] dp=new int[nums.length];
        //保存以nums[n]为最后一个数的最长上升子序列的长度
        //dp[0]=1,dp[1]：因为nums[1]小于前一个数nums[0]，所以dp[1]等于dp[0]
        //dp[2]=1,dp[3]=2,dp[4]=2,dp[5]=3,dp[6]=4,dp[7]=4
        return 1;
    }


}
