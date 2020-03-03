package 每日一题;

/**
 * @author liqicong@myhexin.com
 * @date 2020/3/2 13:56
 */
public class Leetcode206 {
    /**
     * 反转一个单链表。
     *
     * 示例:
     *
     * 输入: 1->2->3->4->5->NULL
     * 输出: 5->4->3->2->1->NULL
     * 进阶:
     * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
     *
     * 链接：https://leetcode-cn.com/problems/reverse-linked-list
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode cur=reverseList(head.next);
        head.next.next=head;
        head.next=null;
        return cur;
    }

    public ListNode reverse(ListNode head){
        if(head==null||head.next==null){
            return head;
        }
        ListNode pre=null;
        ListNode cur=head;
        while(cur!=null){
            ListNode next=cur.next;//暂存下一个需要遍历的节点
            cur.next=pre;//倒着指向
            pre=cur;//更新这次的pre了
            cur=next;//进入到下个节点的遍历
        }
        return pre;
    }
}
