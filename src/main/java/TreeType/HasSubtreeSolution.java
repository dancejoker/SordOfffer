package TreeType;

/**
 * 描述
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 */
public class HasSubtreeSolution {
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if ( root2 == null || root1 == null){
            return false;
        }
        return doesTree1HasTree(root1, root2) || HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
    }


    public boolean doesTree1HasTree(TreeNode tree1, TreeNode tree2){
        if ( tree2 == null ){
            return true;
        }
        if ( tree1 == null ){
            return false;
        }

        if ( tree1.val != tree2.val ){
            return false;
        }
        return doesTree1HasTree(tree1.left, tree2.left) && doesTree1HasTree(tree1.right, tree2.right);
    }

}
