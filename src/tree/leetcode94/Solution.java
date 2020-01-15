package tree.leetcode94;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author liqicong@myhexin.com
 * @date 2020/1/8 17:02
 */
public class Solution {
    /**
     * 给定一个二叉树，返回它的中序 遍历。
     *
     * 示例:
     *
     * 输入: [1,null,2,3]
     *    1
     *     \
     *      2
     *     /
     *    3
     *
     * 输出: [1,3,2]
     *
     * 链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        if(root==null){
            return list;
        }
        Stack<TreeNode> stack=new Stack<>();
        while(root!=null||!stack.isEmpty()){
            // root所有左边的节点都添加到stack中
            while(root!=null){
                stack.push(root);
                root=root.left;
            }
            // 最左边的节点
            root=stack.pop();
            list.add(root.val);
            root=root.left;
        }
        return list;
    }
}
