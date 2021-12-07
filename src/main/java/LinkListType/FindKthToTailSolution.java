package LinkListType;

/**
 * 输入一个长度为 n 的链表，设链表中的元素的值为 ai ，返回该链表中倒数第k个节点。
 * 如果该链表长度小于k，请返回一个长度为 0 的链表。
 */
public class FindKthToTailSolution {
    public ListNode FindKthToTail (ListNode pHead, int k) {
        // write code here
        if(pHead == null || k < 0){
            return null;
        }
        ListNode fastIndex = pHead;
        ListNode slowIndex = pHead;

        for(int i = 0;i < k;++i){
            if(fastIndex.next == null){
                if(i == k - 1)
                    return pHead;
                else
                    return null;
            }
            fastIndex=fastIndex.next;
        }

        while(fastIndex.next != null){
            fastIndex = fastIndex.next;
            slowIndex = slowIndex.next;
        }

        return slowIndex.next;
    }
}
