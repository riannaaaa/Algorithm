package 动态规划.背包.最小化目标值与所选元素的差;

import java.util.Arrays;
import java.util.HashSet;

public class leet1981 {
    //二维动态数组:dp状态定义F[i][j]表示前i行选完，能否凑出和为j的方案
    //转移就是F[i][j]=F[i-1][j-A[i][k]]，A[i][k]就是枚举的当前行所选物品
    //枚举第 i 行的每一个数x
    //f[i][j]←f[i−1][j−x]
    public int minimizeTheDifference1(int[][] mat, int target) {
        boolean[][] dp1 = new boolean[mat.length][4900];
        // int[] dp2 = new int[4900];
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < mat[0].length; i++) {
            dp1[0][mat[0][i]] = true;
        }
        for (int i = 1; i < mat.length; i++) {
            for (int j = 0; j < dp1[0].length; j++) {
                int num = 0;
                for (int k = 0; k < mat[0].length; k++) {
                    num = mat[i][k];
                    if (j - num >= 0)dp1[i][j] = dp1[i][j] || dp1[i - 1][j - num];
                }
            }
        }
        for (int i = 0; i < dp1[0].length; i++) {
            if (dp1[mat.length - 1][i]) {
                res = Math.min(res, Math.abs(target - i));
            }
        }
        return res;
    }
    //优化版本：把二维动态数组换成两个一维，因为f[i][j] 只会从f[i - 1][..]转移而来，因此我们可以使用两个一维数组代替该二维数组进行动态规划。
    public int minimizeTheDifference(int[][] mat, int target) {
        boolean[] dp1 = new boolean[4900];
        boolean[] dp2 = new boolean[4900];
        // int[] dp2 = new int[4900];
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < mat[0].length; i++) {
            dp1[mat[0][i]] = true;
        }
        for (int i = 1; i < mat.length; i++) {
            for (int j = 0; j < dp1.length; j++) {
                int num = 0;
                for (int k = 0; k < mat[0].length; k++) {
                    num = mat[i][k];
                    if (j - num >= 0)dp2[j] = dp2[j] || dp1[j - num];
                }
            }
            dp1 = Arrays.copyOf(dp2, dp2.length);
            dp2 = new boolean[4900];
        }
        for (int i = 0; i < dp1.length; i++) {
            if (dp1[i]) {
                res = Math.min(res, Math.abs(target - i));
            }
        }
        return res;
    }
    //非动态解法: HashSet
    public int minimizeTheDifference3(int[][] mat, int target) {
        int sum = 0, min = 0, max = 0;
        for (int i = 0; i < mat.length; i++) {
            int one_min  = Integer.MAX_VALUE, one_max = Integer.MIN_VALUE;
            for (int j = 0; j < mat[0].length; j++) {
                one_min = Math.min(mat[i][j], one_min);
                one_max = Math.max(mat[i][j], one_max);
            }
            min += one_min;
            max += one_max;

        }
        if (target >= max) {
            return Math.abs(max - target);
        }
        if (target <= min) {
            return Math.abs(min - target);
        }
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < mat[0].length; i++) {
            hashSet.add(mat[0][i]);
        }

        for (int i = 1; i < mat.length; i++) {
            HashSet<Integer> tmp = new HashSet<>();
            for (int j = 0; j < mat[0].length; j++) {


                for (Integer integer : hashSet) {
                    sum = integer + mat[i][j];
                    tmp.add(sum);

                }

            }
            hashSet = tmp;
        }

        for (Integer integer : hashSet) {
            min = Math.min(min, Math.abs(integer - target));
        }
        return  min;
    }

}
