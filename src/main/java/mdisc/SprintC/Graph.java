package mdisc.SprintC;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Graph {
    private int[][] adjacencyMatrix;
    private String[] points;

    public Graph(String matrixFile, String pointsFile) throws IOException {
        readMatrix(matrixFile);
        readPoints(pointsFile);
    }

    private void readMatrix(String file) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        int size = 0;
        while ((line = br.readLine()) != null) {
            size++;
        }
        br.close();

        adjacencyMatrix = new int[size][size];
        br = new BufferedReader(new FileReader(file));
        int row = 0;
        while ((line = br.readLine()) != null) {
            String[] values = line.split(";");
            for (int col = 0; col < values.length; col++) {
                adjacencyMatrix[row][col] = Integer.parseInt(values[col].replaceAll("[^\\d]", ""));
            }
            row++;
        }
        br.close();
    }

    private void readPoints(String file) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line = br.readLine();
        if (line != null) {
            points = line.replaceAll("[^\\x20-\\x7E]", "").split(";");
        }
        br.close();
    }

    public int[][] getAdjacencyMatrix() {
        return adjacencyMatrix;
    }

    public String[] getPoints() {
        return points;
    }

    public void generateDotFile(String filename) throws IOException {
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write("graph G {\n");
            for (int i = 0; i < adjacencyMatrix.length; i++) {
                for (int j = i + 1; j < adjacencyMatrix[i].length; j++) {
                    if (adjacencyMatrix[i][j] != 0) {
                        writer.write(points[i] + " -- " + points[j] + " [label=\"" + adjacencyMatrix[i][j] + "\"];\n");
                    }
                }
            }
            writer.write("}\n");
        }
    }

    public void renderDotFile(String dotFileName, String outputFileName) throws IOException {
        String[] cmd = {"dot", "-Tpng", dotFileName, "-o", outputFileName};
        ProcessBuilder pb = new ProcessBuilder(cmd);
        pb.redirectErrorStream(true);
        Process process = pb.start();

        try {
            process.waitFor();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void generateDotFileWithShorterRoute(String filename, String[] path) throws IOException {
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write("graph G {\n");
            for (int i = 0; i < adjacencyMatrix.length; i++) {
                for (int j = i + 1; j < adjacencyMatrix[i].length; j++) {
                    if (adjacencyMatrix[i][j] != 0) {
                        boolean isRed = isEdgeInPath(path, points[i], points[j]);
                        if (isRed) {
                            writer.write(points[i] + " -- " + points[j] + " [label=\"" + adjacencyMatrix[i][j] + "\", color=red];\n");
                        } else {
                            writer.write(points[i] + " -- " + points[j] + " [label=\"" + adjacencyMatrix[i][j] + "\"];\n");
                        }
                    }
                }
            }
            writer.write("}\n");
        }
    }

    private boolean isEdgeInPath(String[] path, String start, String end) {
        for (int i = 0; i < path.length - 1; i++) {
            if ((path[i].equals(start) && path[i + 1].equals(end)) || (path[i].equals(end) && path[i + 1].equals(start))) {
                return true;
            }
        }
        return false;
    }

}
