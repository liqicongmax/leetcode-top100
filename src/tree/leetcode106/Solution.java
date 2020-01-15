package tree.leetcode106;

import tree.TreeNode;

import java.util.Arrays;

/**
 * @author liqicong@myhexin.com
 * @date 2020/1/10 14:20
 */
public class Solution {
    /**
     * 根据一棵树的中序遍历与后序遍历构造二叉树。
     *
     * 注意:
     * 你可以假设树中没有重复的元素。
     *
     * 例如，给出
     *
     * 中序遍历 inorder = [9,3,15,20,7]
     * 后序遍历 postorder = [9,15,7,20,3]
     * 返回如下的二叉树：
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     *
     * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal
     * @param inorder
     * @param postorder
     * @return
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length==0||inorder.length!=postorder.length){
            return null;
        }

        int distance=0;
        int length=inorder.length;
        TreeNode root=new TreeNode(postorder[length-1]);
        while(inorder[distance]!=postorder[length-1]){
            distance++;
        }

        root.left=buildTree(Arrays.copyOfRange(inorder,0,distance),Arrays.copyOfRange(postorder,0,distance));
        root.right=buildTree(Arrays.copyOfRange(inorder,distance+1,length),Arrays.copyOfRange(postorder,distance,length-1));

        return root;

    }

}