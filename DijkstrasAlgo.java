import java.util.*;
public class Solution {
	private static class Edge {
        int vertex, weight;
        Edge(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }
	public static ArrayList < Integer > dijkstra(ArrayList< ArrayList < Integer > > vec, int vertices, int edges, int source){
		List<List<Edge>> graph = new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0; i < vertices; i++) {
            graph.add(new ArrayList<>());
            ans.add(Integer.MAX_VALUE);
        }
        for(ArrayList<Integer> al : vec) {
            graph.get(al.get(0)).add(new Edge(al.get(1), al.get(2)));
            graph.get(al.get(1)).add(new Edge(al.get(0), al.get(2)));
        }
        
        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        boolean[] isVisited = new boolean[vertices];
        pq.add(new Edge(source, 0));
        while(!pq.isEmpty()) {
            Edge edge = pq.poll();
            if(isVisited[edge.vertex]) continue;
            isVisited[edge.vertex] = true;
            ans.set(edge.vertex, edge.weight);
            for(Edge neighbour : graph.get(edge.vertex)) {
                if(!isVisited[neighbour.vertex]) {
                    pq.add(new Edge(neighbour.vertex, edge.weight + neighbour.weight));
                }
            }
        }
        
        return ans;
	}
}
