package Tree;

import java.util.Stack;

/**
 * 描述
 * 给定一个二叉树其中的一个结点，请找出中序遍历顺序的下一个结点并且返回
 */
public class GetMiddleNextNode {
    // 分类讨论
    // 时间复杂度: 最好O(1), 最坏O(logn)
    // 空间复杂度: O(1)
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        // 1.当前结点有右孩子，则下一个要遍历的结点一定是右子树的最左结点
        if (pNode.right != null) {
            pNode = pNode.right;
            while (pNode.left != null) {
                pNode = pNode.left;
            }
            return pNode;
        }

        // 2.当前结点没有右孩子，但当前结点是父结点的左孩子，则下一个要遍历的结点是父结点
        if (pNode.right == null && pNode.next != null && pNode == pNode.next.left) {
            return pNode.next;
        }

        // 3.当前结点既没有右孩子，并且自身还是父结点的右孩子，那就沿着父结点向上回溯，直到找到一个结点是其父结点的左孩子为止，返回这个父结点。
        // 思路：把父结点看作一颗子树的根结点, 那么这颗子树已经遍历完了，则需要不断向上回溯，才能找到下一个要遍历的结点。
        // 如果当前子树是父结点的左子树，显然下一个要遍历的结点就是父结点；
        // 如果当前子树是父结点的右子树，显然父结点早就遍历过了，把父结点加入子树中，然后继续回溯。
        if (pNode.right == null && pNode.next != null && pNode == pNode.next.right) {
            pNode = pNode.next;
            while (pNode.next != null && pNode != pNode.next.left) {
                pNode = pNode.next;
            }
            return pNode.next;
        }

        // 4.其他情况都返回null
        return null;
    }
}
