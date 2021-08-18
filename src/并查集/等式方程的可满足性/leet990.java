package 并查集.等式方程的可满足性;

public class leet990 {
//    输入：["a==b","b!=a"]
//    输出：false
    public boolean equationsPossible(String[] equations) {
        int length = equations.length;
        int[] parent = new int[26];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < length; i++) {
            if (equations[i].charAt(1) == '=') {
                int left = equations[i].charAt(0) - 'a';
                int right = equations[i].charAt(3) - 'a';
                union(left, right, parent);
            }
        }
        for (int i = 0; i < length; i++) {
            if (equations[i].charAt(1) == '!') {
                int left = equations[i].charAt(0) - 'a';
                int right = equations[i].charAt(3) - 'a';
                if (find(left,parent) == find(right,parent)) return false;
            }
        }
        return true;
    }
    public void union(int i, int j, int[] parent){
        int faI = find(i, parent);
        int faJ = find(j, parent);
        parent[faI] = faJ;
    }
    public int find(int i, int[] parent){
        if (parent[i] == i) return i;
        else {
            int fa = find(parent[i], parent);//路径压缩方式：完全压缩
            //「隔代压缩」的意思是：把从「查询结点」到「根结点」沿途经过的所有结点都指向根结点。「隔代压缩」相比较于「完全压缩」，压缩彻底。
            return fa;
        }
    }
}
