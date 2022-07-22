package com.saiful103a.sust.utils;

import java.util.List;

public class Node {
    public char val;
    public List<Node> nodes;
    public Node(char val){
        this.val = val;
    }
    public void setChildren(List<Node> nodes) {
        this.nodes =  nodes;
    }
    public List<Node> getChildren() {
        return nodes;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                ", nodes=" + nodes +
                '}';
    }
}
