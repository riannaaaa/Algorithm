package 无分组.把字符串转换成整数;

public class Offer67 {
    //  1.   long res = 0;
    //
    //
    //	2.	用res存，每次*10
    //		ans = ans*10 +(str[i] - '0');
    //
    //	3.  java中的compareto方法，返回参与比较的前后两个字符串的asc码的差值，看下面一组代码
    //      e.g. String a="a",b="b";
    //      System.out.println(a.compareto.b);
    //	    即参与比较的两个字符串如果首字符相同，则比较下一个字符，直到有不同的为止
    public int strToInt(String str) {
        boolean isNegative = false;
        if (str.isEmpty()) return 0;
        long res = 0;
        for (int i = 0; i < str.length(); i++) {
            if (i == 0 && str.charAt(i) == ' ') {
                i++;
                while (i < str.length() && str.charAt(i) == ' ') i++;
            }
            if (i < str.length() && str.charAt(i) == '-') {
                isNegative = true;
                i++;
            }
            else if (i < str.length() && str.charAt(i) == '+') i++;
            if (i < str.length()  && !Character.isDigit(str.charAt(i))) return 0;
            else {
                while (i < str.length() && Character.isDigit(str.charAt(i))) {
                    res = res * 10 + str.charAt(i) - '0';
                    if (res > Integer.MAX_VALUE)
                        return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;

                    i++;
                }
                break;
            }
        }

        if (res == 0) return 0;


        return isNegative ? (int) ( 0 - res ) : (int) res;
    }
}
