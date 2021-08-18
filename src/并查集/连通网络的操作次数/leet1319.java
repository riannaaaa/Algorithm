package 并查集.连通网络的操作次数;

public class leet1319 {
    //输入：n = 4, connections = [[0,1],[0,2],[1,2]]
    //输出：1
    //解释：拔下计算机 1 和 2 之间的线缆，并将它插到计算机 1 和 3 上。
    //链接：https://leetcode-cn.com/problems/number-of-operations-to-make-network-connected
    public int makeConnected(int n, int[][] connections) {
        int rest = 0;
        int length = connections.length;
        int[] parent = new int[n];

        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < length; i++) {
            int left = connections[i][0];
            int right = connections[i][1];
            if (find(left,parent) == find(right,parent))
                rest++;
            else
                union(left, right, parent);
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (parent[i] == i) {
                rest--;
                res++;
            }
        }
        return rest >= -1 ? res - 1 : -1;
    }
    public void union(int i, int j, int[] parent){
        int faI = find(i, parent);
        int faJ = find(j, parent);
        if (faI == faJ) return;
        parent[faI] = faJ;
    }
    public int find(int i, int[] parent){
        if (parent[i] == i) return i;
        else {
            int fa = find(parent[i], parent);
            return fa;
        }
    }
}
