package Leet.快速幂.统计好数字的数目;

public class leet1922 {
    static final int mod = (int) (Math.pow(10, 9) + 7);
    public static long power(int num, long pow) { //2 6 //快速幂
        long res1 = 1;
        long res = num;
        while (pow > 0) { //只要碰到奇数就把res乘过去
            if (pow % 2 != 0) res1 = res1 * res % mod;
            res = res * res % mod; //4 16
            pow = pow / 2;//3 1
        }
        return res1 % mod;
    }
    public static int countGoodNumbers(long n) {
        long oddNum = 0, evenNum = 0;
        if (n == 1) return 5;
        oddNum = (long) (n / 2);
        evenNum = (long) n - oddNum;
        return (int) (power(5, evenNum) * power(4, oddNum) % mod);
    }
}
