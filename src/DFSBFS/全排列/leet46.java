package Leet.DFSBFS.全排列;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leet46 {
//    输入：nums = [1,2,3]
//    输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
    List<List<Integer>> res = new ArrayList<>() ;
    public List<List<Integer>> permute(int[] nums) {
        Arrays.sort(nums);
        List<Integer> cur = new ArrayList<Integer>();
        boolean[] visited = new boolean[nums.length];
        dfs(nums, cur, 0, visited);
        return res;
    }
    public void dfs(int[] candidates, List<Integer> cur, int index, boolean[] visited){
        if (index == candidates.length) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int i = 0; i < candidates.length; i++) {
            // if (!cur.isEmpty() && candidates[i] < cur.get(cur.size() - 1)) continue;
            if ( i > index && candidates[i] == candidates[i - 1] ) continue;
            if (!visited[i]) {
                visited[i] = true;
                cur.add(candidates[i]);
                dfs(candidates, cur,index + 1,visited);
                visited[i] = false;
                cur.remove(cur.size() - 1);
            }

        }
    }
}
