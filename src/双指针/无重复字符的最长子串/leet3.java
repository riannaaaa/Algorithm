package 双指针.无重复字符的最长子串;

public class leet3 {
    //最长子串问题：想到滑动窗口
    public int lengthOfLongestSubstring(String s) {
        //滑动窗口+数组存是否出现过
        //注意事项：空格是在'a'之前的，存数组的时候不用 - 'a'
        if (s.length() <= 1) return s.length();
        int l = 0;
        int r = 0;
        int max = 0;
        int[] found = new int[256];
        while (r < s.length()) {
            char nowNew = s.charAt(r);
            if (found[nowNew] == 0) {
                max = Math.max(max, r - l + 1);
                found[nowNew]++;
                r += 1;
            }
            else {
                char nowLeftMost = s.charAt(l);
                found[nowLeftMost]--;
                l += 1;
            }
        }
        return max;
    }


    public static void main(String[] args) {
        System.out.println(new leet3().lengthOfLongestSubstring("ccaabbb"));
    }
}
