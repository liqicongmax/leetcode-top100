package tree.leetcode101;

import tree.TreeNode;

import java.util.LinkedList;

/**
 * @author liqicong@myhexin.com
 * @date 2020/1/8 19:43
 */
public class Solution {
    /**
     * 给定一个二叉树，检查它是否是镜像对称的。
     *
     * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
     *
     *     1
     *    / \
     *   2   2
     *  / \ / \
     * 3  4 4  3
     * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
     *
     *     1
     *    / \
     *   2   2
     *    \   \
     *    3    3
     * 说明:
     *
     * 如果你可以运用递归和迭代两种方法解决这个问题，会很加分。
     *
     * 链接：https://leetcode-cn.com/problems/symmetric-tree
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        return isDuiCheng(root,root);
    }

    public boolean isDuiCheng(TreeNode root1,TreeNode root2){
        if(root1==null&&root2==null){
            return true;
        }
        if(root1==null||root2==null){
            return false;
        }
        if(root1.val!=root2.val){
            return false;
        }
        return isDuiCheng(root1.left,root2.right)&&isDuiCheng(root1.right,root2.left);
    }

    public boolean isSame(TreeNode root){
        if(root==null){
            return true;
        }
        LinkedList<TreeNode> queue=new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);
        while(!queue.isEmpty()){
            TreeNode left=queue.removeFirst();
            TreeNode right=queue.removeFirst();
            if(left==null&&right==null)continue;
            if(left==null||right==null)return false;
            if(left.val!=right.val)return false;

            queue.offer(left.left);
            queue.offer(right.right);

            queue.offer(left.right);
            queue.offer(right.left);
        }
        return true;
    }
}
