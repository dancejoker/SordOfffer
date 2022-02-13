package LinkListType;

import java.util.ArrayList;

/**
 * 描述
 * 输入一个长度为n链表，反转链表后，输出新链表的表头。
 */
public class ReverseListSolution {
    public ListNodeDetail ReverseList(ListNodeDetail head) {

        if(head == null || head.next == null){
            return head;
        }
        ListNodeDetail index = new ListNodeDetail(-9999);
        ListNodeDetail node = null;
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

        ListNodeDetail it = new ListNodeDetail(0);
        ListNodeDetail start = it;


        while (i <= num){
            ListNodeDetail node = new ListNodeDetail(i);
            it.next = node;
            it = it.next;
            ++i;
        }

        ReverseListSolution reverseListSolution = new ReverseListSolution();
        ListNodeDetail listNodeDetail = reverseListSolution.ReverseList(start);
        while(listNodeDetail != null){
            System.out.println(listNodeDetail.val);
            listNodeDetail = listNodeDetail.next;
        }

    }
}
