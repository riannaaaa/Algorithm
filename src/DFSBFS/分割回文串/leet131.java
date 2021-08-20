package DFSBFS.分割回文串;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leet131 {
    /*
     * 分隔回文串
     */
    //动态规划.dp+DFS(回溯)
    //回溯：** 基于上一次选择，而来到的节点可能有不同的选择，用 for 枚举出来，结合约束条件剪枝**
    //步骤：
    //dp数组记录string[i-->j]是否回文(leet5)
    //遍历二维数组一半的方式：
    //1. i倒着；j正着
    //i=length-1;i--
    //j = i;j++
    //
    //dfs+回溯：
    //遍历string，是回溯就放进list(全排列)
    //注意代码缩进；格式化

    public List<List<String>> partition(String s) {
        List<String> list1 = new ArrayList<>();
        List<List<String>> res = new ArrayList<>();
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = s.length() - 1; i > -1; i--) {
            for (int j = 0; j < s.length(); j++) {
                if (i > j) {
                    dp[i][j] = false;
                } else if (i == j) {
                    dp[i][j] = true;
                }//1-2
                else if (j - i == 1 && s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = true;
                } else {
                    dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1];
                }

            }
        }
        System.out.println(Arrays.deepToString(dp));//aab
        dfs(dp, s, 0, res, list1);
        //a    a     b
        //  [[true, true, false],
        //  [false, true, false],
        //  [false, false, true]]
        return res;
    }//falae  aabbcc-> aa bb cc; aabb cc

    public void dfs(boolean[][] dp, String s, int i, List<List<String>> res, List<String> list) {
        if (i == s.length()) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int j = 1; i + j - 1 < s.length(); j++) {//j是长度
            if (dp[i][i + j - 1]) {
                list.add(s.substring(i, i + j));
                dfs(dp, s, i + j, res, list);
                list.remove(list.size() - 1);
            }
        }

    }
}

