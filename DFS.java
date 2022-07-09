import java.util.*;

public class Solution {
    public static ArrayList<ArrayList<Integer>> depthFirstSearch(int v, int e, ArrayList<ArrayList<Integer>> edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < v; i++) graph.add(new ArrayList<>());
        for(ArrayList<Integer> list : edges) {
            graph.get(list.get(0)).add(list.get(1));
            graph.get(list.get(1)).add(list.get(0));
        }
        
        ArrayList<ArrayList<Integer>> al = new ArrayList<>();
        boolean[] isVisited = new boolean[v];
        for(int source = 0; source < v; source++) {
            if(!isVisited[source]) {
                ArrayList<Integer> list = new ArrayList<>();
                dfs(graph, source, isVisited, list);
                al.add(list);
            }
        }
        
        return al;
    }
    
    private static void dfs(List<List<Integer>> graph, int source, boolean[] isVisited, ArrayList<Integer> al) {
        isVisited[source] = true;
        al.add(source);
        
        for(int neighbour : graph.get(source)) {
            if(!isVisited[neighbour]) {
                dfs(graph, neighbour, isVisited, al);
            }
        }
    }
}
