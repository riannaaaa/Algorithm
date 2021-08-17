package Leet.无分组.计数质数;

import java.util.Arrays;

public class leet204 {
//* 注意审题
//* Arrays.fill(isPrimes,true);

    public int countPrimes(int n) {//[t,f,f,f,f,f,t,f,f,f]
        n=n-1;
        if(n<=0)return 0;
        int res = 0;
        boolean[] isPrimes = new boolean[n];
        Arrays.fill(isPrimes,true);
        for (int i = 2; i <= Math.sqrt(n); i++) {
            int mul = 0;
            int times = 2;
            mul = times*i;
            while(mul<=n){
                isPrimes[mul-1] = false;
                times++;
                mul = times*i;//忘了这一行
            }
        }

        for (int i = 1; i < isPrimes.length; i++) {
            if(isPrimes[i]){
                res++;
//                System.out.println(i);
            }
        }
        return res;
    }
}
