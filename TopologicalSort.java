package graphs;

import graphs.Graph;
import DataStructures.LinkedListQueue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopologicalSort {

    public static List<Integer> topologicalSort(Graph graph) {
        LinkedListQueue<Integer> q = new LinkedListQueue<>();
        Map<Integer, Integer> indegreeMap = new HashMap<>();

        for (int vertex = 0; vertex < graph.getNumVertices(); vertex++) {
            int indegree = graph.getIndegree(vertex);
            indegreeMap.put(vertex, indegree);
            if (indegree == 0) {
                q.enq(vertex);
            }
        }

        List<Integer> sortedList = new ArrayList<>();
        while (!q.isEmpty()) {
            int vertex = q.pollLast();
            sortedList.add(vertex);

            List<Integer> adjacentVertices = graph.getAdjacentVertices(vertex);

            for (int adjacentVertex : adjacentVertices) {
                int updatedIndegree = indegreeMap.get(adjacentVertex) - 1;
                indegreeMap.remove(adjacentVertex);
                indegreeMap.put(adjacentVertex, updatedIndegree);

                if (updatedIndegree == 0) {
                    q.enq(adjacentVertex);
                }
            }
        }

        if (sortedList.size() != graph.getNumVertices()) {
            throw new RuntimeException("The Graph has a cycle!");
        }

        return sortedList;
    }
}
