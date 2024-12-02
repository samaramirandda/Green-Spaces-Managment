package mdisc.SprintB;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            // Ler o grafo da US13
            String ficheiro = "datasets mdisc\\quarta_feira.csv";
            ImplementationSprintB.gerarOutputExcel(ficheiro, "src\\main\\java\\mdisc\\SprintB\\output_menor_caminho.csv");
            Aresta[] resultado = ImportarCsv.lerGrafoDeCSV(ficheiro).toArray(new Aresta[0]);

            ImplementationSprintB.generateDotFile(resultado, "src\\main\\java\\mdisc\\SprintB\\input_grafo.dot");
            ImplementationSprintB.renderDotFile("src\\main\\java\\mdisc\\SprintB\\input_grafo.dot", "src\\main\\java\\mdisc\\SprintB\\input_grafo.png");

            // Executar os testes de algoritmo da US14
            String inicioNome = "datasets mdisc\\fx_4feira_";
            String outputFile = "src\\main\\java\\mdisc\\SprintB\\execution_time.csv";
            String outputFilePng = "src\\main\\java\\mdisc\\SprintB\\execution_time_graph.png";
            ImplementationSprintB.runAlgorithmTests(inicioNome, outputFile, outputFilePng);

        } catch (IOException e) {
            System.err.println("Erro ao processar o arquivo: " + e.getMessage());
        }
    }

}
