package dynamicprogram.leetcode152;

/**
 * @author liqicong@myhexin.com
 * @date 2020/2/20 9:18
 */
public class Solution {
    /**
     * 给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。
     *
     * 示例 1:
     *
     * 输入: [2,3,-2,4]
     * 输出: 6
     * 解释: 子数组 [2,3] 有最大乘积 6。
     * 示例 2:
     *
     * 输入: [-2,0,-1]
     * 输出: 0
     * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
     *
     * 链接：https://leetcode-cn.com/problems/maximum-product-subarray
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        int max=Integer.MIN_VALUE;
        int imax=1;
        int imin=1;
        //如果数组的值是负数，会导致最大的变最小，最小的变最大
        //需要设定两个值保存最大值和最小值，当nums[i]是负数时，显然最大值和最小值是要换位的，
        //然后进行最大值*nums[i]和nums[i]的比较，即比较当前最大乘了nums[i]还是最大吗，不是最大就丢了，从当前nums[i]开始
        //最小值同理
        //然后比较最大值，更新最大值
        for(int i=0;i<nums.length;i++){
            if(nums[i]<0){
                int temp=imax;
                imax=imin;
                imin=temp;
            }
            imax=Math.max(nums[i]*imax,nums[i]);
            imin=Math.min(nums[i]*imin,nums[i]);
            max=Math.max(imax,max);
        }
        return max;
    }
    public int solution(int[] nums){
        if(nums.length==0){
            return 0;
        }
        int max=Integer.MIN_VALUE;
        int[] maxdp=new int[nums.length+1];
        int[] mindp=new int[nums.length+1];
        maxdp[0]=1;
        mindp[0]=1;
        for(int i=1;i<=nums.length;i++){
            if(nums[i-1]<0){
                int temp=maxdp[i-1];
                maxdp[i-1]=mindp[i-1];
                mindp[i-1]=temp;
            }
            maxdp[i]=Math.max(nums[i-1]*maxdp[i-1],nums[i-1]);
            mindp[i]=Math.min(nums[i-1]*mindp[i-1],nums[i-1]);
            max=Math.max(max,maxdp[i]);
        }
        return max;
    }

    public static void main(String[] args){
        int[] arr=new int[]{2,3,-2,4};
        System.out.println(new Solution().maxProduct(arr));
    }
}