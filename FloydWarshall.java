import java.util.*;

public class Solution {
  static int floydWarshall(int n, int m, int src, int dest, ArrayList<ArrayList<Integer>> edges) {
      int[][] dist = new int[n][n];
      for(int i = 0; i < dist.length; i++) {
          Arrays.fill(dist[i], Integer.MAX_VALUE);
          dist[i][i] = 0;
      }
      
      for(ArrayList<Integer> edge : edges) {
          int vertex = edge.get(0) - 1, neighbour = edge.get(1) - 1;
          int weight = edge.get(2);
          dist[vertex][neighbour] = weight;
      }
      
      for(int i = 0; i < n; i++) {
          for(int j = 0; j < n; j++) {
              for(int k = 0; k < n; k++) {
                  if(dist[i][k] == Integer.MAX_VALUE || dist[k][j] == Integer.MAX_VALUE) continue;
                  if(dist[i][k] + dist[k][j] < dist[i][j]) {
                      dist[i][j] = dist[i][k] + dist[k][j];
                  }
              }
          }
      }
      
      return dist[src - 1][dest - 1] == Integer.MAX_VALUE ? 1000000000 : dist[src - 1][dest - 1];
  }

}
