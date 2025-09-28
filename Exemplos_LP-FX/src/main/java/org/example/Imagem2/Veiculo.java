package org.example.Imagem2;

public class Veiculo {
    String modelo;
    String cor;
    int maxVelocidade;

    public Veiculo(String modelo, String cor, int maxVelocidade) {
        this.modelo = modelo;
        this.cor = cor;
        this.maxVelocidade = maxVelocidade;
    }

    public String getModelo() {
        return modelo;
    }
    public String  getCor() {
        return cor;
    }
    public int getMaxVelocidade() {
        return maxVelocidade;
    }

    public void acelerar(int km) {
        System.out.println("o veiculo acelerou " + km + " km");
    }
    public void frear(int km) {
        System.out.println("o veiculo freiou " + km + " km");
    }
    public void pintar(String novaCor) {
        System.out.println("o veiculo mudou de cor para: " + novaCor);
    }
}
