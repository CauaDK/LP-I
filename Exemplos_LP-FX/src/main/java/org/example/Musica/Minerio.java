package org.example.Musica;

public class Minerio {
    double dureza;
    double pureza;
    String raridade;

    public Minerio(double dureza, double pureza, String raridade) {
        this.dureza = dureza;
        this.pureza = pureza;
        this.raridade = raridade;
    }

    public double getDureza() {
        return dureza;
    }
    public double getPureza() {
        return pureza;
    }
    public String getRaridade() {
        return raridade;
    }

    public void refinar(boolean refinado) {
        if (refinado) {
            System.out.println("Minerio refinado");
        } else{
            System.out.println("Minerio não refinado");
        }
    }
}
