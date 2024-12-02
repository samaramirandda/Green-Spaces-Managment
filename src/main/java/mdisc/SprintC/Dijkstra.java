package mdisc.SprintC;

public class Dijkstra {
    private int[] distances;
    private int[] predecessors;
    private boolean[] visited;
    private int numVertices;

    public Dijkstra(int numVertices) {
        this.numVertices = numVertices;
        distances = new int[numVertices];
        predecessors = new int[numVertices];
        visited = new boolean[numVertices];
    }

    public void computeShortestPathsUs17(int[][] graph, int startVertex) {
        for (int i = 0; i < numVertices; i++) {
            distances[i] = Integer.MAX_VALUE;
            predecessors[i] = -1;
            visited[i] = false;
        }
        distances[startVertex] = 0;
        for (int i = 0; i < numVertices - 1; i++) {
        int u = minDistance();
        visited[u] = true;

        for (int v = 0; v < numVertices; v++) {
            if (!visited[v] && graph[u][v] != 0 &&
                    distances[u] != Integer.MAX_VALUE &&
                    distances[u] + graph[u][v] < distances[v]) {
                distances[v] = distances[u] + graph[u][v];
                predecessors[v] = u;
            }
        }
    }
}

    public void computeShortestPathsUs18(int[][] graph, int[] startVertices) {
        for (int i = 0; i < numVertices; i++) {
            distances[i] = Integer.MAX_VALUE;
            predecessors[i] = -1;
        }

        for (int startVertex : startVertices) {
            distances[startVertex] = 0;
        }

        for (int i = 0; i < numVertices; i++) {
            int u = minDistance();
            if (u == -1) break;
            visited[u] = true;

            for (int v = 0; v < numVertices; v++) {
                if (!visited[v] && graph[u][v] != 0 &&
                        distances[u] != Integer.MAX_VALUE &&
                        distances[u] + graph[u][v] < distances[v]) {
                    distances[v] = distances[u] + graph[u][v];
                    predecessors[v] = u;
                }
            }
        }
    }

    private int minDistance() {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int v = 0; v < numVertices; v++) {
            if (!visited[v] && distances[v] <= min) {
                min = distances[v];
                minIndex = v;
            }
        }
        return minIndex;
    }

    public int[] getDistances() {
        return distances;
    }

    public int[] getPredecessors() {
        return predecessors;
    }

    public static String reconstructPathUs17(int[] predecessors, int currentVertex, int startVertex, String[] points) {
        StringBuilder path = new StringBuilder();
        while (currentVertex != -1) {
            if (path.length() > 0) {
                path.insert(0, ",");
            }
            path.insert(0, points[currentVertex]);
            currentVertex = predecessors[currentVertex];
        }
        return path.toString();
    }

    public static String reconstructPathUs18(int[] predecessors, int currentVertex, String[] points) {
        StringBuilder path = new StringBuilder();
        while (currentVertex != -1) {
            if (path.length() > 0) {
                path.insert(0, ",");
            }
            path.insert(0, points[currentVertex]);
            currentVertex = predecessors[currentVertex];
        }
        return path.toString();
    }

    public int getTotalDistance(int vertex) {
        return distances[vertex];
    }
}
