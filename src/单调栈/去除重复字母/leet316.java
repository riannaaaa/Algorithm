package Leet.单调栈.去除重复字母;

import java.util.Stack;

public class leet316 {

    //1.stack是有contains的方法
    //2.string是有indexOf(int,fromIndex)的方法
    public String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            if (stack.contains(s.charAt(i))){
                continue;
            }
            while (!stack.isEmpty() && s.charAt(i) < stack.peek() && s.indexOf(stack.peek(),i) != -1){
                stack.pop();
            }
            stack.push(s.charAt(i));
        }
        int size = stack.size();
        StringBuffer stringBuilder = new StringBuffer();
        for (int i = 0; i < size; i++) {
            stringBuilder.insert(0,stack.pop());
        }
        return stringBuilder.toString();
    }
    public static void main(String[] args) {
        System.out.println(new leet316().removeDuplicateLetters("bcbac"));
    }
}
