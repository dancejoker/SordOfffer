package Algorithm.Search;

/**
 * 描述
 * 给定一个长度为 n 的非降序数组和一个非负数整数 k ，要求统计 k 在数组中出现的次数
 */
public class CheckNum {
    public int GetNumberOfK(int [] array , int k) {
        if(array == null || array.length == 0) return 0;
        int count = 0;
        int start =0,end=array.length-1;
        while(start <= end){
            int mid = (start + end) >> 1;
            if(array[mid] > k){
                end = mid - 1;
            }else if(array[mid] < k){
                start = mid + 1;
            }else{
                count++;
                int l = mid -1;
                int r = mid + 1;
                while(l >= 0 && array[l] == k){
                    count ++;
                    l--;
                }
                while(r < array.length && array[r] == k){
                    count++;
                    r++;
                }
                break;
            }
        }

        return count;
    }
}
