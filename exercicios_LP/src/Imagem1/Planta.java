package Imagem1;

public class Planta {
    double tamanho;
    boolean cortada;
    String cor;

    public Planta(double tamanho, boolean cortada, String cor) {
        this.tamanho = tamanho;
        this.cortada = cortada;
        this.cor = cor;
    }

    public void crescer(int cm) {
        System.out.println("A planta cresceu" + cm + " cm");
    }
}
