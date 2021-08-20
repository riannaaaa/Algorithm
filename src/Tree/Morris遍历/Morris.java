package Tree.Morris遍历;

import javax.swing.tree.TreeNode;
import java.util.*;

public class Morris {
    public static class TreeNode {

        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }


    //Morris遍历: 通过线索回归 然后就可以不用栈的结构储存元素
    //前序遍历
    //不好记的版本
    public List<Integer> MorrisPreorderTraversal1(TreeNode root) {
        //定义return数组
        //check输入是否为空：
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        //设置两个指针：
        TreeNode p1 = root;
        TreeNode p2 = null;
        //只要p1不为空：p2=p1.left
        while (p1 != null) {
            p2 = p1.left;
            //找前驱：
            if (p2 != null) {
                //不是空不是p1就往右找
                while (p2.right != null && p2.right != p1) {
                    p2 = p2.right;
                }
                //添加 right 指针，对应 right 指针为 null 的情况
                if (p2.right == null) {
                    list.add(p1.val);//？
                    p2.right = p1;//设置right为中节点
                    p1 = p1.left;//更新p1
                    continue;
                }
                //对应 right 指针存在的情况，则去掉 right 指针
                //上面continue了所以这里可以不用else
                p2.right = null;
            } else {//p1没有left了，为叶子结点
                list.add(p1.val);
            }
            p1 = p1.right;//找完左边找右边；

        }
        return list;

    }

    //中序遍历：
    //找到最左然后print
    //用link回溯，这时候又会找一次predecessor，然后check它的right发现是curr，这时候把link删掉然后打印curr-->此刻已经打完左和中，于是把curr=curr.right
    public List<Integer> MorrisInorderTraversal(TreeNode root) {
        //定义return数组
        //check输入是否为空：
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        TreeNode curr = root, predecessor = null;
        while (curr != null) {
            if (curr.left == null) {
                list.add(curr.val);
                curr = curr.right;
            } else {
                predecessor = curr.left;
                while (predecessor.right != null && predecessor.right != curr) {
                    predecessor = predecessor.right;
                }
                if (predecessor.right == null) {
                    predecessor.right = curr;
                    curr = curr.left;
                } else {// predecessor.right == curr)
                    predecessor.right = null;
                    list.add(curr.val);
                    curr = curr.right;
                }
            }
        }
        return list;
    }


}
