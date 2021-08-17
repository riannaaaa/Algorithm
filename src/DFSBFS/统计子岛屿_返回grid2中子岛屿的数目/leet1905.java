package Leet.DFSBFS.统计子岛屿_返回grid2中子岛屿的数目;

public class leet1905 {
    /*
     * 统计子岛屿：返回grid2中子岛屿的数目
     */
    //DFS
    //步骤：
    //1.遍历岛屿2，遇到1就调用dfs
    //dfs里：
    //1.首先判断无效位置(需要直接return的):if()return;
    //一般是包括边界外（4个｜｜）和数字元素不符合标准：
    // if(i<0||j<0||i>=grid2.length||j>=grid2[0].length||grid2[i][j]==0){
    //                return;
    //            }
    //2.标记已经遍历过的这个位置
    //3.四个方位调用dfs
    class Solution {
        static int flag;
        public int countSubIslands(int[][] grid1, int[][] grid2) {
            int res = 0;
            int grid1L = grid1.length;
            int grid1W = grid1[0].length;
            int grid2L = grid2.length;
            int grid2W = grid2[0].length;
            for (int i = 0; i < grid2L; i++) {
                for (int i1 = 0; i1 < grid1W; i1++) {
                    if(grid2[i][i1]==1){
                        flag = 1;
                        dfs(grid1,grid2,i,i1);
                        if(flag==1)res++;
                    }
                }
            }
            return res;
        }
        public static void dfs(int[][] grid1, int[][] grid2,int i, int j){
            if(i<0||j<0||i>=grid2.length||j>=grid2[0].length||grid2[i][j]==0){
                return;
            }
            if(grid1[i][j]==0){
                flag = 0;
            }
            grid2[i][j]=0;
            dfs(grid1,grid2,i+1,j);
            dfs(grid1,grid2,i-1,j);
            dfs(grid1,grid2,i,j+1);
            dfs(grid1,grid2,i,j-1);
        }
    }
}

