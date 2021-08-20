package 动态规划.n个骰子的点数;

public class Offer60 {

    //二维数组dp
    //不要只想着存概率
    //可以交换ij优化
    public static double[] dicesProbability(int n) {
        double[] res = new double[5 * n + 1];

        double tmp = Math.pow(6,n);
        double[][] dp = new double[6 * n + 1][n + 1];
        dp[1][1] = 1;
        dp[2][1] = 1;
        dp[3][1] = 1;
        dp[4][1] = 1;
        dp[5][1] = 1;
        dp[6][1] = 1;
        for (int j = 2; j < dp[0].length; j++) {
            for (int i = j; i < dp.length; i++) {

                if (i - 1 > 0) dp[i][j] += dp[i - 1][j - 1];
                if (i - 2 > 0) dp[i][j] += dp[i - 2][j - 1];
                if (i - 3 > 0) dp[i][j] += dp[i - 3][j - 1];
                if (i - 4 > 0) dp[i][j] += dp[i - 4][j - 1];
                if (i - 5 > 0) dp[i][j] += dp[i - 5][j - 1];
                if (i - 6 > 0) dp[i][j] += dp[i - 6][j - 1];

            }
        }
        for (int i = n; i < n + res.length; i++) {
            res[i - n] = dp[i][n]/tmp;
        }
        return res;
    }
}
