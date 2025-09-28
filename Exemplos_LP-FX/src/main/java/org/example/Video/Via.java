package org.example.Video;

public class Via {
    String tipo;
    int comprimento;
    boolean paviamento;

    public Via(String tipo, int comprimento, boolean paviamento) {
        this.tipo = tipo;
        this.comprimento = comprimento;
        this.paviamento = paviamento;
    }

    public String getTipo() {
        return tipo;
    }
    public int getComprimento() {
        return comprimento;
    }
    public boolean getPaviamento() {
        return paviamento;
    }

    public void addCasa(int casa) {
        System.out.println("Mais " + casa + " na via");
    }
    public void mostrarLocal(String local) {
        System.out.println("Você está em: " + local);
    }
    public void pavimentar(boolean paviamento) {
        if(paviamento) {
            System.out.println("via está pavimentada");
        } else {
            System.out.println("via não está pavimentada");
        }
    }
}
