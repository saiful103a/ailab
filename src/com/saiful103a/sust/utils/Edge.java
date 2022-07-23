package com.saiful103a.sust.utils;

public class Edge implements Comparable<Edge>
{
    public char v;
    public int cost;

    public Edge(char v, int cost)
    {
        this.v = v;
        this.cost = cost;
    }

    @Override public int compareTo(Edge o)
    {
        if (o.cost < cost) {
            return 1;
        }
        else
            return -1;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "v=" + v +
                ", cost=" + cost +
                '}';
    }
}