package 无分组.七进制数;

public class leet504 {
    //StringBuilder的res.insert(0,"-")方法
    public String convertToBase7(int num) {
        if(num==0)return "0";
        boolean negative = true;
        if(num<0){
            num = 0 - num;
        }
        else negative = false;
        StringBuilder res = new StringBuilder();
        while (num>0){
            int bit = (num % 7);
            num = num/7;
            res.insert(0,bit);
        }
        if(negative)res.insert(0,"-");
        return res.toString();
    }
}
