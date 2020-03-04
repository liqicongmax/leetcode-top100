package tree.leetcode109;

import tree.TreeNode;
import 每日一题.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liqicong@myhexin.com
 * @date 2020/3/4 15:22
 */
public class Solution {
    /**
     * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
     *
     * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
     *
     * 示例:
     *
     * 给定的有序链表： [-10, -3, 0, 5, 9],
     *
     * 一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
     *
     *       0
     *      / \
     *    -3   9
     *    /   /
     *  -10  5
     *
     * 链接：https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree
     * @param head
     * @return
     */
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        else if(head.next == null) return new TreeNode(head.val);

        ListNode pre = head;
        ListNode p = pre.next;//走一步的节点的右边那个，即中点
        ListNode q = p.next;//走2步的节点
        //找到链表的中点p
        while(q!=null && q.next!=null){
            pre = pre.next;
            q = q.next.next;
        }
        p = pre.next;
        //将中点左边的链表分开
        pre.next = null;
        TreeNode root = new TreeNode(p.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(p.next);
        return root;
    }


}
