package graphs;

public class DistanceEdgeInfo {
    private Integer distance;
    private Integer numEdges;
    private Integer lastVertex;

    public DistanceEdgeInfo() {
        distance = Integer.MAX_VALUE;
        lastVertex = -1;
        numEdges = Integer.MAX_VALUE;
    }

    public Integer getDistance() {
        return distance;
    }

    public Integer getLastVertex() {
        return lastVertex;
    }

    public Integer getNumEdges() {
        return numEdges;
    }

    public void setInfo(int lastVertex, int distance, int numEdges) {
        this.distance = distance;
        this.lastVertex = lastVertex;
        this.numEdges = numEdges;
    }

}
