package 单调栈.每日温度;

import java.util.Stack;

public class leet739 {

        public int[] dailyTemperatures(int[] temperatures) {
            int[] res = new int[temperatures.length];
            int index = 0;
            Stack<Integer> s = new Stack<>();
            for (int i = 0; i < temperatures.length; i++) {
                while (!s.isEmpty() && temperatures[i] > temperatures[s.peek()] ) {
                    index = s.pop();
                    res[index] = i - index;
                }
                s.push(i);
            }
            return res;
        }

    //单调栈
    //这道题存的是index，这样存的时候才能跳着存
}
