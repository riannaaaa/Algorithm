package Leet.Tree.从中序与后序遍历序列构造二叉树;

import Leet.Tree.Morris遍历.Morris;

import java.util.Arrays;

public class leet106 {
    public Morris.TreeNode buildTree(int[] inorder, int[] postorder) {
        int[] li = null;
        int[] lp = null;
        int[] ri = null;
        int[] rp = null;
        if(inorder.length == 0) return null;
        if(inorder.length == 1) return new Morris.TreeNode(inorder[0]);
        Morris.TreeNode node = new Morris.TreeNode(postorder[postorder.length - 1]);
        for (int i = 0; i < inorder.length; i++) {
            if(inorder[i] == node.val){
                li = Arrays.copyOfRange(inorder,0,i );
                lp = Arrays.copyOfRange(postorder,0,i );
                ri = Arrays.copyOfRange(inorder,i + 1,inorder.length);
                rp = Arrays.copyOfRange(postorder,i ,inorder.length - 1);
                break;
            }
        }
        node.left = buildTree(li,lp);
        node.right = buildTree(ri,rp);
        return node;

    }
}
