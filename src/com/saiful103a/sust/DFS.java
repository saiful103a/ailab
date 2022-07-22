package com.saiful103a.sust;

import com.saiful103a.sust.utils.TreeNode;

import java.util.ArrayDeque;

public class DFS {
    private static void preOrder(TreeNode root){
        if(root==null){
            return;
        }
        System.out.println(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }

    private static void inOrder(TreeNode root){
        if(root==null){
            return;
        }
        inOrder(root.left);
        System.out.println(root.val);
        inOrder(root.right);
    }

    private static void postOrder(TreeNode root){
        if(root==null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.val);
    }

    public static void main(String[] args) {
        preOrder(
                new TreeNode(1, new TreeNode(2),new TreeNode(3))
        );
        inOrder(
                new TreeNode(1, new TreeNode(2),new TreeNode(3))
        );
        postOrder(
                new TreeNode(1, new TreeNode(2),new TreeNode(3))
        );
    }
}
