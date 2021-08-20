package  无分组.除自身以外数组的乘积;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class leet238 {
    public int[] productExceptSelf(int[] nums) {
        int[] L = new int[nums.length];
        int[] R = new int[nums.length];
        for (int i = 0; i < L.length; i++) {
            if(i==0){
                L[i] = 1;
                R[nums.length-1] = 1;
            }
            else {
                L[i] = L[i-1]*nums[i-1];
                R[nums.length-1-i] = R[nums.length-1-i+1]*nums[nums.length-1-i+1];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = L[i]*R[i];
        }
        return nums;
    }
    public static int minSwapsCouples(int[] row) {
        int res = 0;
        int nowI = 0;
        int nowSecond = 0;
        for (int i = 0; i < row.length - 1 ; i+=2) {
                nowI = row[i];
                nowSecond = row[i + 1];
                if (nowI % 2 == 0 && nowSecond != nowI + 1) {
                    //find i + 1;
                    for (int j = i + 1; j < row.length; j++) {
                        if (i < row.length - 1 && row[j] == nowI + 1) {
                            //swap
                            int tmp = row[i + 1];
                            row[i + 1] = row[j];
                            row[j] = tmp;
                            res += 1;
                        }
                    }
                }
                if (nowI % 2 == 1 && nowSecond != nowI - 1) {
                    //find i - 1;
                    for (int j = i + 1; j < row.length; j++) {
                        if (i < row.length - 1 && row[j] == nowI - 1) {
                            //swap
                            int tmp = row[i + 1];
                            row[i + 1] = row[j];
                            row[j] = tmp;

                            res += 1;
                            break;
                        }
                    }
                }

            }
        return res;
    }

    public static void main(String[] args) {
        int[] ex = new int[]{6,2,1,7,4,5,3,8,0,9};
        leet238.minSwapsCouples(ex);
    }

    public String simplifyPath(String path) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < path.length(); i++) {
            if (path.charAt(i) == '/' && Character.isAlphabetic(path.charAt(i + 1))) {

            }
        }
        return "";
    }

    public int singleNumber(int[] nums) {
        int a = 0;
        for (int i = 0; i < nums.length; i++) {
            a^=nums[i];
        }
        return a;
    }
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]<0)index = (-nums[i]+1);
            index = nums[i]-1;
            nums[index] = nums[index] * -1;
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]<0)list.add(i+1);
        }return list;

    }
}
