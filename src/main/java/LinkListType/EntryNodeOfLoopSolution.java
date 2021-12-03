package LinkListType;

/**
 * 给一个长度为n链表，若其中包含环，请找出该链表的环的入口结点，否则，返回null。
 */
public class EntryNodeOfLoopSolution {
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if(pHead == null){
            return pHead;
        }

        ListNode fastNode = pHead;
        ListNode slowNode = pHead;

        while(fastNode != null && fastNode.next != null){
            fastNode = fastNode.next.next;
            slowNode = slowNode.next;
            if(fastNode == slowNode) break;
        }
        if(fastNode == null || fastNode.next == null)
            return null;

        slowNode = pHead;
        while(slowNode != fastNode){
            slowNode = slowNode.next;
            fastNode = fastNode.next;
        }
        return fastNode;
    }

}
