package com.saiful103a.sust.utils;

public class AEdge {
    public double cost;
    public ANode target;

    public AEdge(ANode targetNode, double costVal){
        this.target = targetNode;
        this.cost = costVal;
    }
}
