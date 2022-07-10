import java.util.*;

public class Solution {

    public static boolean isGraphBirpatite(ArrayList<ArrayList<Integer>> edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < edges.size(); i++) graph.add(new ArrayList<>());
        for(int i = 0; i < edges.size(); i++) {
            for(int j = 0; j < edges.get(i).size(); j++) {
                if(edges.get(i).get(j) == 1) {
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }
            }
        }
        
        return isBipartite(graph);
    }
    
    private static boolean isBipartite(List<List<Integer>> graph) {
        int[] colors = new int[graph.size()];
        for(int source = 0; source < colors.length; source++) {
            if(colors[source] == 0) {
                if(!mColor(graph, source, 1, colors)) return false;
            }
        }
        return true;
    }
    
    private static boolean mColor(List<List<Integer>> graph, int source, int color, int[] colors) {
        colors[source] = color;
        for(int neighbour : graph.get(source)) {
            if(colors[neighbour] == 0) {
                if(!mColor(graph, neighbour, -color, colors)) return false;
            } else if(colors[neighbour] == color) return false;
        }
        return true;
    }
}
