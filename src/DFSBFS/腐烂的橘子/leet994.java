package Leet.DFSBFS.腐烂的橘子;

import java.util.ArrayDeque;
import java.util.Queue;

public class leet994 {
    public int orangesRotting(int[][] grid) {
        //层序遍历 -> bfs
        int[] tmp = new int[2];
        Queue<int[]> queue = new ArrayDeque<>();
        int counter = 0,ans = -1;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    tmp[0] = (i);
                    tmp[1] = (j);
                    queue.offer(tmp);
                }
                if (grid[i][j] == 1) counter++;//表示新鲜的橘子个数
            }
        }
        int i = 0, j = 0, size = 0;
        while (!queue.isEmpty()) {
            size = queue.size();

            for (int i1 = 0; i1 < size; i1++) {
                int[] peek = queue.poll();
                i = peek[0];
                j = peek[1];
                grid[i][j] = 2;

                if (!(i + 1 >= grid.length || j >= grid.length || i + 1 < 0 || j < 0 || grid[i + 1][j] != 1)) {
                    counter--;
                    queue.offer(new int[]{i + 1, j});
                }
                if (!(i >= grid.length || j + 1 >= grid.length || i < 0 || j + 1 < 0 || grid[i][j + 1] != 1)){
                    counter--;
                    queue.offer(new int[]{i, j + 1});
                }
                if (!(i - 1 >= grid.length || j >= grid.length || i - 1 < 0 || j < 0 || grid[i - 1][j] != 1)){
                    counter--;
                    queue.offer(new int[]{i - 1, j});
                }
                if (!(i >= grid.length || j - 1 >= grid.length || i < 0 || j - 1 < 0 || grid[i][j - 1] != 1)){
                    counter--;
                    queue.offer(new int[]{i, j - 1});
                }
            }
            ans++;// ans 表示腐烂的轮数，或者分钟数
        }
        if (counter != 0) return -1;
        return ans;
    }
}
