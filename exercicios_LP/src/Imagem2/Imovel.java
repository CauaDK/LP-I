package Imagem2;

public class Imovel {
    double tamanho;
    String endereco;
    String cor;

    public Imovel(double tamanho, String endereco, String cor) {
        this.tamanho = tamanho;
        this.endereco = endereco;
        this.cor = cor;
    }

    public void pintar(String novaCor) {
        System.out.println("o imovel trocou a cor para: " + novaCor);
    }
    public void maisAndar(int qnt) {
        System.out.println("o imovel adicionou +" + qnt + " andar(es)");
    }
    public void novoEndereco(String local) {
        System.out.println("o imovel se mudou para: " + local);
    }
}
