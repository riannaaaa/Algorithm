package Sort;

public class quickSort {
    //quickSort 每次选择一个元素并且将整个数组以这个元素分为两部分，小于该元素的放右边，大于该元素的放左边
    public void quickSort(int[] arr,int l,int r){
        if(l<r){ //跳出递归的条件
            //partition就是划分操作，将arr划分成满足条件的两个子表
            int pivotpos = partition(arr,l,r);
            //依次对左右两个子表进行递归排序
            quickSort(arr,l,pivotpos);
            quickSort(arr,pivotpos+1,r);
        }
    }

    public int partition(int[] arr,int l,int r){
        //以当前数组的最后一个元素作为中枢pivot，进行划分
        int pivot = arr[r];
        while (l<r){
            while (l<r && arr[l]<pivot) l++;
            arr[r] = arr[l];//将比中枢值大的移动到右端r处 由于r处为中枢或者该位置值已经被替换到l处，所以直接可以替换
            while (l<r && arr[r]>=pivot) r--;
            arr[l] = arr[r];//将比中枢值小的移动到左端l处 由于前面l处的值已经换到r处，所以该位置值也可以替换掉
        }
        //l==r时，重合，这个位置就是中枢的最终位置
        arr[l] = pivot;
        //返回存放中枢的最终位置
        return l;
    }
}
