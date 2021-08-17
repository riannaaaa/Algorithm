package Leet.DFSBFS.最短的桥;

import java.util.LinkedList;

public class leet934 {
//*   解题思路：先用深搜添加其中一个岛，然后对这个岛进行广搜，看多少层能够搜到下一个岛
//*   if(found)
//      break;要放对地方：放在外层循环
//* 	ans 放在最后再++
//* 	int[][] direction = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};

    public int shortestBridge(int[][] grid) {
        int[][] direction = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        int ans = 0;
        boolean found = false;
        LinkedList<int[]> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int i1 = 0; i1 < grid[0].length; i1++) {
                if(grid[i][i1]==1){
                    dfs(grid,i,i1,queue);
                    found=true;
                    break;
                }
            }
            if(found)
                break;
        }
        while (!queue.isEmpty()){ // while Q is non-empty
            int size = queue.size();
            for(int i=0;i<size;i++){
                int[] node = queue.poll();//    remove the head u of Q
                for(int j=0;j<4;j++){//    mark and enqueue all (unvisited) neighbours of u
                    int  nx = node[0]+direction[j][0];
                    int  ny = node[1]+direction[j][1];
                    if(nx<0||nx>=grid.length||ny<0||ny>=grid[0].length||grid[nx][ny]==2||grid[nx][ny]==3)    continue;
                    if(grid[nx][ny]==1)    return ans;
                    grid[nx][ny] = 3;//set visited
                    queue.add(new int []{nx,ny});
                }
            }
            ans++;
        }
        return ans;

    }
    public void dfs(int[][] grid,int i,int j,LinkedList<int[]> queue){
        if(i< 0 ||j< 0|| i>= grid.length|| j>=grid[0].length|| grid[i][j]!=1) {
            return;
        }
        grid[i][j]=2;
        queue.add(new int[]{i,j});
        dfs(grid,i-1,j,queue);
        dfs(grid,i+1,j,queue);
        dfs(grid,i,j+1,queue);
        dfs(grid,i,j-1,queue);
    }
}
