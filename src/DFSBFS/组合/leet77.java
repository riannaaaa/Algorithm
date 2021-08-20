package DFSBFS.组合;

import java.util.ArrayList;
import java.util.List;

public class leet77 {

//组合 切割 子集 排列 棋盘
//一般情况回溯下无返回值
//    void backtracking(参数一般比较多){
//        if(终止){
//            收集结果;
//            return;
//        }
//        for(集合元素集(一般是所有元素or子节点)){
//            处理节点(一般是标记为已用)
//            递归函数
//            回溯操作(也就是撤销处理节点的操作)
//        }
//    }

// n=1,2,3,4 k=2
// output:[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//]
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>(){};
        List<Integer> nowResult = new ArrayList<>(){};
        int starkIndex = 1;
        backtracking(n,k,starkIndex,nowResult,res);
        return res;
    }

    public void backtracking(int n, int k,int startIndex,List<Integer> nowResult, List<List<Integer>> res ){
//    res 存放符合条件结果的集合
//    nowResult 用来存放符合条件结果
        if(nowResult.size()==k){
//            res.add(nowResult);
//上面注释的那一行会返回空([[], [], [], [], [], []])，因为传的是一个地址，但是每次回溯的时候都会根据地址删除元素。
            res.add(new ArrayList(nowResult));
            return;
        }
        for (int i = startIndex; i <= n; i++) {
            nowResult.add(i);
            backtracking(n,k,i+1,nowResult,res);
            nowResult.remove(nowResult.size()-1);
        }// nowResult 里面每次都加入这一轮递归中
    }
}
