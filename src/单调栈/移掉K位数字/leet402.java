package 单调栈.移掉K位数字;

import java.util.Stack;

public class leet402 {

    public String removeKdigits(String num, int k) {
        int length = num.length() - k;
        Stack<Character> s = new Stack();
        StringBuilder res = new StringBuilder();
        int index = 0;
        while (index < num.length() && k >= 0) {
            while (!s.isEmpty() && s.peek() > num.charAt(index)) {
                s.pop();
                k--;
            }
            s.push(num.charAt(index));
            index++;
        }
        for (int i = 0; i < s.size(); i++) {
            res.insert(0,s.pop());
        }
        String ss = res.toString();
        while (ss.charAt(0) == '0') ss = ss.substring(1);
        return ss;
    }

    public static void main(String[] args) {
        new leet402().removeKdigits("12542328",4);
    }
}
