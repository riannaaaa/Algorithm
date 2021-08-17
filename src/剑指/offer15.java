package 剑指;

import java.util.Arrays;

public class offer15 {
    /*
     * 二进制中1的个数
     */
    //笔记：
    //学到的Method:
    //1.String a = Integer.toBinaryString(n);
    //2.bitCount() 例子: int res = Integer.bitCount(n);
    public class Solution {
        // you need to treat n as an unsigned value
        public int hammingWeight(int n) {
            String a = Integer.toBinaryString(n);
            int res = 0;
            for(int i = 0; i<a.length();i++){
                if(a.charAt(i)=='1')res++;
            }
            return res;
        }
    }
    class Solution1 {
        public int findContentChildren(int[] g, int[] s) {
            Arrays.sort(g);
            Arrays.sort(s);
            int numOfChild = 0;
            int ChildIndex = 0;
            for (int i = 0; i < s.length; i++) {
                if(ChildIndex<g.length&&s[i]>=g[ChildIndex]){
                    numOfChild++;
                    ChildIndex++;
                }
            }
            return numOfChild;
        }
    }
}
