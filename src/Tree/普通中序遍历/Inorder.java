package Tree.普通中序遍历;

import Tree.Morris遍历.Morris;
import Tree.Morris遍历.Morris;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Inorder {
    //中序伪代码
    // list　midtravel(root){
    //    定义返回的数据结构
    //    stack
    //    node cur = root
    //    while(cur != null ｜｜ stack != null){
    //        if(cur != null){
    //            push(cur)
    //            cur = cur.left
    //        }
    //        else {
    //            cur = stack.pop
    //            list.add(cur)
    //            cur = cur.right
    //        }
    //    }
    // }一直把cur更新为left，只要left为空就pop然后把cur更新为pop出去的node的right

    public List<Integer> inorderTraversal(Morris.TreeNode head) {
        List<Integer> list = new ArrayList<>();
        if (head == null) {
            return list;
        }
        Morris.TreeNode cur = head;
        Stack<Morris.TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            Morris.TreeNode node = stack.pop();
            list.add(node.val);
            if (node.right != null) {
                cur = node.right;
            }
        }
        return list;
    }

}
