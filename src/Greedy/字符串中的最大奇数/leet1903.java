package Greedy.字符串中的最大奇数;

public class leet1903 {
    /*
     * 字符串中的最大奇数
     */
    public String largestOddNumber(String num) {
        int index = -1;
        for(int i =num.length()-1; i >=0 ;i--){
            if(Integer.parseInt((num.charAt(i))+"")%2!=0){
                index = i;
                break;
            }
        }
        if(index==-1) {return "";}
        return num.substring(0,index+1);
    }
}
