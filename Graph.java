package graphs;

import java.util.List;

public interface Graph {

    enum GraphType {
        DIRECTED,
        UNDIRECTED
    }

    GraphType getTypeOfGraph();

    void addEdge(int v0, int v1);

    void addWeightedEdge(int v0, int v1, int weight);

    List<Integer> getAdjacentVertices(int v);

    int getNumVertices();

    int getIndegree(int v);

    int getWeightedEdge(int v0, int v1);
}
