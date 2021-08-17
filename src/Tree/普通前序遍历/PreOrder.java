package Leet.Tree.普通前序遍历;

import Leet.Tree.Morris遍历.Morris;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreOrder {
    public static List<Integer> preorderTraversal(Morris.TreeNode root) {
        Stack<Morris.TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();

        stack.push(root);
        System.out.println(root.val);
        while (!stack.empty()) {
            Morris.TreeNode treeNode = stack.pop();
            list.add(treeNode.val);
            if (treeNode.right != null) {
                stack.push(treeNode.right);
            }
            if (treeNode.left != null) {
                stack.push(treeNode.left);
            }
        }
        return list;
    }
}
