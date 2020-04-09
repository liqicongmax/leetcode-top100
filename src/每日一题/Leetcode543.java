package 每日一题;

import tree.TreeNode;

/**
 * @author liqicong@myhexin.com
 * @date 2020/3/10 12:28
 */
public class Leetcode543 {
    /**
     * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过根结点。
     *
     * 示例 :
     * 给定二叉树
     *
     *           1
     *          / \
     *         2   3
     *        / \
     *       4   5
     * 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
     *
     * 注意：两结点之间的路径长度是以它们之间边的数目表示。
     *
     * 链接：https://leetcode-cn.com/problems/diameter-of-binary-tree
     * @param root
     * @return
     */
    int max=0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null){
            return 0;
        }
        helper(root);
        return max;
    }

    //求这个节点往下的最大深度
    public int helper(TreeNode root){
        if(root==null){
            return 0;
        }
        int left=helper(root.left);
        int right=helper(root.right);
        max=Math.max(left+right,max);
        return Math.max(left,right)+1;
    }
}
