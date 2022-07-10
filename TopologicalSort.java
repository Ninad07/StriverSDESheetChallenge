import java.util.*;
public class Solution 
{
    public static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> edges, int v, int e) 
    {
        ArrayList<Integer> al = new ArrayList<>();
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < v; i++) graph.add(new ArrayList<>());
        for(ArrayList<Integer> edge : edges) {
            graph.get(edge.get(0)).add(edge.get(1));
        }
        boolean[] isVisited = new boolean[v];
        for(int i = 0; i < v; i++) {
            if(!isVisited[i]) {
                dfs(graph, i, isVisited, al);
            }
        }
        Collections.reverse(al);
        return al;
    }
    
    private static void dfs(List<List<Integer>> graph, int source, boolean[] isVisited, ArrayList<Integer> al) {
        isVisited[source] = true;
        for(int neighbour : graph.get(source)) {
            if(!isVisited[neighbour]) {
                dfs(graph, neighbour, isVisited, al);
            }
        }
        al.add(source);
    }
}
