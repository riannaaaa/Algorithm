package Leet.分治.为运算表达式设计优先级;

import java.util.ArrayList;
import java.util.List;

public class leet241 {
//    本题解 采用了 分治 的思想：
//
//    遍历 字符串
//    遇到操作符，就将左右两边的字符串，分别当作 两个表达式
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> list = new ArrayList<>();
        if(expression.length()==0)return list;
        StringBuilder multibit = new StringBuilder();
        //check if all char are digit
        int j = 0;
        for (j = 0; j < expression.length(); j++) {
            if(Character.isDigit(expression.charAt(0))){
                while (j<expression.length()&&Character.isDigit(expression.charAt(j))){
                    multibit.append(expression.charAt(j));
                    j++;
                }
                if(j==expression.length()){
                    int num = Integer.parseInt(expression.substring(0,j));
                    list.add(num);
                    return list;
                } else break;
            }
        }
        for (int i = j; i < expression.length(); i++) {
            if(!Character.isDigit(expression.charAt(i))){
                String left = expression.substring(0,i);
                String right = expression.substring(i+1);
                List<Integer> l = diffWaysToCompute(left);
                List<Integer> r = diffWaysToCompute(right);
                if(expression.charAt(i)=='-') {
                    for (int i1 = 0; i1 < l.size(); i1++) {
                        for (int i2 = 0; i2 < r.size(); i2++) {
                            list.add(l.get(i1) - r.get(i2));
                        }
                    }
                }
                if(expression.charAt(i)=='+') {
                    for (int i1 = 0; i1 < l.size(); i1++) {
                        for (int i2 = 0; i2 < r.size(); i2++) {
                            list.add(l.get(i1) + r.get(i2));
                        }
                    }
                }
                if(expression.charAt(i)=='*'){
                    for (int i1 = 0; i1 < l.size(); i1++) {
                        for (int i2 = 0; i2 < r.size(); i2++) {
                            list.add(l.get(i1)*r.get(i2));
                        }
                    }
                }
            }
        }
        return list;
    }
}
