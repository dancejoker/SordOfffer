package Algorithm.DynamicProgramming;

/**
 * 描述
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，从同一个方向看总共有多少种不同的方法？
 */
public class RectangleCover {
    public int rectCover(int target) {
        if(target <= 0){
            return 0;
        }
        if(target == 1){
            return 1;
        }
        if(target == 2){
            return 2;
        }
        int first = 1;
        int second = 2;
        int result = 0;
        for(int i = 3; i <= target; i++){
            result = first + second;
            first = second;
            second = result;
        }
        return result;
    }
}
