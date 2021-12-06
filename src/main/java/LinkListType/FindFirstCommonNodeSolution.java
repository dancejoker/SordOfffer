package LinkListType;

/**
 * 输入两个无环的单向链表，找出它们的第一个公共结点，如果没有公共节点则返回空。
 * （注意因为传入数据是链表，所以错误测试数据的提示是用其他方式显示的，保证传入数据是正确的）
 */
public class FindFirstCommonNodeSolution {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode index1 = pHead1;
        ListNode index2 = pHead2;
        while(index1 != index2){
            if(index1 != null)
                index1 = index1.next;
            else
                index1 = pHead2;


            if(index2 != null)
                index2 = index2.next;
            else
                index2 = pHead1;

        }
        return index2;
    }
}
