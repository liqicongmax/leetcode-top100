package tree.leetcode104;

import tree.TreeNode;

/**
 * @author liqicong@myhexin.com
 * @date 2020/1/9 20:29
 */
public class Solution {
    /**
     * 给定一个二叉树，找出其最大深度。
     *
     * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
     *
     * 说明: 叶子节点是指没有子节点的节点。
     *
     * 示例：
     * 给定二叉树 [3,9,20,null,null,15,7]，
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * 返回它的最大深度 3 。
     *
     * 链接：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree
     * @param root
     * @return
     */
    int maxLeft=0;
    int maxRight=0;
    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        maxDepth(root.left);
        if(root.left!=null)maxLeft++;

        maxDepth(root.right);
        if(root.right!=null)maxRight++;

        return maxRight>maxLeft?maxRight:maxLeft;
    }

}
