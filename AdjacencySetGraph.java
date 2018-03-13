package graphs;

import java.util.ArrayList;
import java.util.List;

public class AdjacencySetGraph implements Graph {

    // use for: sparsely connected graphs

    private List<VertexNode> vertexList = new ArrayList<>();
    private GraphType graphType = GraphType.DIRECTED;
    private int numVertices = 0;

    public AdjacencySetGraph(int numVertices, GraphType graphType) {
        this.numVertices = numVertices;
        for (int i = 0; i < numVertices; i++) {
            vertexList.add(new VertexNode(i));
        }
        this.graphType = graphType;
    }

    public int getNumVertices() {
        return numVertices;
    }

    @Override
    public GraphType getTypeOfGraph() {
        return this.graphType;
    }

    public void addEdge(int v0, int v1) {
        if (v0 >= numVertices || v0 < 0 || v1 >= numVertices || v1 < 0) {
            throw new IllegalArgumentException("Vertex number out of bounds");
        }

        vertexList.get(v0).addEdgeConnection(v1);

        if (graphType == GraphType.UNDIRECTED) {
            vertexList.get(v1).addEdgeConnection(v0);
        }
    }

    @Override
    public void addWeightedEdge(int v0, int v1, int weight) {
        throw new IllegalArgumentException("weight not implemented in adjacency set");
    }

    public List<Integer> getAdjacentVertices(int v) {
        if (v >= numVertices || v < 0) {
            throw new IllegalArgumentException("Vertex number out of bounds");
        }

        return vertexList.get(v).getAdjacentVertices();
    }

    @Override
    public int getIndegree(int v) {
        if (v < 0 || v >= numVertices) {
            throw new IllegalArgumentException("Vertex number not valid");
        }

        int indegree = 0;

        for (int i = 0; i < numVertices; i++) {
            if (getAdjacentVertices(i).contains(v)) {
                indegree++;
            }
        }

        return indegree;
    }

    @Override
    public int getWeightedEdge(int v0, int v1) {
        throw new IllegalArgumentException("Weight not implemented in Adjacency Set");
    }

}
