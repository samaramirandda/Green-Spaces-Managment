package mdisc.SprintC;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // US17
        Scanner scanner = new Scanner(System.in);
        System.out.println("Indique o nome do ponto de partida (us17): ");
        String startVertexName1 = scanner.nextLine();

        try {
            Graph graph = new Graph("datasets mdisc\\us17_matrix.csv", "datasets mdisc\\us17_points_names.csv");
            int[][] adjacencyMatrix = graph.getAdjacencyMatrix();
            String[] points = graph.getPoints();

            try {
                graph.generateDotFile("src\\main\\java\\mdisc\\SprintC\\grafoInputUs17.dot");
                graph.renderDotFile("src\\main\\java\\mdisc\\SprintC\\grafoInputUs17.dot", "src\\main\\java\\mdisc\\SprintC\\grafoInputUs17.png");
            } catch (IOException e) {
                e.printStackTrace();
            }

            int startVertex = findAPIndex(graph.getPoints());
            int startVertexIndex = findStartVertexIndex(graph.getPoints(), startVertexName1);

            Dijkstra dijkstra = new Dijkstra(adjacencyMatrix.length);
            dijkstra.computeShortestPathsUs17(adjacencyMatrix, startVertex);

            try (FileWriter writer = new FileWriter("src\\main\\java\\mdisc\\SprintC\\caminhosUS17.csv")) {
                for (int i = 0; i < adjacencyMatrix.length; i++) {
                    if (i != startVertex) {
                        String path = Dijkstra.reconstructPathUs17(dijkstra.getPredecessors(), i, startVertex, points);
                        String[] pathElements = path.split(",");
                        StringBuilder reversedPath = new StringBuilder();
                        for (int j = pathElements.length - 1; j >= 0; j--) {
                            reversedPath.append(pathElements[j]);
                            if (j != 0) {
                                reversedPath.append(",");
                            }
                        }
                        writer.write(reversedPath.toString() + "; " + dijkstra.getTotalDistance(i) + "\n");
                    }
                    if (i == startVertexIndex) {
                        String path2 = Dijkstra.reconstructPathUs17(dijkstra.getPredecessors(), i, startVertex, points);
                        String[] pathElements2 = path2.split(",");
                        try {
                            graph.generateDotFileWithShorterRoute("src\\main\\java\\mdisc\\SprintC\\grafoUs17ShortestRouteTo" + startVertexName1 + ".dot", pathElements2);
                            graph.renderDotFile("src\\main\\java\\mdisc\\SprintC\\grafoUs17ShortestRouteTo" + startVertexName1 + ".dot", "src\\main\\java\\mdisc\\SprintC\\grafoUs17ShortestRouteTo" + startVertexName1 + ".png");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // US18
        System.out.println("Indique o nome do ponto de partida (us18): ");
        String startVertexName2 = scanner.nextLine();
        scanner.close();

        try {
            Graph graph = new Graph("datasets mdisc\\us18_matrix.csv", "datasets mdisc\\us18_points_names.csv");
            int[][] adjacencyMatrix = graph.getAdjacencyMatrix();
            String[] points = graph.getPoints();

            try {
                graph.generateDotFile("src\\main\\java\\mdisc\\SprintC\\grafoInputUs18.dot");
                graph.renderDotFile("src\\main\\java\\mdisc\\SprintC\\grafoInputUs18.dot", "src\\main\\java\\mdisc\\SprintC\\grafoInputUs18.png");
            } catch (IOException e) {
                e.printStackTrace();
            }

            List<Integer> startVertices = findAPIndexes(points);
            int startVertexIndex2 = findStartVertexIndex(graph.getPoints(), startVertexName2);
            int[] startVerticesArray = startVertices.stream().mapToInt(i -> i).toArray();

            Dijkstra dijkstra = new Dijkstra(adjacencyMatrix.length);
            dijkstra.computeShortestPathsUs18(adjacencyMatrix, startVerticesArray);

            try (FileWriter writer = new FileWriter("src\\main\\java\\mdisc\\SprintC\\caminhosUS18.csv")) {
                for (int i = 0; i < adjacencyMatrix.length; i++) {
                    if (!startVertices.contains(i)) {
                        String path = Dijkstra.reconstructPathUs18(dijkstra.getPredecessors(), i, points);
                        String[] pathElements = path.split(",");
                        StringBuilder reversedPath = new StringBuilder();
                        for (int j = pathElements.length - 1; j >= 0; j--) {
                            reversedPath.append(pathElements[j]);
                            if (j != 0) {
                                reversedPath.append(",");
                            }
                        }
                        writer.write(reversedPath + "; " + dijkstra.getTotalDistance(i) + "\n");
                    }
                    if (i == startVertexIndex2) {
                        String path2 = Dijkstra.reconstructPathUs18(dijkstra.getPredecessors(), i, points);
                        String[] pathElements2 = path2.split(",");
                        try {
                            graph.generateDotFileWithShorterRoute("src\\main\\java\\mdisc\\SprintC\\grafoUs18ShortestRouteTo" + startVertexName2 + ".dot", pathElements2);
                            graph.renderDotFile("src\\main\\java\\mdisc\\SprintC\\grafoUs18ShortestRouteTo" + startVertexName2 + ".dot", "src\\main\\java\\mdisc\\SprintC\\grafoUs18ShortestRouteTo" + startVertexName2 + ".png");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int findAPIndex(String[] points) {
        for (int i = 0; i < points.length; i++) {
            if (points[i].equals("AP")) {
                return i;
            }
        }
        return -1;
    }

    private static List<Integer> findAPIndexes(String[] points) {
        List<Integer> apIndexes = new ArrayList<>();
        for (int i = 0; i < points.length; i++) {
            if (points[i].startsWith("AP")) {
                apIndexes.add(i);
            }
        }
        return apIndexes;
    }

    private static int findStartVertexIndex (String[] points, String nameVertex) {
        for (int i = 0; i < points.length; i++) {
            if (points[i].equals(nameVertex)) {
                return i;
            }
        }
        return -1;
    }
}
