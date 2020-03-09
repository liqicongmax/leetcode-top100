package review;

import tree.TreeNode;
import 每日一题.ListNode;

/**
 * @author liqicong@myhexin.com
 * @date 2020/3/5 10:19
 */
public class ListNode2TreeNode {
    /**
     * 升序链表转左右子树高度差小于1的平衡二叉搜索树
     * @param head
     * @return
     */
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode pre=head;
        ListNode q=pre.next;
        ListNode p=q.next;
        while(p!=null){
            pre=pre.next;
            p=p.next.next;
        }
        q=pre.next;
        pre.next=null;
        TreeNode root=new TreeNode(q.val);
        root.left=sortedListToBST(head);
        root.right=sortedListToBST(q.next);
        return root;
    }
}
