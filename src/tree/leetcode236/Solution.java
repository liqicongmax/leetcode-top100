package tree.leetcode236;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author liqicong@myhexin.com
 * @date 2020/1/17 15:57
 */
public class Solution {

    /**
     * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
     *
     * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
     *
     * 例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
     *
     * 示例 1:
     *
     * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
     * 输出: 3
     * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
     * 示例 2:
     *
     * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
     * 输出: 5
     * 解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
     *
     * 链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree
     * @param root 树的根节点
     * @param p 树上的点P
     * @param q 树上的点Q
     * @return
     * 显然不可能是从pq往上走，应该是从root节点向下找，用一个数组保存p点的寻找路径，用另一个数组保存q点的寻找路径
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null||p==null||q==null){
            return null;
        }
        //root
        List<TreeNode> pPath=new LinkedList<>();
        List<TreeNode> qPath=new LinkedList<>();
        List<TreeNode> temp=new LinkedList<>();

        generatePath(root,p,pPath,temp);
        temp=new LinkedList<>();
        generatePath(root,q,qPath,temp);

        int len=Math.min(pPath.size(),qPath.size());
        TreeNode res=root;
        for(int i=0;i<len;i++){
            System.out.println("p"+pPath.get(i).val);
            System.out.println("q"+qPath.get(i).val);
            if(pPath.get(i).val==qPath.get(i).val){
                res=pPath.get(i);
            }
        }
        return res;
    }

    public void generatePath(TreeNode root,TreeNode target,List<TreeNode> path,List<TreeNode> temp){
        if(root==null)return;
//        List<TreeNode> temp=new LinkedList<>(path);
//        temp.add(root);
        temp.add(root);
        if(root.val==target.val){
            path.addAll(temp);
            return;
        }
        generatePath(root.left,target,path,temp);
        generatePath(root.right,target,path,temp);
        ((LinkedList<TreeNode>) temp).removeLast();
    }

}
