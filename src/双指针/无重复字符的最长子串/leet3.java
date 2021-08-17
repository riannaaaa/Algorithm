package Leet.双指针.无重复字符的最长子串;

public class leet3 {
    public int lengthOfLongestSubstring(String s) {
        int start = 0,end = 0,max = 0;
        int n = 2;
        int[] num = new int[256];
        while (end < s.length()) {
            if (num[(s.charAt(end))] > 0) {
                max = Math.max(end - start + 1,max);
                num[s.charAt(end)]++;
                end++;
                continue;
            }
            if (num[(s.charAt(end))] == 0 && n > 0) {
                n--;
                max = Math.max(end - start + 1,max);
                num[s.charAt(end)]++;
                end++;
                continue;
            }

            while (num[(s.charAt(start))] > 0 && n <= 0) {//ccaabb //eceb
                num[s.charAt(start)]--;
                if (num[(s.charAt(start))] == 0) n++;
                start++;
            }

        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new leet3().lengthOfLongestSubstring("ccaabbb"));
    }
}
