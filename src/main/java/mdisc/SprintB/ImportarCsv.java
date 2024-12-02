package mdisc.SprintB;

import mdisc.SprintB.Aresta;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ImportarCsv {
    public static List<Aresta> lerGrafoDeCSV(String nomeArquivo) throws FileNotFoundException {

        List<Aresta> arestas = new ArrayList<>();

        Scanner scanner = new Scanner(new File(nomeArquivo));

        while (scanner.hasNextLine()) {
            String[] linha = scanner.nextLine().split(";");
            String origem = linha[0];
            String destino = linha[1];
            int peso = Integer.parseInt(linha[2]);
            arestas.add(new Aresta(origem, destino, peso));
        }

        return arestas;
    }
}
