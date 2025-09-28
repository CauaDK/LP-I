package org.example.Musica;

public class Estrela {
    double temperatura;
    double massa;
    int idade;

    public Estrela(double temperatura, double massa, int idade) {
        this.temperatura = temperatura;
        this.massa = massa;
        this.idade = idade;
    }

    public double getTemperatura() {
        return temperatura;
    }
    public double getMassa() {
        return massa;
    }
    public int getIdade() {
        return idade;
    }

    public void brilhar(int brilho) {
        System.out.println("Seu brilho é: " + brilho);
    }
}
