package graphs;

import java.util.*;

import static graphs.ShortestPathUnweighted.shortestPath;

public class ShortestPathMinEdges {

    public static void main(String[] args) {
        Graph graph = new AdjacencyMatrix(5, Graph.GraphType.DIRECTED);
        graph.addWeightedEdge(0, 1, 6);
        graph.addWeightedEdge(1, 4, 3);
        graph.addWeightedEdge(0, 3, 1);
        graph.addWeightedEdge(3, 2, 2);

        graph.addWeightedEdge(2, 1, 3);

        graph.addWeightedEdge(0, 1, 6);

        shortestPath(graph, 0, 4);

    }


    public static Map<Integer, DistanceEdgeInfo> buildDistanceTable(Graph graph, int source) {
        Map<Integer, DistanceEdgeInfo> distanceTable = new HashMap<>();
        PriorityQueue<VertexInfo> q = new PriorityQueue<>(new Comparator<VertexInfo>() {
            @Override
            public int compare(VertexInfo v0, VertexInfo v1) {
                if (v0.getDistance().compareTo(v1.getDistance()) != 0) {
                    return v0.getDistance().compareTo(v1.getDistance());
                }
                return v0.getNumEdges().compareTo(v1.getNumEdges());
            }
        });

        for (int j = 0; j < graph.getNumVertices(); j++) {
            distanceTable.put(j, new DistanceEdgeInfo());
        }

        distanceTable.get(source).setInfo(source, 0, 0);

        VertexInfo sourceVertexInfo = new VertexInfo(source, 0, 0);
        q.add(sourceVertexInfo);

        Map<Integer, VertexInfo> vertexInfoMap = new HashMap<>();
        vertexInfoMap.put(source, sourceVertexInfo);

        while(!q.isEmpty()) {
            VertexInfo currentVertexInfo = q.poll();

            for (Integer neighbor: graph.getAdjacentVertices(currentVertexInfo.getVertexId())) {
                int distance = distanceTable.get(currentVertexInfo.getVertexId()).getDistance()
                        + graph.getWeightedEdge(currentVertexInfo.getVertexId(), neighbor);
                int edges = distanceTable.get(currentVertexInfo.getVertexId()).getNumEdges() + 1;

                int neighborDistance = distanceTable.get(neighbor).getDistance();
                if (neighborDistance > distance || ((neighborDistance == distance)
                        && (distanceTable.get(neighbor).getNumEdges() > edges))) {
                    distanceTable.get(neighbor).setInfo(
                            currentVertexInfo.getVertexId(), distance, edges);

                    VertexInfo neighborVertexInfo = vertexInfoMap.get(neighbor);
                    if (neighborVertexInfo != null) {
                        q.remove(neighborVertexInfo);
                    }

                    neighborVertexInfo = new VertexInfo(neighbor, distance, edges);
                    q.add(neighborVertexInfo);
                    vertexInfoMap.put(neighbor, neighborVertexInfo);

                    }
                }
            }

            return distanceTable;
    }

    public static void shortestPath(Graph graph, int source, int destination) {
        Map<Integer, DistanceEdgeInfo> distanceTable = buildDistanceTable(graph, source);

        Stack<Integer> stack = new Stack<>();
        stack.push(destination);

        int previousVertex = distanceTable.get(destination).getLastVertex();
        while (previousVertex != -1 && previousVertex != source) {
            stack.push(previousVertex);
            previousVertex = distanceTable.get(previousVertex).getLastVertex();
        }

        if (previousVertex == -1) {
            System.out.println("There is no path from node: " + source
                    + " to node: " + destination);
        }

        else {
            System.out.print("Smallest Path is " + source);
            while (!stack.isEmpty()) {
                System.out.print(" -> " +stack.pop());
            }

            System.out.println();
            System.out.println("ShortestPathWeightWithMinEdges DONE!");

        }

    }




}
