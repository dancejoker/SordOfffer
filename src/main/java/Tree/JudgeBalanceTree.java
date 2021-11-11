package Tree;

import java.util.LinkedList;

/**
 * 描述
 * 输入一棵节点数为 n 二叉树，判断该二叉树是否是平衡二叉树。
 * 在这里，我们只需要考虑其平衡性，不需要考虑其是不是排序二叉树
 * 平衡二叉树（Balanced Binary Tree），
 * 具有以下性质：它是一棵空树或它的左右两个子树的高度差的绝对值不超过1，并且左右两个子树都是一棵平衡二叉树。
 */
public class JudgeBalanceTree {
    boolean flag = true;
    public boolean IsBalanced_Solution(TreeNode root) {
        checkBalanceTree(root);
        return flag;
    }
    void checkBalanceTree(TreeNode root){
        if(root == null) return;
        int Lheight=getHeight(root.left);
        int Rheight=getHeight(root.right);
        if(Math.abs(Lheight-Rheight)>1){
            flag = false;
        }
        checkBalanceTree(root.left);
        checkBalanceTree(root.right);
    }

    public Integer getHeight(TreeNode root){
        if(root == null) return 0;
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        Integer height=0;
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;++i){
                TreeNode treeNode = queue.poll();
                if(treeNode.left != null) queue.add(treeNode.left);
                if(treeNode.right != null) queue.add(treeNode.right);
            }
            height++;

        }
        return  height;
    }
}
