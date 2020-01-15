package tree.leetcode96;

/**
 * @author liqicong@myhexin.com
 * @date 2020/1/8 18:41
 */
public class Solution {
    /**
     * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
     *
     * 示例:
     *
     * 输入: 3
     * 输出: 5
     * 解释:
     * 给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
     *
     *    1         3     3      2      1
     *     \       /     /      / \      \
     *      3     2     1      1   3      2
     *     /     /       \                 \
     *    2     1         2                 3
     *
     * 链接：https://leetcode-cn.com/problems/unique-binary-search-trees
     * @param n
     * @return
     */
    public int numTrees(int n) {
        int[] dp=new int[n+1];
        dp[0]=1;
        dp[1]=1;
        // G(n)=G(i-1)*G(n-i),i的取值范围是1~n
        for(int i=2;i<n+1;i++){//这里的i就是递推公式中的n
            for(int j=1;j<i+1;j++){//j即i的范围，从1~n
                dp[i]+=dp[j-1]*dp[i-j];
            }
        }
        return dp[n];
    }
}
