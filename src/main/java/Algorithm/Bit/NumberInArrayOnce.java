package Algorithm.Bit;

/**
 * 数组中只出现一次的两个数字
 * 描述
 * 一个整型数组里除了两个数字只出现一次，其他的数字都出现了两次。
 * 请写程序找出这两个只出现一次的数字。
 */
public class NumberInArrayOnce {
    /**
     * 用异或^可解此题。
     * 但是首先要知道一个知识点，a^b^a = a^a^b = b^a^a =b，这个知识点也就是本题的简单版本：如果数组中除了某一个数字，
     * 其他数字都出现了两次，找出该数字。思路就是遍历数组，对每一个数字都求异或，最后得到的值就是要找的数字。
     * 有了该知识点的储备，再来看看本题。本题是要找两个数字a和b，那我们把该数组分成两个数组，
     * 其中a和一部分出现两次的数字在一块儿，b和另一部分出现两次的数字在一块儿，那这两个数组不是就变成了
     * 上面讲的那个简单版本中的数组吗？然后再分别对这两个数组求异或，就可以找到这两个数字了。
     * 举例：[a,2,2,3,3,b]。把该数组分成[a,2,2]和[3,3,b]，再对这两个数组求异或，便能得到a和b。
     *
     * 问题：怎么把a和b区分开来？
     * 可以利用二进制来区分。先对整个数组求异或得到c，根据上面的知识，可以知道c其实就是a^b=c。
     * 那么对于c，假如c二进制的第一位是1，其实就代表a二进制的第一位是1（或0），b二进制的第一位是0（或1），
     * 总而言之如果第一位的c等于1，那么a和b在第一位肯定不相等。
     * 所以我们就可以想到利用二进制的第一位（有可能是第二位，第三位 。。。因为上面是假设的c第一位是1）
     * 为1来区分两个数组，第一位为1的是数组一，第一位为0的是数组二。这样就相当于把a和b给区分开来了。
     * a和b区分开以后，剩下的就简单了，判断数组中其他数字的二进制的第一位是否为1，是的话就分到数组一，
     * 为0就分到数组二。最后对数组一和数组二分别进行异或，得到的就是a和b。
     * 有个地方没有讲清楚，利用二进制的第一位为1来区分两个数组，如果第一位不是1，
     * 那就判断第二位，第三位，一直到找到为1的地方。假设一直找到第n位才为1，
     * 那就判断数组中的其他数字的二进制的第n位是否为1，做&运算即可判断。
     */
    public int[] FindNumsAppearOnce (int[] array) {
        // write code here
        int res = 0; //对整个数组求异或的结果
        for(int i = 0;i<array.length;++i){
            res ^= array[i];
        }
        int compare = 1;
        while((compare & res)==0){ //判断异或结果的二进制第一位是否为1，为1则直接跳过该循环
            compare <<= 1; //为0则继续往后找，一直到找到为1的二进制位，该行代码也相当于compare *=2
        }
        int result1 = 0,result2 = 0;
        for(int i = 0;i<array.length;i++){ //遍历数组，开始判断数字们的compare位是否为1
            if((compare & array[i]) == 0){ //如果该数字二进制的第某位为0，则分到数组一
                result1 ^= array[i]; //对数组一进行异或，得到result1
            }else{                   //如果该数字二进制的第某位为1，则分到数组二
                result2 ^= array[i]; //对数组二进行异或，得到b
            }
        }
        return result1>result2 ? new int[]{result2,result1} : new int[]{result1,result2};
    }

    public static void main(String[] args) {
        NumberInArrayOnce numberInArrayOnce = new NumberInArrayOnce();
        System.out.println(numberInArrayOnce.FindNumsAppearOnce(new int[]{1,4,1,6}));

    }
}
