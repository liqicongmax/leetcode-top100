package dynamicprogram.leetcode53;

/**
 * @Author liqicong
 * @Date 2020/2/3 15:34
 * @Description
 */
public class Solution {
    /**
     * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     * <p>
     * 示例:
     * <p>
     * 输入: [-2,1,-3,4,-1,2,1,-5,4],
     * 输出: 6
     * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
     * 进阶:
     * <p>
     * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
     * <p>
     * 链接：https://leetcode-cn.com/problems/maximum-subarray
     *
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum > max) {
                max = sum;
            }
            if(sum<0){
                sum=0;
            }
        }
        return max;
    }
    public static void main(String[] args){
        System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
}
