package Leet.DFSBFS.岛屿的最大面积;

public class leet695 {
    /*
     * 岛屿的最大面积
     */
    //DFS
    //步骤：
    //1.还是遍历每个元素，碰到1就开始调用dfs
    //dfs里：
    //1.首先判断无效位置(需要直接return的):if()return;
    //一般是包括边界外（4个｜｜）和数字元素不符合标准：
    // if(i<0||j<0||i>=grid2.length||j>=grid2[0].length||grid2[i][j]==0){
    //                return;
    //            }
    //2.标记已经遍历过的这个位置
    //3.四个方位调用dfs

    public int maxAreaOfIsland(int[][] grid) {
        if (grid.length == 0) return 0;
        int maxNum = 0;
        int maxThis = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int i1 = 0; i1 < grid[0].length; i1++) {
                if (grid[i][i1] != 0) {
                    maxThis = max(grid, i, i1);
                    maxNum = Math.max(maxNum, maxThis);
                }
            }
        }
        return maxNum;
    }

    public static int max(int[][] grid, int i, int i1) {
        int res = 1;
        if (i < 0 || i1 >= grid[0].length || i1 < 0 || i >= grid.length || grid[i][i1] == 0)
            return 0;
        grid[i][i1] = 0;
        res += max(grid, i - 1, i1) + max(grid, i + 1, i1) + max(grid, i, i1 - 1) + max(grid, i, i1 + 1);
        return res;
    }
}

