package dynamicprogram.leetcode416;

import java.util.Arrays;

/**
 * @author liqicong@myhexin.com
 * @date 2020/4/27 18:37
 */
public class Solution {
    /**
     * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
     *
     * 注意:
     *
     * 每个数组中的元素不会超过 100
     * 数组的大小不会超过 200
     * 示例 1:
     *
     * 输入: [1, 5, 11, 5]
     *
     * 输出: true
     *
     * 解释: 数组可以分割成 [1, 5, 5] 和 [11].
     *  
     *
     * 示例 2:
     *
     * 输入: [1, 2, 3, 5]
     *
     * 输出: false
     *
     * 解释: 数组不能分割成两个元素和相等的子集.
     *
     * 链接：https://leetcode-cn.com/problems/partition-equal-subset-sum
     * @param nums
     * @return
     */
    public boolean canPartition(int[] nums) {
        //先遍历一遍求和，奇数false
        //得到一半的值，建立dp[n+1]
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        if(sum%2==1)return false;
        int n=sum/2;
        boolean[][] dp=new boolean[nums.length+1][n+1];//dp[i][j]表示第i轮装j总和的数是否能正好装满，nums有几个数就是有i轮，算上0是nums+1轮；因为最多只需要装满n数，所以j最大是n+1
        for(int i=0;i<dp.length;i++){
            dp[i][0]=true;
        }
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<=n;j++){
                if(j<nums[i-1]){//如果当前遍历到的数比j大，那dp[i][j]就不能加上去了，只能用上一个j的数值
                    dp[i][j]=dp[i-1][j];
                }else{
                    dp[i][j]=dp[i-1][j]| dp[i-1][j-nums[i-1]];
                    //dp[i-1][j]表示这轮不装，如果dp[i-1][j]是true，那这轮不装也是true
                    //dp[i-1][j-nums[i-1]]表示这轮装上nums[i-1]，那就要看上轮的情况，如果上轮装j-nums[i-1]是true，那这轮也是true，否则不可能是true
                }
            }
        }
        return dp[dp.length-1][n];
    }

    public static void main(String[] args){
        int[] nums=new int[]{2,2,3,5};
        System.out.println(new Solution().canPartition(nums));
    }
}
