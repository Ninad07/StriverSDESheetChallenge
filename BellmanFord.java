import java.util.*;
public class Solution {
    static int bellmonFord(int n, int m, int src, int dest, ArrayList<ArrayList<Integer>> edges) {
        int[] path = new int[n + 1];
        Arrays.fill(path, 1000000000);
        path[src] = 0;
        for(int j = 0; j < n - 1; j++) {
            for(int i = 0; i < edges.size(); i++) {
            int source = edges.get(i).get(0);
            int neighbour = edges.get(i).get(1);
            int weight = edges.get(i).get(2);
            if(path[source] != 1000000000 && path[source] + weight < path[neighbour]) {
                path[neighbour] = path[source] + weight;
            }
        }
        }
        
        return path[dest];
    }
    
}
