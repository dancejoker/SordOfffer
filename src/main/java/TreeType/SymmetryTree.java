package TreeType;

/**
 * 描述
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 */
public class SymmetryTree {
    boolean isSymmetrical(TreeNode pRoot) {
        if(pRoot == null){
            return true;
        }
        return checkSymmetry(pRoot.left,pRoot.right);
    }
    public boolean checkSymmetry(TreeNode nodeLeft,TreeNode nodeRight){
        if(nodeLeft==null && nodeRight==null) return  true;
        if(nodeLeft == null) return nodeRight==null;
        if(nodeRight == null) return false;
        if(nodeLeft.val != nodeRight.val) return false;
        return checkSymmetry(nodeLeft.left,nodeRight.right) && checkSymmetry(nodeLeft.right,nodeRight.left);

    }
}
