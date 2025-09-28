package org.example.Imagem1;

public class Pessoa {
    double altura;
    double peso;
    String sexo;

    public Pessoa(double altura, double peso, String sexo) {
        this.altura = altura;
        this.peso = peso;
        this.sexo = sexo;
    }

    public double getAltura() {
        return altura;
    }
    public double  getPeso() {
        return peso;
    }
    public String getSexo() {
        return sexo;
    }

    public void andar(double metros) {
        System.out.println("andou " + metros + " metros");
    }

}
