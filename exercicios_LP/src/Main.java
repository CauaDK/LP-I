import Musica.Estrela;
import Musica.Roupa;
import Musica.Minerio;

import Imagem1.Pessoa;
import Imagem1.Mala;
import Imagem1.Planta;

import Imagem2.Animal;
import Imagem2.Imovel;
import Imagem2.Veiculo;

import Video.Arma;
import Video.Via;
import Video.Monstro;

public class Main {
    public static void main(String[] args) {
        System.out.println("-----Musica-----");
        Estrela sol = new Estrela(7000, 10000, 356937693);
        sol.brilhar(800);
        Roupa camisa = new Roupa(50, "preto", "algodão");
        camisa.lavar(false);
        Minerio diamante = new Minerio(9.6, 6.1, "Muito raro");
        diamante.refinar(true);

        System.out.println("-----Imagem1-----");
        Pessoa jorge = new Pessoa(1.80, 60.2, "Masculino");
        jorge.andar(1.8);
        Mala maleta = new Mala(5.3, "couro", 0.7);
        maleta.abrir(true);
        Planta grama = new Planta(3, true, "verde");
        grama.crescer(10);

        System.out.println("-----Imagem2-----");
        Veiculo carro = new Veiculo("Polo", "preto", 200);
        carro.acelerar(50);
        carro.frear(30);
        carro.pintar("laranja");
        Animal leao = new Animal("felino", 6, 5.7);
        leao.comer(12);
        leao.dormir(7);
        leao.andar(968.4);
        Imovel predio = new Imovel(6, "Rua logo ali", "verde");
        predio.pintar("azul");
        predio.maisAndar(2);
        predio.novoEndereco("Rua depois dali");

        System.out.println("-----Video-----");
        Arma rifle = new Arma("fuzil", 2, 1000);
        rifle.atirar(90);
        rifle.recarregar(5);
        rifle.quebrar(true);
        Monstro zumbi = new Monstro("zumbi", 2, 9);
        zumbi.correr(60);
        zumbi.pular(7);
        zumbi.atacar(12);
        Via rua = new Via("rua", 73, true);
        rua.addCasa(6);
        rua.mostrarLocal("Rua logo ali");
        rua.pavimentar(true);
    }
}