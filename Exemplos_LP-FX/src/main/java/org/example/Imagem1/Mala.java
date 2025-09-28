package org.example.Imagem1;

public class  Mala {
    double capacidade;
    String material;
    double peso;

    public Mala(double capacidade, String material, double peso) {
        this.capacidade = capacidade;
        this.material = material;
        this.peso = peso;
    }

    public double getCapacidade() {
        return capacidade;
    }
    public String getMaterial() {
        return material;
    }
    public double getPeso() {
        return peso;
    }

    public String abrir(boolean aberto) {
        if (aberto) {
            return "Mala aberta";
        }else {
            return "Mala fechada";
        }
    }
}
