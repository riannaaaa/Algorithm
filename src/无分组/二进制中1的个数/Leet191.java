package  无分组.二进制中1的个数;

public class Leet191 {
    /*
     * 二进制中1的个数
     * https://leetcode-cn.com/problems/number-of-1-bits/submissions/
     */

    //输入是一个十进制
    //知识点: String a = Integer.toBinaryString(n);
    // you need to treat n as an unsigned value
    public static int hammingWeight(int n) {
        int ii = 0;
        String a = Integer.toBinaryString(n);

        if (a.length() > 32) {
            return 0;
        }
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == '1') {
                ii++;
            }
            ;
        }
        return ii;
    }

}
