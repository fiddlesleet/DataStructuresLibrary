package graphs;

import DataStructures.LinkedListQueue;
import DataStructures.Stack;

import java.util.HashMap;
import java.util.Map;

public class ShortestPathUnweighted {

    private static Map<Integer, DistanceTable> buildDistanceTable(Graph graph, int source) {
        Map<Integer, DistanceTable> distanceTableMap = new HashMap<>();

        for (int i = 0; i < graph.getNumVertices(); i++) {
            distanceTableMap.put(i, new DistanceTable());
        }

        distanceTableMap.get(source).setDistance(0);
        distanceTableMap.get(source).setLastVertex(source);

        LinkedListQueue<Integer> q = new LinkedListQueue<>();
        q.enq(source);

        while (!q.isEmpty()) {
            int currentVertex = q.pollFirst();
            for (int i : graph.getAdjacentVertices(currentVertex)) {
                int currentDistance = distanceTableMap.get(i).getDistance();
                if (currentDistance == -1) {
                    currentDistance = 1 + distanceTableMap.get(currentVertex).getDistance();
                    distanceTableMap.get(i).setDistance(currentDistance);
                    distanceTableMap.get(i).setLastVertex(currentVertex);

                    // enq the neighbor only if it has other adjacent vertices
                    if (!graph.getAdjacentVertices(i).isEmpty()) {
                        q.enq(i);
                    }
                }
            }
        }
        return distanceTableMap;
    }

    public static void shortestPath(Graph graph, int source, int destination) {
        Map<Integer, DistanceTable> distanceTable = buildDistanceTable(graph, source);

        Stack<Integer> stack = new Stack<>();
        stack.push(destination);

        int previousVertex = distanceTable.get(destination).getLastVertex();

        while(previousVertex != -1 && previousVertex != source) {
            stack.push(previousVertex);
            previousVertex = distanceTable.get(previousVertex).getLastVertex();
        }

        if (previousVertex == -1) {
            System.out.println("There is no path from node: " + source + " to node: " + destination);
        } else {
            System.out.println("Shortest path is: " + source);
            while (!stack.isEmpty()) {
                System.out.print(" -> " + stack.pop());
            }
            System.out.println("We Found the Shortest Path!");
        }
    }
}
