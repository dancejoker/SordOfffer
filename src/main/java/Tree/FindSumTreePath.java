package Tree;

import java.util.ArrayList;

/**
 * 描述
 * 输入一颗二叉树的根节点root和一个整数expectNumber，
 * 找出二叉树中结点值的和为expectNumber的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * 如二叉树root为{10,5,12,4,7},expectNumber为22
 */
public class FindSumTreePath {
    //需要在外部保存递归的结果
    //总结果，所有的情况。
    ArrayList<ArrayList<Integer>> resultSet = new  ArrayList<ArrayList<Integer>>();
    //某一路径的结果
    ArrayList<Integer> result = new ArrayList<Integer>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        //当root为空，我们只返回空集合就行。
        if(root == null) return resultSet;
        //当root不为空,使用深度优先搜索target
        DFS_target(root,target);
        return resultSet;
    }

    public void DFS_target(TreeNode root,int target){
        //我们添加当前结点的值，然后再向左右子节点递归。
        result.add(root.val);
        target -= root.val;
        if(target == 0 && root.left == null && root.right == null){
            //注意此处需要以result为数据源构造新的arraylist，不能直接存入result（不停的在变）。
            resultSet.add(new ArrayList<Integer>(result));
        }
        //遍历左右子树
        if(root.left != null) FindPath(root.left,target);
        if(root.right != null) FindPath(root.right,target);
        //当该节点的左右子树不满足条件时，该节点(列表中最后一个节点)退出result
        result.remove(result.size()-1);
    }
}
