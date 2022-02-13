package Algorithm.BaseSort;

//希尔排序
public class shellSort {
    public int[] sort(int[] arr) {
        int length = arr.length;
        int temp;
        for (int step = length / 2; step >= 1; step /= 2) {
            for (int i = step; i < length; i++) {
                temp = arr[i];
                int j = i - step;
                boolean flag = false;
                while (j >= 0 && arr[j] > temp) {
                    arr[j + step] = arr[j];
                    j -= step;
                    flag = true;
                }
                if (flag) {
                    arr[j + step] = temp;
                }
            }
        }
        return arr;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{1,10,2,4,3,0,8,7,9};
        arr = new shellSort().sort(arr);
        for(int i=0;i < arr.length;i++)
            System.out.print(arr[i] + ",");
    }
}
