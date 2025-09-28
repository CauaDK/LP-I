package org.example;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import org.example.Video.Arma;
import org.example.Video.Monstro;
import org.example.Video.Via;
import org.example.functions.Report;
import org.example.functions.SaveCSV;

import java.io.IOException;

public class VideoController {

    SaveCSV csv = new SaveCSV();
    Report report = new Report();

    // Inputs Arma
    @FXML private TextField armaModelo;
    @FXML private TextField armaComprimento;
    @FXML private TextField armaAlcance;

    // Inputs Monstro
    @FXML private TextField monstroNome;
    @FXML private TextField monstroTamanho;
    @FXML private ComboBox<Integer> monstroPerigo;

    // Inputs Via
    @FXML private ComboBox<String> viaTipo;
    @FXML private TextField viaComprimento;
    @FXML private CheckBox viaPaviamento;

    // Métodos de criação

    String folder = "Video";

    @FXML
    private void criarArma() {
        if (armaModelo.getText() == "" || armaComprimento.getText() == "" || armaAlcance.getText() == "") {
            report.mostrarErro("Preencha todos os campos!!");
        } else {
            try {
                String modelo = armaModelo.getText();
                double comprimento = Double.parseDouble(armaComprimento.getText());
                int alcance = Integer.parseInt(armaAlcance.getText());
                Arma arma = new Arma(modelo, comprimento, alcance);
                String strClass = arma.getModelo() + "," + arma.getComprimento() + "," + arma.getAlcance();
                csv.salvarCSV(strClass, "arma", folder);
                report.alerta(strClass + " foi criada com sucesso");
            } catch (NumberFormatException e) {
                report.mostrarErro("Preencha os campos de Arma corretamente!");
            }
        }
    }

    @FXML
    private void criarMonstro() {
        if (monstroNome.getText() == "" || monstroPerigo.getValue() == null || monstroTamanho.getText() == "") {
            report.mostrarErro("Preencha todos os campos!!");
        } else {
            try {
                String nome = monstroNome.getText();
                double tamanho = Double.parseDouble(monstroTamanho.getText());
                int perigo = monstroPerigo.getValue();
                Monstro monstro = new Monstro(nome, tamanho, perigo);
                String strClass = monstro.getNome() + "," +  monstro.getTamanho() + "," + monstro.getPerigo();
                csv.salvarCSV(strClass, "monstro", folder);
                report.alerta(strClass + " foi criada com sucesso");
            } catch (NumberFormatException e) {
                report.mostrarErro("Preencha os campos de Monstro corretamente!");
            }
        }
    }



    @FXML
    private void criarVia() {
        if (viaTipo.getValue() == null || viaComprimento.getText() == "") {
            report.mostrarErro("Preencha todos os campos!!");
        } else {
            try {
                String tipo = viaTipo.getValue();
                int comprimento = Integer.parseInt(viaComprimento.getText());
                boolean paviamento = viaPaviamento.isSelected();
                Via via = new Via(tipo, comprimento, paviamento);
                String strClass = via.getTipo() + "," + via.getComprimento() + "," + via.getPaviamento();
                csv.salvarCSV(strClass, "via", folder);
                report.alerta(strClass + " foi criada com sucesso");
            } catch (NumberFormatException e) {
                report.mostrarErro("Preencha os campos de Via corretamente!");
            }
        }
    }

    @FXML
    private void voltar() throws IOException {
        App.setRoot("main");
    }
}
