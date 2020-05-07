package dynamicprogram.leetcode494;

/**
 * @author liqicong@myhexin.com
 * @date 2020/4/28 19:48
 */
public class Solution {
    /**
     * 给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面。
     *
     * 返回可以使最终数组和为目标数 S 的所有添加符号的方法数。
     *
     * 示例 1:
     *
     * 输入: nums: [1, 1, 1, 1, 1], S: 3
     * 输出: 5
     * 解释:
     *
     * -1+1+1+1+1 = 3
     * +1-1+1+1+1 = 3
     * +1+1-1+1+1 = 3
     * +1+1+1-1+1 = 3
     * +1+1+1+1-1 = 3
     *
     * 一共有5种方法让最终目标和为3。
     * 注意:
     *
     * 数组非空，且长度不会超过20。
     * 初始的数组的和不会超过1000。
     * 保证返回的最终结果能被32位整数存下。
     *
     * 链接：https://leetcode-cn.com/problems/target-sum
     * @param nums
     * @param S
     * @return
     */
    int total=0;
    int s;
    public int findTargetSumWays(int[] nums, int S) {
        s=S;
        helper(nums,1,0,0);
        helper(nums,-1,0,0);
        return total;
    }

    public void helper(int[] nums,int multi,int n,int sum){
        sum+=multi*nums[n];
        if(n==nums.length-1){
            if(sum==s) {

                total++;
            }
            return;
        }
        if(sum<=s) {
            helper(nums, multi, n + 1, sum);
        }
        if(sum>=s) {
            helper(nums, -1 * multi, n + 1, sum);
        }
    }
    
    public static void main(String[] args){
        int[] arr=new int[]{1,1,1,1,1};
        System.out.println(new Solution().findTargetSumWays(arr,3));
    }
}
