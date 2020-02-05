package dynamicprogram.leetcode96;

/**
 * @Author liqicong
 * @Date 2020/2/5 9:46
 * @Description
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
     * @param n n
     * @return
     * 以n=3为例，一共有根节点为1，2,3的三种情况，因为是二叉搜索树，当根节点为i时，左子树会有i-1个节点，右子树有n-i个节点
     * F(n)表示n个节点能构成多少种二叉搜索树
     * F(n)=F(0)*F(n-1)+F(1)*F(n-2)+···+F(n-1)*F(0)
     * F(0)=1;F(1)=1;F(2)=2;F(3)=5;
     */
    public static int numTrees(int n) {
        if(n<3){
            return n;
        }
        int[] dp=new int[n+1];
        dp[0]=1;
        dp[1]=1;
        dp[2]=2;
        for(int i=3;i<=n;i++){
            int sum=0;
            for(int j=0;j<i;j++){
                sum+=dp[j]*dp[i-1-j];//n=4 j=0,1,2,3
            }
            dp[i]=sum;
        }
        return dp[n];
    }
    public static void main(String[] args){
        System.out.println(numTrees(4));
    }
}
