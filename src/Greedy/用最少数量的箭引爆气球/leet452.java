package Greedy.用最少数量的箭引爆气球;

import java.util.Arrays;

public class leet452 {
    /*
     * 用最少数量的箭引爆气球
     * https://leetcode-cn.com/problems/minimum-number-of-arrows-to-burst-balloons/
     */
    //学到的方法：
    //Arrays.sort(points,(o1, o2)->Integer.compare(o1[1],o2[1]));
    //用左边界也可以，这里用右边界是因为
    //使得每一支箭的射出位置都恰好对应着某一个气球的右边界。
    class Solution {
        public int findMinArrowShots(int[][] points) {
            Arrays.sort(points,(o1, o2)->Integer.compare(o1[1],o2[1]));
            int thisEnd = points[0][1];
            int res = 1;
            for(int i = 1; i< points.length;i++){
                if(points[i][0]>thisEnd){
                    res++;
                    thisEnd = points[i][1];
                }
                else{
                    thisEnd = Math.min(thisEnd,points[i][1]);
                }
            }
            return res;
        }
    }
}
