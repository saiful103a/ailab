package com.saiful103a.sust;

import com.saiful103a.sust.utils.TreeNode;

import java.util.ArrayDeque;

public class BFS {
    private static void bfs(TreeNode root){
        if(root==null){
            return;
        }
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            System.out.println(node.val);
            if(node.left!=null){
                queue.offer(node.left);
            }
            if(node.right!=null){
                queue.offer(node.right);
            }
        }
    }

    public static void main(String[] args) {
        bfs(
                new TreeNode(1, new TreeNode(2),new TreeNode(3))
        );
    }
}
