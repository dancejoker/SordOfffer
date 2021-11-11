package Algorithm.Sort;

import java.util.HashSet;

/**
 数组中重复的数字
 描述
 在一个长度为n的数组里的所有数字都在0到n-1的范围内。
 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。
 请找出数组中任一一个重复的数字。 例如，如果输入长度为7的数组[2,3,1,0,2,5,3]，
 那么对应的输出是2或者3。存在不合法的输入的话输出-1
 */
public class DuplicateNumber {
    public int duplicate (int[] numbers) {
        // write code here
        HashSet<Integer> hashSet = new HashSet<Integer>();
        for(int i = 0;i<numbers.length;++i){
            if(hashSet.contains(numbers[i])){
                return numbers[i];
            }else {
                hashSet.add(numbers[i]);
            }
        }
        return  -1;
    }
}
