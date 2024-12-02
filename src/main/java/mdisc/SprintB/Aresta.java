package mdisc.SprintB;

public class Aresta {
    private String origem;
    private String destino;
    private int peso;

    public Aresta(String origem, String destino, int peso) {
        this.origem = origem;
        this.destino = destino;
        this.peso = peso;
    }

    public String getOrigem() {
        return origem;
    }

    public int getPeso() {
        return peso;
    }

    public String getDestino() {
        return destino;
    }

}



