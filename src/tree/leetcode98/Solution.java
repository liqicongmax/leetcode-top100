package tree.leetcode98;

import tree.TreeNode;

/**
 * @author liqicong@myhexin.com
 * @date 2020/1/8 19:06
 */
public class Solution {
    /**
     * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
     * <p>
     * 假设一个二叉搜索树具有如下特征：
     * <p>
     * 节点的左子树只包含小于当前节点的数。
     * 节点的右子树只包含大于当前节点的数。
     * 所有左子树和右子树自身必须也是二叉搜索树。
     * 示例 1:
     * <p>
     * 输入:
     * 2
     * / \
     * 1   3
     * 输出: true
     * 示例 2:
     * <p>
     * 输入:
     * 5
     * / \
     * 1   4
     *      / \
     *     3   6
     * 输出: false
     * 解释: 输入为: [5,1,4,null,null,3,6]。
     *      根节点的值为 5 ，但是其右子节点值为 4 。
     * <p>
     * 链接：https://leetcode-cn.com/problems/validate-binary-search-tree
     *
     * @param root
     * @return
     */
    TreeNode now = null;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
//        if (!isValidBST(root.left)) {
//            return false;
//        }
        if(!isValidBST(root.left)){
            return false;   
        }
        System.out.println(root.val);
        if (now!=null&&now.val >= root.val) {
            return false;
        }
        now = root;
        if(!isValidBST(root.right)){
            return false;
        }
        return true;

    }
}
