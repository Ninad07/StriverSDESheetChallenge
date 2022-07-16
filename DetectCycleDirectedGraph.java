import java.util.*;
public class Solution {
  public static boolean detectCycleInDirectedGraph(int n, ArrayList < ArrayList < Integer >> edges) {
     List<List<Integer>> graph = new ArrayList<>();
      for(int i = 0; i < n; i++) graph.add(new ArrayList<>());
      for(ArrayList<Integer> edge : edges) {
          graph.get(edge.get(0) - 1).add(edge.get(1) - 1);
      }
      
      boolean[] isVisited = new boolean[n];
      boolean[] isAncestor = new boolean[n];
      
      for(int source = 0; source < n; source++) {
          if(!isVisited[source]) {
              if(dfs(graph, source, isVisited, isAncestor)) return true;
          }
      }
      return false;
  }
    
  private static boolean dfs(List<List<Integer>> graph, int source, boolean[] isVisited, boolean[] isAncestor) {
      if(isAncestor[source] && isVisited[source]) return true;
      isVisited[source] = isAncestor[source] = true;
      for(int neighbour : graph.get(source)) {
          if(!isVisited[neighbour]) {
              if(dfs(graph, neighbour, isVisited, isAncestor)) return true;
          } else if(isAncestor[neighbour]) return true;
      }
      return isAncestor[source] = false;
  }
    
   
    
}
