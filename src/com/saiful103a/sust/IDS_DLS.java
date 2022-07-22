package com.saiful103a.sust;

import com.saiful103a.sust.utils.Node;
import com.sun.tools.javac.util.List;

public class IDS_DLS
{
    private static void ids(Node currentNode, Node goalNode){
        int maxDepth = 5;
        for(int i=0;i<=maxDepth;i++){
            if(dfsDLS(currentNode, goalNode, 0, i)){
                System.out.println("Found with depth limit "+i);
            }else{
                System.out.println("Could not find with depth limit "+i);
            }
        }
    }
    private static boolean dfsDLS(Node currentNode, Node goalNode, int depth, int limit){
        if(currentNode==null){
            return false;
        }
        if(depth < limit){
            if(currentNode.val == goalNode.val){
                return true;
            }
            if(currentNode.getChildren()!=null) {
                for (Node node : currentNode.getChildren()) {
                    if(dfsDLS(node, goalNode, depth + 1, limit)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Node A = new Node('A');
        Node B = new Node('B');
        Node C = new Node('C');
        Node D = new Node('D');
        Node E = new Node('E');
        Node F = new Node('F');
        Node G = new Node('G');
        Node H = new Node('H');
        Node I = new Node('I');
        Node J = new Node('J');
        Node K = new Node('K');
        Node L = new Node('L');
        Node M = new Node('M');

        A.setChildren(
                List.of(B,C)
        );

        B.setChildren(
                List.of(D,E)
        );

        C.setChildren(
                List.of(F)
        );

        F.setChildren(
                List.of(I,K)
        );

        K.setChildren(
                List.of(M)
        );

        D.setChildren(
                List.of(G,H)
        );

        H.setChildren(
                List.of(L)
        );

        ids(A, H);
    }
}