package Leet.Greedy.有效的括号字符串;

public class leet678 {
//方法：贪心算法
//https://leetcode.com/problems/valid-parenthesis-string/solution/
//lo、hi表示「可能多余的左括号」，一个下界，一个上界，很直观。执行起来就是
//
//遇到左括号：lo++, hi++
//遇到星号：lo--, hi++（因为星号有三种情况）
//遇到右括号：lo--, hi--
//lo要保持不小于0。（要理解lo的意思，考虑下这个例子(**)(
//如果hi < 0，说明把星号全变成左括号也不够了，False
//最後，如果lo > 0，说明末尾有多余的左括号，False

    public boolean checkValidString(String s) {
        int lo = 0,hi = 0, length = s.length();
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) =='(') {
                lo++;
                hi++;
            }
            else if (s.charAt(i) == ')') {
                if (lo > 0)
                    lo--;

                hi--;
            }
            else {
                hi++;
                if (lo > 0)
                    lo--;

            }
            if (hi < 0) return false;
        }
        if (lo != 0 || hi < 0) return false;
        return true;
    }
}
