package Leet.Tree.最大二叉树;

import Leet.Tree.Morris遍历.Morris;

import java.util.Arrays;

public class leet654 {

    /*
     * leet654 最大二叉树
     */
    public Morris.TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length == 0){
            return null;
        }
        if (nums.length == 1){
            return new Morris.TreeNode(nums[0]);
        }
        int max = 0, index = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }
        Morris.TreeNode node = new Morris.TreeNode(max);
        node.left = constructMaximumBinaryTree(Arrays.copyOfRange(nums,0,index));
        node.right = constructMaximumBinaryTree(Arrays.copyOfRange(nums,index+1,nums.length));
        return node;
    }
}
