package tree.leetcode114;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author liqicong@myhexin.com
 * @date 2020/1/15 13:39
 */
public class Solution {
    /**
     * 给定一个二叉树，原地将它展开为链表。
     *
     * 例如，给定二叉树
     *
     *     1
     *    / \
     *   2   5
     *  / \   \
     * 3   4   6
     * 将其展开为：
     *
     * 1
     *  \
     *   2
     *    \
     *     3
     *      \
     *       4
     *        \
     *         5
     *          \
     *           6
     * 链接：https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list
     * @param root
     * 像中序遍历，我先写个中序遍历
     */
    public void flatten(TreeNode root) {
        if(root==null){
            return;
        }
        Stack<TreeNode> stack=new Stack<>();
        TreeNode temp=root;
        //在root的基础上动，
        while(root!=null||!stack.isEmpty()){
            while(root!=null){
                stack.push(root);
                root=root.left;
            }
            if(!stack.isEmpty()){
                TreeNode node=stack.pop();
                root=node.right;

            }
        }
    }

    /**
     * 这是解法
     */
    TreeNode last=null;
    public void flattern(TreeNode root){
        if(root==null){
            return;
        }
        // last作为root当前指针的代理节点
        if(last!=null){
            last.left=null;
            last.right=root;
        }
        // last遍历root的每个节点去做左节点清空和右节点连接的工作
        // 给下一次的清空和赋值做准备
        last=root;
        // 如果这个copyRight不保存直接在下面用root.right，会导致root.right被修改
        TreeNode copyRight=root.right;
        flattern(root.left);
        flattern(copyRight);

    }

    public List<Integer> inorderTraversal(TreeNode root){
        List<Integer> list=new ArrayList<>();
        if(root==null){
            return list;
        }
        Stack<TreeNode> stack=new Stack<>();
        while(root!=null||!stack.isEmpty()){
            while(root!=null){
                stack.push(root);
                list.add(root.val);
                root=root.left;
            }
            if(!stack.isEmpty()){
                root=stack.pop();
                root=root.right;

            }
        }
        return list;
    }
}