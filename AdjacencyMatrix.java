package graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AdjacencyMatrix implements Graph {
    // use for: well-connected graphs

    private int[][] adjacencyMatrix;
    int numVertices = 0;
    GraphType graphType = GraphType.DIRECTED;


    public AdjacencyMatrix(int numVertices, GraphType graphType) {
        this.numVertices = numVertices;
        this.graphType = graphType;

        adjacencyMatrix = new int[numVertices][numVertices];

        // initialize all edge connections to 0
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                adjacencyMatrix[i][j] = 0;
            }
        }
    }

    @Override
    public GraphType getTypeOfGraph() {
        return this.graphType;
    }

    @Override
    public void addEdge(int v0, int v1) {
        if (v0 >= numVertices || v0 < 0 || v1 >= numVertices || v1 < 0) {
            throw new IllegalArgumentException("Vertex number invalid");
        }

        adjacencyMatrix[v0][v1] = 1;

        if (graphType == GraphType.UNDIRECTED) {
            adjacencyMatrix[v1][v0] = 1;
        }
    }

    @Override
    public void addWeightedEdge(int v0, int v1, int weight) {
        if (v0 >= numVertices || v1 >= numVertices || v0 < 0 || v1 < 0) {
            throw new IllegalArgumentException("Invalid vertex number ");
        }

        adjacencyMatrix[v0][v1] = weight;
        if (graphType == GraphType.UNDIRECTED) {
            adjacencyMatrix[v1][v0] = weight;
        }
    }

    public List<Integer> getAdjacentVertices(int v) {
        if (v >= numVertices || v < 0) {
            throw new IllegalArgumentException("Vertex number invalid");
        }

        List<Integer> adjacentVerticesList = new ArrayList<>();
        for (int i = 0; i < numVertices; i++) {
            if (adjacencyMatrix[v][i] == 1) {
                adjacentVerticesList.add(i);
            }
        }

        // always return neighbor vertices in ascending order
        Collections.sort(adjacentVerticesList);

        return adjacentVerticesList;
    }

    @Override
    public int getNumVertices() {
        return this.numVertices;
    }

    public int getIndegree(int v) {
        if (v < 0 || v >= numVertices) {
            throw new IllegalArgumentException("V out of bounds");
        }

        int indegree = 0;
        for (int i = 0; i < numVertices; i++) {
            if (adjacencyMatrix[i][v] == 1) {
                indegree++;
            }
        }

        return indegree;
    }

    @Override
    public int getWeightedEdge(int v0, int v1) {
        return adjacencyMatrix[v0][v1];
    }
}
