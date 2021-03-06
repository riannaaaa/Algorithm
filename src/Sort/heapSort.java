package Sort;

public class heapSort {
    //heapSort 构建大顶堆或者小顶堆，将堆顶元素与堆尾元素交换后再调整，如此反复
    public void heapSort(int[] arr){
        //构建大顶堆 k为最后一个非叶子节点，逐渐-1，即从下向上，从右往左
        for(int k = arr.length/2 - 1;k>=0;k--){
            adjustHeap(arr,k,arr.length);
        }

        //排序 交换+调整
        int temp =0;
        for (int i = arr.length-1; i >= 0; i--) {
            temp =arr [0];
            arr[0] = arr[i];
            arr[i] = temp;
            adjustHeap(arr,0,i);
        }
    }

    /**
     *
     * @param arr 待调整数组
     * @param i 非叶子节点在数组中的索引
     * @param length 对多少个元素进行调整
     */
    public void adjustHeap(int[] arr,int i,int length){
        int temp = arr[i];//取出当前非叶子叶结点的值
        //k为当前节点的左子节点
        for(int k = 2*i+1;k<length;k=2*k+1){
            if(k+1<length && arr[k+1]>arr[k]){//右子节点大于左子节点
                k++;//k指向右子节点
            }
            if(arr[k]>temp){//如果当前节点大于父节点就交换
                arr[i] = arr[k];
                i =k;//!!!!!!精髓，因为该子节点值大小发生了改变，可能会使其子根堆发生改变，索引要调整其子根堆
            }else {
                break;//否则直接退出，因为其后面的节点一定满足堆定义
            }
        }
        arr[i] = temp;
    }
}
