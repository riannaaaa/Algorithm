package Leet.Greedy.划分字母区间;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leet763 {
    /*
     * 划分字母区间
     */
    class Solution {
        public List<Integer> partitionLabels(String s) {
            int[] num = new int[26];
            int index = 0;
            for(int i = 0; i< s.length(); i++){
                index = s.charAt(i)-'a';
                num[index] = i;
            }
            int thisLast = 0;
            int last = 0;
            System.out.println((Arrays.toString(num)));
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i< s.length(); i++){
                thisLast = num[s.charAt(i)-'a'];
                int j = i+1;
                int inside = 0;
                while(j<thisLast){
                    inside = num[s.charAt(j)-'a'];
                    thisLast = Math.max(thisLast,inside);
                    j++;
                }
                //last = thisLast+1;//last = 0, thisLast = 8;
                //这里转的慢了点，之前解析答案是外层while，里层for，所以last可以直接用里层的i代替
                list.add(thisLast-last+1);//last = 9;
                last = thisLast+1;
                i = thisLast;
            }
            return list;
        }
    }
}
