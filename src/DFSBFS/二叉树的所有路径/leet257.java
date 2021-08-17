package Leet.DFSBFS.二叉树的所有路径;

import java.util.ArrayList;
import java.util.List;

public class leet257 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) return null;
        if (root.left == null && root.right == null) {
            res.add(root.val + "");
        }
        String nowList = String.valueOf(root.val);

        dfs(root, nowList, res, root.left);
        dfs(root, nowList, res, root.right);
        return res;
    }

    public void dfs(TreeNode root, String nowList, List<String> res, TreeNode sub) {
        if (sub == null) return;
        if (sub.left == null && sub.right == null) {
            nowList = nowList + "->";
            nowList = nowList + sub.val;
            res.add(new String(nowList));
            return;
        }
        nowList = nowList + "->";
        nowList = nowList + sub.val;
        dfs(root, nowList, res, sub.left);
        dfs(root, nowList, res, sub.right);

    }
}