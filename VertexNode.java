package graphs;

import java.util.*;

public class VertexNode {
    private int vertexNumber;
    private Set<Integer> adjacencySet = new HashSet<>();

    public VertexNode(int vertexNumber) {
        this.vertexNumber = vertexNumber;
    }

    public int getVertexNumber() {
        return this.vertexNumber;
    }

    public void addEdgeConnection(int vertexNumber) {
        adjacencySet.add(vertexNumber);
    }


    public List<Integer> getAdjacentVertices() {
        List<Integer> sortedList = new ArrayList<>(adjacencySet);
        Collections.sort(sortedList);

        return sortedList;
    }
}
