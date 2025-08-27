package Video;

public class Monstro {
    String nome;
    double tamanho;
    int perigo;

    public Monstro(String nome, double tamanho, int perigo) {
        this.nome = nome;
        this.tamanho = tamanho;
        this.perigo = perigo;
    }

    public void correr(int metros) {
        System.out.println("correu " + metros + " metros");
    }
    public void pular(int pulo) {
        System.out.println("pulou " + pulo + " vezes");
    }
    public void atacar(int ataque) {
        System.out.println("atacou " + ataque + " vezes");
    }
}
