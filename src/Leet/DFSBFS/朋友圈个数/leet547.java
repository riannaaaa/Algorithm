package Leet.DFSBFS.朋友圈个数;

public class leet547 {
    /*
     * 朋友圈个数
     */
    //DFS
    //步骤：
    //定义一个一维数组visited
    //遍历所有人
    //把第一个人的所有朋友找到然后标记为visited
    //只要遍历到没有被标记成visited的就res++
    class Solution {
        public int findCircleNum(int[][] isConnected) {
            int[] visited = new int[isConnected.length];
            int res = 0;
            for (int i = 0; i < isConnected.length; i++) {
                if (visited[i]==0) {
                    res++;
                    find(isConnected, i, visited);
                }
            }
            return res;
        }
        public static void find(int[][] isConnected,int i,int[] visited){
            visited[i]=1;//i1 = 0
            for (int i1 = 0; i1 < isConnected[0].length; i1++) {
                if(isConnected[i][i1]==1 && visited[i1]==0){
                    find(isConnected,i1,visited);//0 1 2
                }
            }
        }
    }
}
