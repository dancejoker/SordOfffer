package Algorithm.DynamicProgramming;

/**
 * 描述
 * 输入一个长度为n的整型数组a，数组中的一个或连续多个整数组成一个子数组。
 * 求所有子数组的和的最大值。要求时间复杂度为 O(n).
 */
public class GreatestSumOfSubArray {
    /**
     * 首先，在做动态规划时，我们最重要的一步，就是先创建一个和输入的array同长度的list/arraylist，
     * 用来记录到每一个元素时的最优解。所以这题我们可以分为下面几个步骤来做动态规划解法：
     *
     * 1.新建一个长度和输入数组相同的int[] dp， 我们会在这个list里存储:到每一个元素这里，
     * 我们此刻拥有的连续字数组的最大和。同时，我们需要定义这个list里的第一个数是array[0]，
     * 因为第一个数只能有自己，前面没有别的数来和他形成连续子数组了。同时，我们创建一个int max，来实时记录当前的最大和。
     * 2.遍历整个array，然后先新建一个int temp来储存当前遍历到的array[i]与前一位最大和的和，
     * 然后进行条件判断，如果这个temp大于当前的array[i]（即当前遍历到的数），我们就将temp储存
     * 入dp[i]，如果这个temp小于当前的array[i] (即如果我们只取当前这个数就已经比他加上原来所
     * 有的数都大了，我们便可以舍弃前面所有数，从这个数重新开始)，我们将array[i]储存进dp[i]里
     * 3.在2的遍历里，当我们走完上面的判断，我们还需要判断，当前的dp[i]是不是我们至今为止的最大
     * 和，如果是，更新我们前面创建的int max结束循环后，我们返回int max即可，这便是我们整个连续子数组的最大和
     */
    public int FindGreatestSumOfSubArray(int[] array) {
        if(array.length == 1){
            return array[0];
        }
        if(array == null){
            return 0;
        }
        int max = array[0];
        int[] dp = new int[array.length];
        dp[0] = array[0];
        for(int i = 1; i < array.length; i++){
            int temp = dp[i-1]+array[i];
            if(temp > array[i]){
                dp[i] = temp;
            }else{
                dp[i] = array[i];
            }
            if(dp[i] > max){
                max = dp[i];
            }
        }
        return max;
    }
}
