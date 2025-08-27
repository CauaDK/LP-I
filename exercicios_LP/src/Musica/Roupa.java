package Musica;

public class Roupa {
    double tamanho;
    String cor;
    String tecido;

    public Roupa(double tamanho, String cor, String tecido) {
        this.tamanho = tamanho;
        this.cor = cor;
        this.tecido = tecido;
    }

    public void lavar(boolean lavado) {
        if (lavado) {
            System.out.println("Roupa limpa");
        } else{
            System.out.println("Roupa suja");
        }
    }
}
