package Tree;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 给定一个节点数为 n 二叉树，要求从上到下按层打印二叉树的 val 值，同一层结点从左至右输出。每一层输出一行。
 */
public class LayerPrintTree {
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
        if(pRoot == null) return lists;
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(pRoot);
        while(!queue.isEmpty()){
            int size = queue.size();
            ArrayList layer  = new ArrayList<Integer>();
            for(int i=0;i < size;++i) {
                TreeNode treeNode = queue.poll();
                layer.add(treeNode.val);
                if (treeNode.left != null) queue.add(treeNode.left);
                if (treeNode.right != null) queue.add(treeNode.right);
            }
            lists.add(layer);

        }
        return lists;
    }
}
