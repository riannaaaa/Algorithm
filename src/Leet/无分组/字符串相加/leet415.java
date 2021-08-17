package Leet.无分组.字符串相加;

public class leet415 {
    public String addStrings(String num1, String num2) {//88 3
//        字符变数字result += num1.charAt(num1.length()-1)
//        **-'0';**
        StringBuffer res = new StringBuffer();
        int carry = 0;
        int result = 0;
        while (num1.length()>0||num2.length()>0||carry != 0){
            if(num1.length()>0)
            {result += num1.charAt(num1.length()-1)-'0';
                num1=num1.substring(0,num1.length()-1);}
            if(num2.length()>0)
            {result += num2.charAt(num2.length()-1)-'0';
                num2=num2.substring(0,num2.length()-1);}

            result += carry;
            carry = result/10;
            res.insert(0,result%10);
            result = 0;

        }
        return res.toString();
    }
}
