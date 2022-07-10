import java.util.*;
public class Solution {
    public static graphNode cloneGraph(graphNode node) {
        graphNode graph = new graphNode();
        clone(graph, node);
        return graph;
    }
    
    private static void clone(graphNode graph, graphNode node) {
        graph.data = node.data;
        for(graphNode neighbour : node.neighbours) {
            graphNode newNode = new graphNode();
            newNode.data = neighbour.data;
            graph.neighbours.add(newNode);
            clone(graph.neighbours.get(graph.neighbours.size() - 1), neighbour);
        }
    }
}
