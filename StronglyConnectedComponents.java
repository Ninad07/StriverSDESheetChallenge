import java.util.*;
public class Solution {

    public static List<List<Integer>> stronglyConnectedComponents(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        List<List<Integer>> transposeGraph = new ArrayList<>();
        List<List<Integer>> al = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
            transposeGraph.add(new ArrayList<>());
        }
        for(int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            transposeGraph.get(edge[1]).add(edge[0]);
        }
        
        Stack<Integer> stack = new Stack<>();
        boolean[] isVisited = new boolean[n];
        for(int i = 0; i < n; i++) {
            if(!isVisited[i]) {
                topologicalSort(graph, i, isVisited, stack);
            }
        }
 
        isVisited = new boolean[n];
        while(!stack.isEmpty()) {
            int source = stack.pop();
            if(!isVisited[source]) {
                List<Integer> list = new ArrayList<>();
                kosaraju(transposeGraph, source, isVisited, list);
                al.add(list);
            }
        }
        
        return al;
    }
    
    private static void kosaraju(List<List<Integer>> graph, int source, boolean[] isVisited, List<Integer> list) {
        isVisited[source] = true;
        list.add(source);
        for(int neighbour : graph.get(source)) {
            if(!isVisited[neighbour]) {
                kosaraju(graph, neighbour, isVisited, list);
            }
        }
    }
       
    
    private static void topologicalSort(List<List<Integer>> graph, int source, boolean[] isVisited, Stack<Integer> stack) {
        isVisited[source] = true;
        for(int neighbour : graph.get(source)) {
            if(!isVisited[neighbour]) {
                topologicalSort(graph, neighbour, isVisited, stack);
            }
        }
        stack.push(source);
    }
}

