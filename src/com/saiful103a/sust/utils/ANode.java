package com.saiful103a.sust.utils;

public class ANode {
    public String value;
    public double gOfN;
    public double hOfN;
    public double fOfN = 0;
    public AEdge[] edges;
    public ANode parent;
    public ANode(String value, double heuristicValue){
        this.value = value;
        this.hOfN = heuristicValue;
    }
    public String toString(){
        return value;
    }
}
