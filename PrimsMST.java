import java.util.*;

public class Solution 
{
    private static class Edge {
        int vertex, weight, neighbour;
        Edge(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
        Edge(int vertex, int weight, int neighbour) {
            this.vertex = vertex;
            this.weight = weight;
            this.neighbour = neighbour;
        }
    }
    public static ArrayList<ArrayList<Integer>> calculatePrimsMST(int n, int m, ArrayList<ArrayList<Integer>> edges)
    {
        List<List<Edge>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for(ArrayList<Integer> edge : edges) {
            int source = edge.get(0) - 1;
            int neighbour = edge.get(1) - 1;
            int weight = edge.get(2);
            graph.get(source).add(new Edge(neighbour, weight));
            graph.get(neighbour).add(new Edge(source, weight));
        }
        
        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        ArrayList<ArrayList<Integer>> al = new ArrayList<>();
        boolean[] isVisited = new boolean[n];
        pq.add(new Edge(0, 0, 0));
        while(!pq.isEmpty()) {
            Edge edge = pq.poll();
            if(isVisited[edge.neighbour]) continue;
            isVisited[edge.neighbour] = true;
            
            if(edge.vertex != edge.neighbour) {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(edge.vertex + 1);
                list.add(edge.neighbour + 1);
                list.add(edge.weight);
                al.add(list);
            }
            
            for(Edge neighbour : graph.get(edge.neighbour)) {
                if(!isVisited[neighbour.vertex]) {
                    pq.add(new Edge(edge.neighbour, neighbour.weight, neighbour.vertex));
                }
            }
        }
        
        return al;
    }
}
