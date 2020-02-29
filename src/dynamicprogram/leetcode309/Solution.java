package dynamicprogram.leetcode309;

/**
 * @author liqicong@myhexin.com
 * @date 2020/2/29 15:40
 */
public class Solution {
    /**
     * 给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​
     *
     * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
     *
     * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
     * 示例:
     *
     * 输入: [1,2,3,0,2]
     * 输出: 3
     * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
     *
     * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown
     * @param prices x
     * @return
     * 如果不考虑冷冻期，每天只能买入或者卖出，求最大收益
     */
    public int maxProfit(int[] prices) {
        //dp[n]表示第n天卖出的最大收益
        //dp[1]=0，dp[2]=prices[1]-price[0]
        int max=0;
        int[][] dp=new int[prices.length+1][3];
        //0表示不持有但能购买，1表示持有，2表示不持股但是不能购买
        dp[0][0]=0;
        dp[0][1]=-prices[0];
        dp[0][2]=0;

        for(int i=1;i<prices.length;i++){
            //第i天不持有股票的最大收益，共有2种可能
            //1.昨天持股今天卖了，2.昨天不持股今天也不持股
            dp[i][0]=Math.max(dp[i-1][2],dp[i-1][0]);

            //第i天持有股票的最大收益，2种可能
            //1.昨天持股今天不动，2.昨天不持股没买
            dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]-prices[i]);

            //第i天冷冻期的最大收益
            //只能是昨天持股今天卖了
            dp[i][2]=dp[i-1][1]+prices[i];
        }

        return Math.max(dp[prices.length-1][0],dp[prices.length-1][2]);
    }
    public static void main(String[] args){
        System.out.println(new Solution().maxProfit(new int[]{7,1,5,3,6,4}));
    }
}