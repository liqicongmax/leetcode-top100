package tree.leetcode226;

import tree.TreeNode;

/**
 * @author liqicong@myhexin.com
 * @date 2020/1/15 15:22
 */
public class Solution {

    /**
     * 翻转一棵二叉树。
     *
     * 示例：
     *
     * 输入：
     *
     *      4
     *    /   \
     *   2
     *  / \
     * 1   3
     * 输出：
     *
     *      4
     *    /   \
     *   7     2
     *  / \   / \
     * 9   6 3   1
     * 备注:
     * 这个问题是受到 Max Howell 的 原问题 启发的 ：
     *
     * 谷歌：我们90％的工程师使用您编写的软件(Homebrew)，但是您却无法在面试时在白板上写出翻转二叉树这道题，这太糟糕了。
     *
     * 链接：https://leetcode-cn.com/problems/invert-binary-tree
     * @param root
     * @return
     * 只要当前节点下的左右节点换位，然后root.left递归，root.right递归，直到节点为空
     */
    public TreeNode invertTree(TreeNode root) {
        invert(root);
        return root;
    }

    public void invert(TreeNode root){
        if(root==null) {
            return;
        }
        TreeNode temp=root.left;
        root.left=root.right;
        root.right=temp;
        invert(root.left);
        invert(root.right);
    }

    //

}
