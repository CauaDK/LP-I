package org.example.Imagem2;

public class Animal {
    String especie;
    int idade;
    double peso;

    public Animal(String especie, int idade, double peso) {
        this.especie = especie;
        this.idade = idade;
        this.peso = peso;
    }

    public String getEspecie() {
        return especie;
    }
    public int  getIdade() {
        return idade;
    }
    public double getPeso() {
        return peso;
    }

    public void comer(int qnt) {
        System.out.println("o animal comer " + qnt + " vezes");
    }
    public void dormir(int tempo) {
        System.out.println("o animal dourmiu por " + tempo + " horas");
    }
    public void andar(double metros) {
        System.out.println("o animal andou " + metros + " metros");
    }
}
