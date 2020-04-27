package dynamicprogram.leetcode338;

import java.util.Arrays;

/**
 * @author liqicong@myhexin.com
 * @date 2020/4/26 19:15
 */
public class Solution {
    /**
     * 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
     *
     * 示例 1:
     *
     * 输入: 2
     * 输出: [0,1,1]
     * 示例 2:
     *
     * 输入: 5
     * 输出: [0,1,1,2,1,2]
     * 进阶:
     *
     * 给出时间复杂度为O(n*sizeof(integer))的解答非常容易。但你可以在线性时间O(n)内用一趟扫描做到吗？
     * 要求算法的空间复杂度为O(n)。
     * 你能进一步完善解法吗？要求在C++或任何其他语言中不使用任何内置函数（如 C++ 中的 __builtin_popcount）来执行此操作。
     *
     * 链接：https://leetcode-cn.com/problems/counting-bits
     * @param num
     * @return
     */
    public int[] countBits(int num) {
        int[] dp=new int[num+1];
        dp[0]=0;
        if(num>=1) {
            dp[1] = 1;
        }
        if(num>=2) {
            dp[2] = 1;
        }
        //整活
        int target=4;
        for(int i=3;i<=num;i++){
            if(i==target){
                dp[i]=1;
                target*=2;
                continue;
            }
            if(i%2==1){
                dp[i]=dp[i-1]+1;
            }else{
                if(i<target){
                    dp[i]=dp[target/2]+dp[i-target/2];
                }else{
                    dp[i]=dp[target]+dp[i-target];
                }
            }
        }
        return dp;
    }
    public static void main(String[] args){
        System.out.println(Arrays.toString(new Solution().countBits(16)));
    }
}
