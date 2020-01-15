package tree.leetcode102;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author liqicong@myhexin.com
 * @date 2020/1/9 10:45
 */
public class Solution {
    /**
     * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
     *
     * 例如:
     * 给定二叉树: [3,9,20,null,null,15,7],
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * 返回其层次遍历结果：
     *
     * [
     *   [3],
     *   [9,20],
     *   [15,7]
     * ]
     *
     * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result=new ArrayList<>();
        if(root==null){
            return result;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        List<Integer> list=new ArrayList<>();
        int count=0;
        int length=1;
        while(!queue.isEmpty()){
            TreeNode node=queue.poll();
            System.out.println(node.val);
            list.add(node.val);
            count++;
            if(node.left!=null){
                queue.offer(node.left);
            }
            if(node.right!=null){
                queue.offer(node.right);
            }
            if(count==length){
                result.add(list);
                list=new ArrayList<>();
                count=0;
                length=queue.size();
            }
        }
        return result;
    }

    public List<List<Integer>> levelorder(TreeNode root){
        List<List<Integer>> result=new ArrayList<>();
        if(root==null){
            return result;
        }
        helper(result,root,0);
        return result;
    }

    public void helper(List<List<Integer>> res,TreeNode root,int depth){
        if(root==null)return;
        if(res.size()==depth)res.add(new ArrayList<>());
        res.get(depth).add(root.val);
        helper(res,root.left,depth+1);
        helper(res,root.right,depth+1);
    }
}
