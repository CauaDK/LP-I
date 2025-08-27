package Musica;

public class Minerio {
    double dureza;
    double pureza;
    String raridade;

    public Minerio(double dureza, double pureza, String raridade) {
        this.dureza = dureza;
        this.pureza = pureza;
        this.raridade = raridade;
    }

    public void refinar(boolean refinado) {
        if (refinado) {
            System.out.println("Minerio refinado");
        } else{
            System.out.println("Minerio não refinado");
        }
    }
}
