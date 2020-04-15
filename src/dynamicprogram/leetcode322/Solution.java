package dynamicprogram.leetcode322;

/**
 * @author liqicong@myhexin.com
 * @date 2020/4/13 9:13
 */
public class Solution {
    /**
     * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
     *
     * 示例 1:
     *
     * 输入: coins = [1, 2, 5], amount = 11
     * 输出: 3
     * 解释: 11 = 5 + 5 + 1
     * 示例 2:
     *
     * 输入: coins = [2], amount = 3
     * 输出: -1
     * 说明:
     * 你可以认为每种硬币的数量是无限的。
     *
     * 链接：https://leetcode-cn.com/problems/coin-change
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        int[] dp=new int[amount+1];
        int len=coins.length;
        next:for(int i=1;i<=amount;i++){
            for(int j=len-1;j>=0;j--){
                if(coins[j]<=i){
                    if(dp[i-coins[j]]!=-1){
                        dp[i]=1+dp[i-coins[j]];
                        continue next;
                    }
                }
                dp[i]=-1;
            }
        }
        return dp[amount];
    }
    public static void main(String[] args){
        int[] coins=new int[]{1,2,5};
        System.out.println(new Solution().coinChange(coins,11));
    }
}
