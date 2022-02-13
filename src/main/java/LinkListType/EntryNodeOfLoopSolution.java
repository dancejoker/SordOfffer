package LinkListType;
//描述
// 给一个长度为n链表，若其中包含环，请找出该链表的环的入口结点，否则，返回null。
public class EntryNodeOfLoopSolution {
    //找到一快一满指针相遇处的节点，相遇的节点一定是在环中
    public static ListNodeDetail meetingNode(ListNodeDetail head) {
        if(head==null)
            return null;

        ListNodeDetail slow = head.next;
        if(slow==null)
            return null;

        ListNodeDetail fast = slow.next;
        while (slow != null && fast != null) {
            if(slow==fast){
                return fast;
            }
            slow=slow.next;
            fast=fast.next;

            if(fast!=slow){
                fast=fast.next;
            }
        }
        return null;
    }
    public ListNodeDetail EntryNodeOfLoop(ListNodeDetail pHead) {
        ListNodeDetail meetingNode=meetingNode(pHead);
        if(meetingNode==null)
            return null;
//      得到环中的节点个数
        int nodesInLoop=1;
        ListNodeDetail p1=meetingNode;
        while(p1.next!=meetingNode){
            p1=p1.next;
            ++nodesInLoop;
        }
//      移动p1
        p1=pHead;
        for(int i=0;i<nodesInLoop;i++){
            p1=p1.next;
        }
//      移动p1，p2
        ListNodeDetail p2=pHead;
        while(p1!=p2){
            p1=p1.next;
            p2=p2.next;
        }
        return p1;
    }
}
