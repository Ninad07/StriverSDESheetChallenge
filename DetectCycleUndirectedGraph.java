import java.util.*;
public class Solution {
    
    public static String cycleDetection(int[][] edges, int n, int m) {
        List<List<Integer>> graph = new ArrayList<>();
      for(int i = 0; i < n; i++) graph.add(new ArrayList<>());
      for(int[] edge : edges) {
          graph.get(edge[0] - 1).add(edge[1] - 1);
          graph.get(edge[1] - 1).add(edge[0] - 1);
      }
        
        boolean[] isVisited = new boolean[n];
        for(int source = 0; source < n; source++) {
          if(!isVisited[source]) {
              if(dfs(graph, source, isVisited, -1)) return "Yes";
          }
        }
        return "No";
    }
    
    private static boolean dfs(List<List<Integer>> graph, int source, boolean[] isVisited, int parent) {
        isVisited[source] = true;
        for(int neighbour : graph.get(source)) {
            if(!isVisited[neighbour]) {
                if(dfs(graph, neighbour, isVisited, source)) return true;
            } else if(neighbour != parent) {
                return true;
            }
        }
        
        return false;
    }
    
}
