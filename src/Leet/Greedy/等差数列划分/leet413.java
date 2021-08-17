package Leet.Greedy.等差数列划分;

public class leet413 {
    /*
     * 413. 等差数列划分
     */

//(1, 2, 3, 4, 5, 6)的时候,我们先取出前三个,
//(1, 2, 3)的等差数列的个数为1,
//(1, 2, 3, 4)的等差数列的个数为3,
//(1, 2, 3, 4, 5)的等差数列的个数为6,
//(1, 2, 3, 4, 5, 6)的等差数列个数为10

    public int numberOfArithmeticSlices(int[] nums) {
//[2,3,4,6,3] 长度为n的等差数列？
//[1,2,3,4] Leet.dp[]max length
        if (nums.length < 3) return 0;
        //int[] Leet.dp = new int[nums.length+1];
        int res = 0;
        int sub = 0;
        int difference = nums[1] - nums[0];
        int index = 2;
        boolean flag = true;
        while (flag) {//[1,2,3,4]
            while (index < nums.length && nums[index] - nums[index - 1] == difference) {
                index++;
                sub++;
                res += sub;
            }
            sub = 0;
            if (index > nums.length - 1) {
                flag = true;
                break;
            }
            difference = nums[index] - nums[index - 1];
            index++;//index最后再加

        }
        return res;
    }
}
