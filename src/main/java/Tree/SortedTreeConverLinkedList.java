package Tree;

import java.util.Stack;
//二叉搜索树与双向链表
//输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表
public class SortedTreeConverLinkedList {
    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree==null)
            return null;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode p = pRootOfTree;
        TreeNode pre = null;// 用于保存中序遍历序列的上一节点
        boolean isFirst = true;
        while(p != null || !stack.isEmpty()){
            while(p!=null){
                stack.push(p);
                p = p.left;
            }
            p = stack.pop();
            if(isFirst){
                // 20,21行代码顺序不能变
                pRootOfTree = p;// 将中序遍历序列中的第一个节点记为pRootOfTree
                pre = pRootOfTree;
                isFirst = false;
            }else{
                pre.right = p;
                p.left = pre;
                pre = p;
            }
            p = p.right;
        }
        return pRootOfTree;
    }


}
