package org.example.model;

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
    public void setDureza(double dureza) {this.dureza = dureza;}
    public double getPureza() {
        return pureza;
    }
    public void setPureza(double pureza) {this.pureza = pureza;}
    public String getRaridade() {
        return raridade;
    }
    public void setRaridade(String raridade) {this.raridade = raridade;}

    public void refinar(boolean refinado) {
        if (refinado) {
            System.out.println("Minerio refinado");
        } else{
            System.out.println("Minerio não refinado");
        }
    }
}
