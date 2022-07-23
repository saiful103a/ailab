package com.saiful103a.sust;

import com.saiful103a.sust.utils.Edge;

import java.util.*;

class GreedyBFS
{
    private Map<Character, ArrayList<Edge>> adjList;
    public GreedyBFS()
    {
        adjList = new HashMap<>();
    }

    //Best First Search
    public void bfs(char sourceNode, char targetNode)
    {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        Set<Character> visited = new HashSet<>();
        visited.add(sourceNode);
        pq.add(new Edge(sourceNode, -1));

        while (!pq.isEmpty()) {
            char currentNode = pq.poll().v;
            // Displaying the path having the lowest cost
            System.out.print(currentNode + " ");
            if (targetNode == currentNode) {
                break;
            }
            for (Edge adjacentNodeEdge : adjList.getOrDefault(currentNode, new ArrayList<>())) {
                if(!visited.contains(adjacentNodeEdge.v)){
                    visited.add(adjacentNodeEdge.v);
                    pq.add(adjacentNodeEdge);
                }
            }
        }
    }

    public void addEdge(char u, char v, int cost)
    {
        adjList.putIfAbsent(u, new ArrayList<>());
        adjList.putIfAbsent(v, new ArrayList<>());

        adjList.getOrDefault(u, new ArrayList<>()).add(new Edge(v, cost));
        adjList.getOrDefault(v, new ArrayList<>()).add(new Edge(u, cost));
    }

    public static void main(String[] args)
    {
        GreedyBFS graph = new GreedyBFS();
        graph.addEdge('S', 'A', 3);
        graph.addEdge('S', 'B', 6);
        graph.addEdge('S', 'C', 5);
        graph.addEdge('A', 'D', 9);
        graph.addEdge('A', 'E', 8);
        graph.addEdge('B', 'F', 12);
        graph.addEdge('B', 'G', 14);
        graph.addEdge('C', 'H', 7);
        graph.addEdge('H', 'I', 5);
        graph.addEdge('H', 'J', 6);
        graph.addEdge('I', 'K', 1);
        graph.addEdge('I', 'L', 10);
        graph.addEdge('I', 'M', 2);

        graph.bfs('S', 'I');
    }
}
