package dynamicprogram.leetcode279;

/**
 * @author liqicong@myhexin.com
 * @date 2020/2/21 16:56
 */
public class Solution {
    /**
     * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
     * <p>
     * 示例 1:
     * <p>
     * 输入: n = 12
     * 输出: 3
     * 解释: 12 = 4 + 4 + 4.
     * 示例 2:
     * <p>
     * 输入: n = 13
     * 输出: 2
     * 解释: 13 = 4 + 9.
     * <p>
     * 链接：https://leetcode-cn.com/problems/perfect-squares
     *
     * @param n
     * @return
     */
    public int numSquares(int n) {
        //最少不就是2个数相加吗，n=x1+x2
        //n减去一个最大的完全平方数，一直减不大于当前剩余的最大平方数，累计次数就好啦
        if (n < 4) {
            return n;
        }
        int[] dp = new int[n + 1];
        for (int i = 0; i < 4; i++) {
            dp[i] = i;
        }
        int cur = 2;
        for (int i = 4; i < n + 1; i++) {
            if(i>=(cur+1)*(cur+1)){
                cur++;
            }
            int res = i - cur * cur;
            if (res == 0) {
                dp[i] = 1;
            } else {
                dp[i] = 1 + dp[res];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numSquares(12));
    }
}
