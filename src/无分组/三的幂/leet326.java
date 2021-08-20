package  无分组.三的幂;

public class leet326 {
    public boolean isPowerOfThree(int n) {
        if(n<1){return false;}
        while (n%3==0){
            n=n/3;
        }
        return n==1;
    }
}
