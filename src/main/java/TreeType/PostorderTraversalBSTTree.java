package TreeType;

/**
 * 描述
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则返回true,否则返回false。
 * 假设输入的数组的任意两个数字都互不相同。（ps：我们约定空树不是二叉搜索树）
 */
public class PostorderTraversalBSTTree {

    /**
     *
     * 二叉搜索树的后序序列：
     * 最后一个为根，然后前面一部分为小于根的节点，后面一部分为大于根的节点。
     * 然后这两部分分别满足后序序列的条件。（典型的递归）
     *
     * 递归进行实现。返回值为boolean，所以可以自然想到
     * 结果为judge(array,start,a-1)&&judge(array,a,end-1);
     * a为前面部分和后面部分的分界。
     *
     * 那前面什么时候返回true什么时候返回false呢？
     * （start一般都小于end，那==和>时呢，是什么情况）
     * 把递归的测试用例往深了跑一跑。跑到只有一个元素的时候(start==end)，
     * 跑到只有一部分元素的时候（只有大于的或者只有小于的,start>end）。
     * 返回true。
     *
     * 如果后半段有一个小于array[end]的值，返回false。
     */
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence == null || sequence.length == 0) return false;
        return judge(sequence,0,sequence.length-1);
    }

    public boolean judge(int[] array,int start,int end){
        //start==end为单个元素
        //start>end为无另一半元素（只有大于array[end]的或者小于的）
        if(start >= end) return true;
        int index = start;
        while(array[index] < array[end]) index++;
        //后半段需要大于array[end]
        for(int i = index;i < end;i++){
            if(array[i] < array[end]){
                return false;
            }
        }
        //测试用例往下面跑一跑，就知道什么时候结束返回true了。
        return judge(array,start,index-1) && judge(array,index,end-1);
    }



}
