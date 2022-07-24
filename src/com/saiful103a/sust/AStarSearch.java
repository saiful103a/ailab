package com.saiful103a.sust;

import com.saiful103a.sust.utils.AEdge;
import com.saiful103a.sust.utils.ANode;

import java.util.*;

public class AStarSearch {
    public static ANode search(ANode source, ANode goal){
        Set<ANode> visited = new HashSet<>();
        PriorityQueue<ANode> queue = new PriorityQueue<>(20,
                Comparator.comparingDouble(i -> i.fOfN)
        );

        source.gOfN = 0;
        queue.add(source);
        boolean found = false;

        while(!queue.isEmpty() && !found){
            //the ANode in having the lowest fOfN value
            ANode current = queue.poll();
            visited.add(current);
            //goal found
            if(current.value.equals(goal.value)){
                found = true;
            }
            //check every child of current ANode
            for(AEdge e : current.edges){
                ANode child = e.target;
                double cost = e.cost;
                double tempGofN = current.gOfN + cost;
                double tempFofN = tempGofN + child.hOfN;
                if(visited.contains(child) && tempFofN >= child.fOfN){
                    continue;
                }else if(!queue.contains(child) || tempFofN < child.fOfN){
                    child.parent = current;
                    child.gOfN = tempGofN;
                    child.fOfN = tempFofN;
                    queue.remove(child);
                    queue.add(child);
                }
            }
        }
        return goal;
    }

    public static List<ANode> printPath(ANode target){
        List<ANode> path = new ArrayList<>();
        for(ANode node = target; node!=null; node = node.parent){
            path.add(node);
        }
        Collections.reverse(path);
        return path;
    }

    public static void main(String[] args) {
        //initialize the graph base on the Romania map
        ANode sylhet = new ANode("Sylhet",366);
        ANode kulaura = new ANode("Kulaura",374);
        ANode srimangal = new ANode("Srimangal",380);
        ANode noapara = new ANode("Noapara",253);
        ANode merashani = new ANode("Merashani",178);
        ANode azampur = new ANode("Azampur",193);
        ANode akhaura = new ANode("Akhaura",98);
        ANode bbaria = new ANode("BBaria",329);
        ANode ashugonj = new ANode("Ashugonj",244);
        ANode bhairab = new ANode("Bhairab",241);
        ANode norshingdi = new ANode("Norshingdi",242);
        ANode tongi = new ANode("Tongi",160);
        ANode dhaka = new ANode("Dhaka",0);
        ANode khulna = new ANode("Khulna",77);

        //initialize the edges
        sylhet.edges = new AEdge[]{
                new AEdge(kulaura,75),
                new AEdge(noapara,140),
                new AEdge(bbaria,118)
        };

        kulaura.edges = new AEdge[]{
                new AEdge(sylhet,75),
                new AEdge(srimangal,71)
        };

        srimangal.edges = new AEdge[]{
                new AEdge(kulaura,71),
                new AEdge(noapara,151)
        };

        noapara.edges = new AEdge[]{
                new AEdge(sylhet,140),
                new AEdge(merashani,99),
                new AEdge(srimangal,151),
                new AEdge(azampur,80),
        };

        merashani.edges = new AEdge[]{
                new AEdge(noapara,99),
                new AEdge(dhaka,211)
        };

        azampur.edges = new AEdge[]{
                new AEdge(noapara,80),
                new AEdge(akhaura,97),
                new AEdge(tongi,146)
        };

        akhaura.edges = new AEdge[]{
                new AEdge(azampur,97),
                new AEdge(dhaka,101),
                new AEdge(tongi,138)
        };

        bbaria.edges = new AEdge[]{
                new AEdge(sylhet,118),
                new AEdge(ashugonj,111)
        };

        ashugonj.edges = new AEdge[]{
                new AEdge(bbaria,111),
                new AEdge(bhairab,70)
        };

        bhairab.edges = new AEdge[]{
                new AEdge(ashugonj,70),
                new AEdge(norshingdi,75)
        };

        norshingdi.edges = new AEdge[]{
                new AEdge(bhairab,75),
                new AEdge(tongi,120)
        };

        tongi.edges = new AEdge[]{
                new AEdge(norshingdi,120),
                new AEdge(azampur,146),
                new AEdge(akhaura,138)
        };

        dhaka.edges = new AEdge[]{
                new AEdge(akhaura,101),
                new AEdge(khulna,90),
                new AEdge(merashani,211)
        };

        khulna.edges = new AEdge[]{
                new AEdge(dhaka,90)
        };
        List<ANode> path = printPath(search(sylhet,azampur));
        System.out.println("Path: " + path);
    }
}
