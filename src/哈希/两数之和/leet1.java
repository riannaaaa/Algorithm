package 哈希.两数之和;

import java.util.HashMap;

public class leet1 {
    //两数之和：
    //方法一：暴力解法：双层loop
    //方法二：哈希表：把元素和对应index记录下来；
    //学习：
    //1. hashmap的containsKey和containsValue方法
    //2. 我一开始因为考虑到key不能重复，选择了把index放在key的初始化方法，但是
    //   hashmap的get只能用key get value，所以key应该是元素，value是要找的index
    //   好在其实这道题不用担心数字重复（key重复也是存在）。
    HashMap<Integer,Integer> map = new HashMap<>();
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int[] res = new int[2];
        int elementNow = 0;
        for (int i = 0; i < nums.length; i++) {
            elementNow = nums[i];
            if (map.containsKey(target - elementNow)) {
                res[0] = i;
                res[1] = map.get(target - elementNow);
                return res;
            }
            map.put(nums[i],i);
        }
        return res;
    }
}
