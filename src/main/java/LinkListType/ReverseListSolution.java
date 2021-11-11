package LinkListType;

import java.util.ArrayList;

/**
 * 描述
 * 输入一个长度为n链表，反转链表后，输出新链表的表头。
 */
public class ReverseListSolution {
    public ListNode ReverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode index = new ListNode(-9999);
        ListNode node = null;
        while(head != null){
            node = head;
            head=head.next;
            node.next = index.next;
            index.next = node;

        }
        return index.next;
    }

    public static void main(String[] args) {
        int num = 5;
        int i = 1;

        ListNode it = new ListNode(0);
        ListNode start = it;


        while (i <= num){
            ListNode node = new ListNode(i);
            it.next = node;
            it = it.next;
            ++i;
        }

        ReverseListSolution reverseListSolution = new ReverseListSolution();
        ListNode listNode = reverseListSolution.ReverseList(start);
        while(listNode != null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }

    }
}
