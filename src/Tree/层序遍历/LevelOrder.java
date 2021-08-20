package Tree.层序遍历;

import Tree.Morris遍历.Morris;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder {
    //    伪代码:
    //定义返回的数据结构res
    //检查root是不是空
    //设置queue
    //把root放上去
    //while(queue里面还有元素(不为空)){
    //    for (i = 1; queue里面还有元素.size){
    //    把现在queue里所有元素的sub元素都放进queue里:
    //    先poll出来放进result一维list里
    //    }
    //    把list放进res里
    //}
    // return res
    public List<List<Integer>> levelOrder(Morris.TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<Morris.TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int Levelsize = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 1; i <= Levelsize; i++) {
                Morris.TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            res.add(level);
        }
        return res;
    }
}
