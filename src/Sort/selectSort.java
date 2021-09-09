package Sort;

public class selectSort {
    //selectSort 每次将当前元素替换为后面最小的元素
    public static void selectSort(int[] a){
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i+1; j < N; j++) {
                if(a[j]<a[min]) min=j;
                int t =a[i];
                a[i] = a[j];
                a[j] = t;
            }
        }
    }

}
