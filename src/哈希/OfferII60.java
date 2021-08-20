package 哈希;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OfferII60 {
    // 用到了哈希和桶排序
    // 1. list.sort((o1, o2) -> o2.getValue() - o1.getValue());
    //    注意是降序
    // 2. HashMap 换成 List
    // 3. List<Map.Entry<Integer, Integer>> list = new ArrayList<Map.Entry<Integer, Integer>>(
    //    tong.entrySet());
    public int[] topKFrequent(int[] nums, int k) {
// 用哈希就不用找最大最小值了:
//        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
//        for (int i = 0; i < nums.length; i++) {
//            if (max < nums[i]) max = nums[i];
//            if (min > nums[i]) min = nums[i];
//        }
        HashMap<Integer, Integer> tong = new HashMap<>();//key value: num,频率
        for (int i = 0; i < nums.length; i++) {
            if (tong.containsKey(nums[i])) {
                int num = tong.get(nums[i]);
                tong.put(nums[i], num + 1);
            }
            else
                tong.put(nums[i], 1);
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<Map.Entry<Integer, Integer>>(
                tong.entrySet());
        list.sort((o1, o2) -> o2.getValue() - o1.getValue());
        int[] res = new int[k];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i).getKey();
        }
        return res;
    }
}
