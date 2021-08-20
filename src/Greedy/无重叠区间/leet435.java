package Greedy.无重叠区间;

import java.util.Arrays;

public class leet435 {
    /*
     * 无重叠区间
     * https://leetcode-cn.com/problems/non-overlapping-intervals/
     */
    //学到的方法：
    // Arrays.sort(intervals, (o1, o2) -> (o1[0] - o2[0]));
    class Solution {
        public int eraseOverlapIntervals(int[][] intervals) {
            Arrays.sort(intervals, (o1, o2)->(o1[0]-o2[0]));
            int thisEnd = intervals[0][1];
            int nextBegin = 0;
            int res = 0;
            for(int i = 1;i < intervals.length;i++)
            {
                nextBegin = intervals[i][0];
                if(nextBegin>=thisEnd){
                    thisEnd = intervals[i][1];
                }
                else {
                    thisEnd = Math.min(thisEnd,intervals[i][1]);
                    res++;
                }

            }
            return res;
        }
    }
}
