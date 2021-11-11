package Algorithm.Search;

/**
 * 描述
 * 有一个长度为 n 的非降序数组，比如[1,2,3,4,5]，将它进行旋转，
 * 即把一个数组最开始的若干个元素搬到数组的末尾，变成一个旋转数组，
 * 比如变成了[3,4,5,1,2]，或者[4,5,1,2,3]这样的。
 * 请问，给定这样一个旋转数组，求数组中的最小值。
 */
public class minNumberRotateArray {
    public int minNumberInRotateArray(int [] array) {
        if(array == null || array.length==0)
            return 0;
        int low = 0;
        int high = array.length-1;
        int mid = low;
        while(array[low]>=array[high]){
            if(array[low] == array[high]){

                for(int i=low;i<array.length;i++){
                    if(array[low]!=array[i]){
                        low = i-1;
                        break;
                    }
                }
                for(int i=high;i>=0;i--){
                    if(array[high]!=array[i]){
                        high = i+1;
                        break;
                    }
                }
            }
            if(high-low<=1){
                mid = high;
                break;
            }
            mid = (low+high)>>1;
            if(array[mid]>=array[low]){
                low = mid;
            }else if(array[mid]<=array[high]){
                high = mid;
            }
        }
        return array[mid];
    }
}
