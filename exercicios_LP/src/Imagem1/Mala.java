package Imagem1;

public class Mala {
    double capacidade;
    String material;
    double peso;

    public Mala(double capacidade, String material, double peso) {
        this.capacidade = capacidade;
        this.material = material;
        this.peso = peso;
    }

    public void abrir(boolean aberto) {
        if (aberto) {
            System.out.println("Mala aberta");
        }else {
            System.out.println("Mala fechada");
        }
    }
}
