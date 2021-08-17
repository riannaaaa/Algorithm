package Leet.Greedy.分发饼干;

import java.util.Arrays;

public class leet455 {
    /*
     * 分发饼干
     * https://leetcode-cn.com/problems/assign-cookies/
     */
    class Solution {
        public int findContentChildren(int[] g, int[] s) {
            //两个array都要sort
            Arrays.sort(g);
            Arrays.sort(s);
            int res = 0;
            //两个array都要sort
            //孩子的数组要单独index
            int index = 0;
            for(int i = 0; i < s.length; i++){
                if(index<g.length&&s[i]>=g[index]){
                    res++;
                    index++;
                }
            }
            return res;
        }
    }

}
