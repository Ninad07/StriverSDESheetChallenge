import java.util.*;
public class Solution {
    public static int kruskalMST(int n, int m, ArrayList<ArrayList<Integer>> graph) {
        int[] parent = new int[n];
        int[] rank = new int[n];
        for(int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
        
        Collections.sort(graph, (a, b) -> {
            return a.get(2) - b.get(2);
        });
        int ans = 0;
        for(ArrayList<Integer> al : graph) {
            int vertex = al.get(0) - 1;
            int neighbour = al.get(1) - 1;
            int weight = al.get(2);
            int vertexParent = find(vertex, parent);
            int neighbourParent = find(neighbour, parent);
            
            if(vertexParent == neighbourParent) continue;
            if(rank[vertexParent] < rank[neighbourParent]) {
                parent[vertexParent] = neighbourParent;
            } else if(rank[vertexParent] > rank[neighbourParent]) {
                parent[neighbourParent] = vertexParent;
            } else {
                parent[neighbourParent] = vertexParent;
                rank[vertexParent]++;
            }
            
            ans += weight;
        }
        
        return ans;
    }
    private static int find(int vertex, int[] parent) {
        if(parent[vertex] == vertex) {
            return vertex;
        }
        int curr = find(parent[vertex], parent);
        parent[vertex] = curr;
        return curr;
    }
    
    
    
}
