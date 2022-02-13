package Algorithm.BaseSort;

import java.util.Arrays;
//冒泡排序
public class BubbleSort {
    public int[] sort(int[] sourceArray){
        // 对 arr 进行拷贝，不改变参数内容
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        for(int i = 0;i < arr.length;++i){
            boolean flag = true;
            for(int j=0;j < arr.length - i - 1;++j){
                if(arr[j] > arr[j+1]){
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                    flag = false;
                }
            }
            if(flag){
               break;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,10,2,4,3,0,8,7,9};
        arr = new BubbleSort().sort(arr);
        for(int i=0;i < arr.length;i++)
            System.out.print(arr[i] + ",");
    }
}
