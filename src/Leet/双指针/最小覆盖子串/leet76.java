package Leet.双指针.最小覆盖子串;

import java.util.HashMap;

public class leet76 {
    //待码
    public String minWindow(String s, String t) {
        char first = 'a';
        int[] res = new int[2];
        int l = 0, r = 0;
        boolean found = false;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int j = 0; j < s.length(); j++) {
            map.put(s.charAt(j), 0);
        }
        while (r < s.length()) {
            int index = s.indexOf(s.charAt(r) + "");
            if (index == -1) {
                r++;
                continue;
            }
            if (found) {
                if (map.get(s.charAt(r)) > 0) {

                } else {
                    r++;

                }

            } else {
                first = s.charAt(r);
                found = true;
            }
        }
        // int[] Leet.dp = new int[s.length];
        // for (int i = 0; i < s.length; i++) {

        // }
        return "";
    }
}
