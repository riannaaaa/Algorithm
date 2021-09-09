package Sort;

public class insertSort {
    //insertSort 每次将当前元素插入到前面已经排好序的元素中
    public static void insertSort(int[] a){
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int temp = a[i];
            int j = i;
            for (; j > 0 && a[j] > temp; j--) {
                a[j] = a[j-1];
            }
            a[j] = temp;
        }
    }
}
