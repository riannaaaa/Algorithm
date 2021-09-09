package Sort;

public class mergeSort {
    //mergeSort 递归 对两个有序节点序列进行合并来实现排序，分治思想
    //分解的方法
    public void mergeSort(int[] arr,int left,int right){
        //如果左边索引小于右边就可以一直分，l=r时，就是分到只剩一个数了
        if(left<right){
            int mid = (left + right) / 2;//左少右多
            //向左递归分解
            mergeSort(arr,left,mid);
            //向右递归分解
            mergeSort(arr,mid+1,right);
            //合并
            merge(arr,left,mid,right);
        }
    }

    //合并的方法
    /**
     *
     * @param arr 待排序的原始数组
     * @param left 左边有序序列的初始索引
     * @param mid 中间索引
     * @param right 右边结束索引
     * @return
     */
    public void merge(int[] arr, int left,int mid,int right) {
        int i = left;
        int j = mid +1;
        int[] temp = new int[right-left+1];//中转数组
        int t = 0;//temp数组的当前索引

        //合并数组，比较找最大
        while (i<=mid && j<=right){
            if(arr[i]<=arr[j])temp[t++] = arr[i++];
            else temp[t++] = arr[j++];
        }
        while (i<=mid) temp[t++] = arr[i++];
        while (j<=right) temp[t++] = arr[j++];

        //将temp数组拷贝到arr数组，并不是每次都拷贝所有
        t = 0;
        while (left<=right) arr[left++] = temp[t++];
    }
}
