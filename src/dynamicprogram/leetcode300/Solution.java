package dynamicprogram.leetcode300;

import java.util.Arrays;

/**
 * @author liqicong@myhexin.com
 * @date 2020/2/29 13:16
 */
public class Solution {
    /**
     * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
     * <p>
     * 示例:
     * <p>
     * 输入: [10,9,2,5,3,7,101,18]
     * 输出: 4
     * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
     * 说明:
     * <p>
     * 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
     * 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
     * 每轮遍历的时候用dp去存数据
     * f(n)=index>n?f(n-1):f(n-1)+1
     * 链接：https://leetcode-cn.com/problems/longest-increasing-subsequence
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        if (nums.length<2) {
            return nums.length;
        }
        int max = 0;
        int len = nums.length;
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {//开始遍历从0到i-1
                if (nums[j] < nums[i]) {//如果小于nums[i]，说明dp[i]起码是dp[j]+1，即比较dp[i]和dp[j]+1中的较大者更新dp[i]
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            //遍历找最大值
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 6, 7, 9, 4, 10, 5, 6};
        System.out.println(new Solution().lengthOfLIS(arr));
    }
}
