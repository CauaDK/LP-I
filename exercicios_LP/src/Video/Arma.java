package Video;

public class Arma {
    String modelo;
    double comprimento;
    int alcance;

    public Arma(String modelo, double comprimento, int alcance) {
        this.modelo = modelo;
        this.comprimento = comprimento;
        this.alcance = alcance;
    }

    public void atirar(int qnt) {
        System.out.println("a arma atirou " + qnt + " vezes");
    }
    public void recarregar(int carga) {
        System.out.println("a arma recarregou " + carga + " vezes");
    }
    public void quebrar(boolean quebrada) {
        if(quebrada) {
            System.out.println("arma quebrou");
        }else {
            System.out.println("arma nao quebrou");
        }
    }
}
