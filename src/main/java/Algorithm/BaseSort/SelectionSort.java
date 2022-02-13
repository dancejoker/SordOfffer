package Algorithm.BaseSort;

import java.util.Arrays;

public class SelectionSort{
    public int[] sort(int[] sourceArray) {
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        for(int i=0; i < arr.length;++i){
            int min = i;
            for(int j = i+1;j<arr.length;++j){
                if(arr[min]>arr[j]){
                    min = j;
                }
            }
            if(min!=i){
                int tmp = arr[i];
                arr[i] = arr[min];
                arr[min] = tmp;
            }
        }
        return arr;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{1,10,2,4,3,0,8,7,9};
        arr = new SelectionSort().sort(arr);
        for(int i=0;i < arr.length;i++)
            System.out.print(arr[i] + ",");
    }
}
