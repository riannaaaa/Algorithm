package 动态规划.最长公共子序列;

public class leet1143 {//带2个字符串的问题一般都伴随着动态规划的思路。这道题也可以递归。
//输入：text1 = "abcde", text2 = "ace"
//输出：3
//解释：最长公共子序列是 "ace" ，它的长度为 3 ；
    // 方法一：递归（虽然会超时）：
    // 两种情况：
    // 情况1.两个字符串第一个字母相同：这样只用递归各自剩下的substring
    // 情况2.两个字符串第一个字母不同：这样需要Math.max(text1.substring和text2完整字符串,text2.substring和text1完整字符串)
    // 方法二：dp
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        for (int i = 1; i < text1.length() + 1; i++) {
            for (int j = 1; j < text2.length() + 1; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1] + 1;
                else {
                    dp[i][j] = Math.max(dp[i][j - 1],dp[i - 1][j]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }
}
