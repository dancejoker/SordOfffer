package TreeType;

import java.util.Stack;
//描述
//给定一棵节点数为 n 二叉搜索树，请找出其中的第 k 小的TreeNode结点。

public class FindKthNode {
    TreeNode KthNode(TreeNode pRoot, int k) {
        if(pRoot == null || k <= 0){
            return null;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>(); //建立栈
        TreeNode cur = pRoot;
        //while 部分为中序遍历
        while(!stack.isEmpty() || cur != null){
            if(cur != null){
                stack.push(cur); //当前节点不为null，应该寻找左儿子
                cur = cur.left;
            }else{
                cur = stack.pop();//当前节点null则弹出栈内元素，相当于按顺序输出最小值。
                if(--k == 0){ //计数器功能
                    return cur;
                }
                cur = cur.right;
            }
        }
        return null;
    }


}
