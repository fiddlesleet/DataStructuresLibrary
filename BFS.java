package graphs;

import DataStructures.Queue;

import java.util.List;

public class BFS {
    public void breadtbFirstTraversal(Graph graph, int[] visited, int currentVertex) {
        Queue<Integer> q = new Queue<>(Integer.class);
        q.enqueue(currentVertex);

        while(!q.isEmpty()) {
            int vertex = q.dequeue();

            if (visited[vertex] == 1) {
                continue;
            }

            System.out.print(vertex + " -> ");
            visited[currentVertex] = 1;

            List<Integer> l = graph.getAdjacentVertices(vertex);
            for (int v : l) {
                if (visited[v] != 1) {
                    q.enqueue(v);
                }
            }
        }
    }
}
