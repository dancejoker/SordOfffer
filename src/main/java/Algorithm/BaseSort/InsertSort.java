package Algorithm.BaseSort;

import java.util.Arrays;

public class InsertSort {
    public int[] sort(int[] sourceArray) {
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        for(int i =1;i< arr.length;++i){
            // 记录要插入的数据
            int tmp = arr[i];

            // 从已经排序的序列最右边的开始比较，找到比其小的数
            int j = i;
            while (j > 0 && tmp < arr[j - 1]) {
                arr[j] = arr[j - 1];
                j--;
            }

            // 存在比其小的数，插入
            if (j != i) {
                arr[j] = tmp;
            }
        }
        return arr;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{1,10,2,4,3,0,8,7,9};
        arr = new InsertSort().sort(arr);
        for(int i=0;i < arr.length;i++)
            System.out.print(arr[i] + ",");
    }
}
