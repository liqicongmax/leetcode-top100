package tree.leetcode337;

import tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author liqicong@myhexin.com
 * @date 2020/1/19 10:10
 */
public class Solution {
    /**
     * 在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。
     * 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。
     * 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
     *
     * 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
     *
     * 示例 1:
     *
     * 输入: [3,2,3,null,3,null,1]
     *
     *      3
     *     / \
     *    2   3
     *     \   \
     *      3   1
     *
     * 输出: 7
     * 解释: 小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7.
     * 示例 2:
     *
     * 输入: [3,4,5,1,3,null,1]
     *          0
     *         /
     *      3
     *     / \
     *    4   5
     *   / \   \
     *  1   3   1
     *
     * 输出: 9
     * 解释: 小偷一晚能够盗取的最高金额 = 4 + 5 = 9.
     *
     * 链接：https://leetcode-cn.com/problems/house-robber-iii
     * @param root
     * @return
     * 既然要求最大金额，肯定要把所有可能性都列出来。
     * 原理就是从一个节点开始，求它的子树的左右子树和，然后从这个左右子树开始，再找后面他们的子树的左右子树和
     * 只需要比较从根节点开始加的总和跟第二层遍历开始加的总和差多少了
     * 实际上就是层序遍历隔行累加
     */
    public int rob(TreeNode root) {
        if(root==null){
            return 0;
        }
        // 抢法两种，从根节点开始和从根节点的子树开始
        // 找起始节点的子树的左右子树和，递归从这两个左右子树再开始找
        int val = 0;
        if(root.left != null) val += rob(root.left.left) + rob(root.left.right);
        if(root.right != null) val += rob(root.right.left) + rob(root.right.right);
        return Math.max(rob(root.left) + rob(root.right),val + root.val);

    }


    public int rob1(TreeNode root) {
        /*
        你是我见过最聪明的小偷
        */
        /*
        //递归思想（不要深入递归函数体，只需知道递归函数的功能，以及找到跳出递归的边界条件）
        //思路：
        //能盗取的最高金额为 抢劫该节点+抢劫该节点的左孩子的左右子树+抢劫该节点的右孩子的左右子树
        //与 抢劫该节点的左子树+抢劫该节点的右子树的和  的最大值
        //执行用时 1005ms  原因是出现了很多重复的计算，可使用动态规划解决
        if(root == null) return 0;
        int val = 0;
        if(root.left != null) val += rob(root.left.left) + rob(root.left.right);
        if(root.right != null) val += rob(root.right.left) + rob(root.right.right);
        return Math.max(rob(root.left) + rob(root.right),val + root.val);
        */

        //动态规划
        //思路：
        //定义一个数组res,长度为2,res[0]表示不抢该节点可获得最大值,res[1]表示抢劫该节点可获得最大值
        //方法helper(r)意为：在以r为根节点的树中,返回抢劫根节点与不抢劫根节点可获得的最大值
        //执行用时 2ms
        int[] res = helper(root);
        return Math.max(res[0],res[1]);
    }

    public int[] helper(TreeNode r){
        if(r == null) return new int[2];//边界条件，r为null时，跳出
        int[] left = helper(r.left);//对于以r.left为根的树，计算抢劫根节点(r.left)与不抢劫根节点可获得最大金额. left[0]则为不抢r.lrft可获得的最大金额,left[1]则为抢劫r.left可获得的最大金额  以下right[] 分析同理
        int[] right = helper(r.right);
        int[] res = new int[2];
        res[0] = Math.max(left[0],left[1]) + Math.max(right[0],right[1]);//计算不抢劫当前根节点可获得的最大金额(那么其左右子树可以随便抢)
        res[1] = r.val + left[0] + right[0];//计算若抢劫根节点可获得的最大金额(此时,其左右子树的根节点不能被抢)
        return res;
    }
}
