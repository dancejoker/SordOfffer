package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 描述
 * 给定一个二叉树，返回该二叉树的之字形层序遍历，（第一层从左向右，下一层从右向左，一直这样交替）
 */
public class printBinaryTree {
    public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>>res=new ArrayList<ArrayList<Integer>>();
        if(pRoot==null){
            return res;
        }
        boolean resverse=false;
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        queue.add(pRoot);
        while(!queue.isEmpty()){
            ArrayList<Integer>list=new ArrayList<Integer>();
            int sz=queue.size();
            for(int i=0;i<sz;i++){
                TreeNode node=queue.poll();
                if(!resverse){
                    list.add(node.val);
                }else{
                    list.add(0,node.val);
                }

                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null)
                {
                    queue.add(node.right);
                }
            }
            res.add(list);
            resverse=!resverse;
        }
        return res;
    }
}
