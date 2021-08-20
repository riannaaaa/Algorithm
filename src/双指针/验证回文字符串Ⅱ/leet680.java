package 双指针.验证回文字符串Ⅱ;

public class leet680 {
//    判断回文串 -> 双指针
//
//    第二个指针从右边开始
//
//    双指针就是while (low <= high)
    private int change = 0;
    public boolean validPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) == s.charAt(r)) {
                l++;
                r--;
            } else if (change == 0) {
                String stringBuilder = s.substring(l + 1, r + 1);
                String stringBuilder1 = s.substring(l, r);
                change++;
                return validPalindrome(stringBuilder1) || validPalindrome(stringBuilder);

            }
            else return false;
        } return true;
    }

}
