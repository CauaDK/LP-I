package org.example.model;

public class Estrela {
    double temperatura;
    double massa;
    int idade;

    public Estrela(double temperatura, double massa, int idade) {
        this.temperatura = temperatura;
        this.massa = massa;
        this.idade = idade;
    }

    public double getTemperatura() {return temperatura;}
    public void setTemperatura(double temperatura) {this.temperatura = temperatura;}

    public double getMassa() {return massa;}
    public void setMassa(double massa) {this.massa = massa;}

    public int getIdade() {return idade;}
    public void setIdade(int idade) {this.idade = idade;}

    public void brilhar(int brilho) {
        System.out.println("Seu brilho é: " + brilho);
    }
}
