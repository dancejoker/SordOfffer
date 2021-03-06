package LinkListType;

import java.util.ArrayList;

/**
 * 描述
 * 输入一个链表的头节点，按链表从尾到头的顺序返回每个节点的值（用数组返回）。
 */
public class ReversePrintLinkList {
    public ArrayList<Integer> printListFromTailToHead(ListNodeDetail listNodeDetail) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        ListNodeDetail iterator = listNodeDetail;
        while(iterator != null){
            arrayList.add(0,iterator.val);
            iterator = iterator.next;
        }
        return arrayList;
    }

    public static void main(String[] args) {
        int num = 5;
        int i = 1;

        ArrayList<Integer> list = new ArrayList<Integer>();
        ListNodeDetail it = new ListNodeDetail(0);
        ListNodeDetail start = it;


        while (i <= num){
            ListNodeDetail node = new ListNodeDetail(i);
            it.next = node;
            it = it.next;
            ++i;
        }
        ReversePrintLinkList reversePrintLinkList = new ReversePrintLinkList();
        list = reversePrintLinkList.printListFromTailToHead(start);
        System.out.println(list.toString());
//        for(int j = 0;j<list.size();j++){
//            System.out.println(list.get(j));
//        }

    }
}


