package org.example;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import org.example.Musica.Estrela;
import org.example.Musica.Minerio;
import org.example.Musica.Roupa;
import org.example.functions.Report;
import org.example.functions.SaveCSV;

import javax.swing.*;
import java.io.IOException;

public class MusicaController {

    SaveCSV csv = new SaveCSV();
    Report report = new Report();

    // Inputs Estrela
    @FXML private TextField musicaTemperatura;
    @FXML private TextField musicaMassa;
    @FXML private TextField musicaIdade;

    // Inputs Minerio
    @FXML private TextField minerioDureza;
    @FXML private TextField minerioPureza;
    @FXML private ComboBox<String> minerioRaridade;

    // Inputs Roupa
    @FXML private TextField roupaTamanho;
    @FXML private TextField roupaCor;
    @FXML private TextField roupaTecido;

    // Métodos de criação

    String folder = "Musica";

    @FXML
    private void criarEstrela() {
        if (musicaTemperatura.getText() == "" || musicaMassa.getText() == "" || musicaIdade.getText() == "") {
            report.mostrarErro("Preencha todos os campos!!");
        } else {
            try {
                double temperatura = Double.parseDouble(musicaTemperatura.getText());
                double massa = Double.parseDouble(musicaMassa.getText());
                int idade = Integer.parseInt(musicaIdade.getText());
                Estrela estrela = new Estrela(temperatura, massa, idade);
                String strClass = estrela.getTemperatura() + "," + estrela.getMassa() + "," + estrela.getIdade();
                csv.salvarCSV(strClass, "estrela", folder);
                report.alerta(strClass + " foi criada com sucesso");
            } catch (NumberFormatException e) {
                report.mostrarErro("Preencha os campos da Estrela corretamente!");
            }
        }
    }

    @FXML
    private void criarMinerio() {
        if (minerioDureza.getText() == "" || minerioPureza.getText() == "" || minerioRaridade.getValue() == null) {
            report.mostrarErro("Preencha todos os campos!!");
        } else {
            try {
                double dureza = Double.parseDouble(minerioDureza.getText());
                double pureza = Double.parseDouble(minerioPureza.getText());
                String raridade = minerioRaridade.getValue();
                Minerio minerio = new Minerio(dureza, pureza, raridade);
                String strClass = minerio.getDureza() + "," + minerio.getPureza() + "," + minerio.getRaridade();
                csv.salvarCSV(strClass, "minerio", folder);
                report.alerta(strClass + " foi criada com sucesso");
            } catch (NumberFormatException e) {
                report.mostrarErro("Preencha os campos da Minerio corretamente!");
            }
        }
    }



    @FXML
    private void criarRoupa() {
        if (roupaTamanho.getText() == "" || roupaCor.getText() == "" || roupaTecido.getText() == "") {
            report.mostrarErro("Preencha todos os campos!!");
        } else {
            try {
                double tamanho = Double.parseDouble(roupaTamanho.getText());
                String cor = roupaCor.getText();
                String tecido = roupaTecido.getText();
                Roupa roupa = new Roupa(tamanho, cor, tecido);
                String strClass = roupa.getTamanho() + "," + roupa.getCor() + "," + roupa.getTecido();
                csv.salvarCSV(strClass, "roupa", folder);
                report.alerta(strClass + " foi criada com sucesso");
            } catch (NumberFormatException e) {
                report.mostrarErro("Preencha os campos da Roupa corretamente!");
            }
        }
    }

    @FXML
    private void voltar() throws IOException {
        App.setRoot("main");
    }
}
