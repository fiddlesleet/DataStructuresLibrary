package graphs;

public class VertexInfo {
    private Integer vertexId;
    private Integer distance;
    private Integer numEdges;


    public VertexInfo(int vertexId, int distance, int numEdges) {
        this.vertexId = vertexId;
        this.distance = distance;
        this.numEdges = numEdges;
    }

    public Integer getVertexId() {
        return vertexId;
    }

    public Integer getDistance() {
        return distance;
    }

    public Integer getNumEdges() {
        return numEdges;
    }
}
