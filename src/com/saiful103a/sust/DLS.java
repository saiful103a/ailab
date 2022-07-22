package com.saiful103a.sust;

import com.saiful103a.sust.utils.Node;
import com.sun.tools.javac.util.List;

public class DLS
{
    private static void dfsDLS(Node currentNode, Node goalNode, int depth, int limit){
        if(currentNode==null){
            return;
        }
        if(depth < limit){
            if(currentNode.val == goalNode.val){
                System.out.println("Found at depth "+(depth+1));
            }
            if(currentNode.getChildren()!=null) {
                for (Node node : currentNode.getChildren()) {
                    dfsDLS(node, goalNode, depth + 1, limit);
                }
            }
        }else{
            System.out.println("Depth crossed, current depth "+(depth+1));
        }
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

        dfsDLS(A, H, 0,3);

//        dfsDLS(A, H, 3);
    }
}