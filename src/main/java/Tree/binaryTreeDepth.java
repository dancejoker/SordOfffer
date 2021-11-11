package Tree;


import java.util.LinkedList;
import java.util.Queue;

/**
 * 描述
 * 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点
 * （含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 */

public class binaryTreeDepth {
    // 非递归，层次遍历
    public int TreeDepth(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        //记录每一层元素个数
        int count = 0;
        //记录层数，即树的深度
        int res = 0;
        while(!queue.isEmpty()){
            count = queue.size();
            while(count != 0){
                count--;
                TreeNode node = queue.poll();
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            res++;
        }
        return res;
    }
    public int test(TreeNode root){
        if(root== null) return 0;
        LinkedList<TreeNode> treeNodes = new LinkedList<TreeNode>();
        treeNodes.add(root);
        int high = 0;
        while(!treeNodes.isEmpty()){
            int count = treeNodes.size();
            while(count !=0){
                count --;
                TreeNode node = treeNodes.poll();
                if(node.left != null) treeNodes.add(node.left);
                if(node.right != null) treeNodes.add(node.right);
            }
            high++;
        }
        return  high;

    }

    // 方法2:递归算法
    public int TreeDepthWithRecurse(TreeNode root) {
        return root == null ? 0 : Math.max(TreeDepthWithRecurse(root.left), TreeDepthWithRecurse(root.right)) + 1;
    }

}
