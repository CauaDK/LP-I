package Imagem1;

public class Pessoa {
    double altura;
    double peso;
    String sexo;

    public Pessoa(double altura, double peso, String sexo) {
        this.altura = altura;
        this.peso = peso;
        this.sexo = sexo;
    }

    public void andar(double metros) {
        System.out.println("andou " + metros + " metros");
    }
}
