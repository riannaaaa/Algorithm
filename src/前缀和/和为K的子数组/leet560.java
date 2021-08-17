package Leet.前缀和.和为K的子数组;

import java.util.HashMap;

public class leet560 {
    /*
     * 和为K的子数组
     */
    public int subarraySum(int[] nums, int k) {
        if (nums.length == 1) return nums[0] = k;
        HashMap<Integer,Integer> map = new HashMap<>();
        int res = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (!map.containsKey(sum)) {
                map.put(sum, 1);
            }
            if (sum == k) res++;
            int times = map.get(sum) + 1;
            map.put(sum, times);
            if (map.containsKey(sum - k)) {
                res+=map.get(sum - k);
            }
        }
        System.out.println(map.toString());
        return res;
    }

    public int countSubstrings(String s) {
        int res = 0;
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = s.length() - 1; i > -1; i--) {
            for (int j = i; j < s.length(); j++) {
                if (j == i) {
                    dp[i][j] = true;
                    res++;
                }
                else
                if (j-i == 1) {
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                    if (dp[i][j]) res++;
                }

                else {
                    dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1];
                    if (dp[i][j]) res++;
                }
                }
            }
            return res;
        }

    public boolean isIsomorphic(String s, String t) {
        for(int i = 0 ; i < s.length(); ++i){
            if(s.indexOf(s.charAt(i))!=t.indexOf(t.charAt(i))){
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(new leet560().countSubstrings("abcd"));
//        System.out.println(new leet560().strStr("abcd","cd"));
    }
    }

