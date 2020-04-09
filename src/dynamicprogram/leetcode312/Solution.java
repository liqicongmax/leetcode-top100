package dynamicprogram.leetcode312;

import java.util.Arrays;

/**
 * @author liqicong@myhexin.com
 * @date 2020/3/10 18:59
 */
public class Solution {
    /**
     * 有 n 个气球，编号为0 到 n-1，每个气球上都标有一个数字，这些数字存在数组 nums 中。
     * <p>
     * 现在要求你戳破所有的气球。每当你戳破一个气球 i 时，你可以获得 nums[left] * nums[i] * nums[right] 个硬币。 
     * 这里的 left 和 right 代表和 i 相邻的两个气球的序号。注意当你戳破了气球 i 后，气球 left 和气球 right 就变成了相邻的气球。
     * <p>
     * 求所能获得硬币的最大数量。
     * <p>
     * 说明:
     * <p>
     * 你可以假设 nums[-1] = nums[n] = 1，但注意它们不是真实存在的所以并不能被戳破。
     * 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
     * 示例:
     * <p>
     * 输入: [3,1,5,8]
     * 输出: 167
     * 解释: nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
     *      coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
     * 最多次数500！
     * 链接：https://leetcode-cn.com/problems/burst-balloons
     *
     * @param nums
     * @return
     */
    int[][] dp;

    public int maxCoins(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        dp = new int[len][len];
        for (int i = 0; i < len; i++) {
            for(int j=0;j<len-i;j++){
                getMaxCoins(nums,j,j+i);
            }
        }
        return dp[0][len - 1];
    }

    public void getMaxCoins(int[] nums, int start, int end) {
        int maxCoins = 0;
        int temp = 0;
        for (int i = start; i <= end; i++) {
//            temp = getMaxCoins(nums, start, i - 1) + getMaxCoins(nums, i + 1, end) + (start - 1 < 0 ? 1 : nums[start - 1]) * nums[i] * (end + 1 > nums.length - 1 ? 1 : nums[end + 1]);
            temp=(start>i-1 ? 0 : dp[start][i-1]) + (end < i+1 ? 0 : dp[i+1][end])+(start - 1 < 0 ? 1 : nums[start - 1]) * nums[i] * (end + 1 > nums.length - 1 ? 1 : nums[end + 1]);
            maxCoins = Math.max(maxCoins, temp);

        }
        dp[start][end]=maxCoins;

    }
    public static void main(String[] args){
        int[] arr=new int[]{3,1,5,8};
        System.out.println(new Solution().maxCoins(arr));
    }
}
