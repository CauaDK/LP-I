package org.example;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.CheckBox;
import org.example.Imagem1.Mala;
import org.example.Imagem1.Pessoa;
import org.example.Imagem1.Planta;
import org.example.functions.Report;
import org.example.functions.SaveCSV;

import java.io.IOException;

public class Imagem1Controller {

    SaveCSV csv = new SaveCSV();
    Report report = new Report();

    // Inputs Mala
    @FXML private TextField malaCapacidade;
    @FXML private TextField malaMaterial;
    @FXML private TextField malaPeso;

    // Inputs Pessoa
    @FXML private TextField pessoaAltura;
    @FXML private TextField pessoaPeso;
    @FXML private TextField pessoaSexo;

    // Inputs Planta
    @FXML private TextField plantaTamanho;
    @FXML private TextField plantaCor;
    @FXML private CheckBox plantaCortada;

    // Métodos de criação

    String folder = "Imagem1";

    @FXML
    private void criarMala() {
        if (malaCapacidade.getText() == "" || malaMaterial.getText() == "" || malaPeso.getText() == "") {
            report.mostrarErro("Preencha todos os campos!!");
        } else {
            try {
                double capacidade = Double.parseDouble(malaCapacidade.getText());
                String material = malaMaterial.getText();
                double peso = Double.parseDouble(malaPeso.getText());
                Mala mala = new Mala(capacidade, material, peso);
                String strClass = mala.getCapacidade() + "," + mala.getMaterial() + "," + mala.getPeso();
                csv.salvarCSV(strClass, "mala", folder);
                report.alerta(strClass + " foi criada com sucesso");
            } catch (NumberFormatException e) {
                report.mostrarErro("Preencha os campos da Mala corretamente!");
            }
        }
    }

    @FXML
    private void criarPessoa() {
        if (pessoaAltura.getText() == "" || pessoaPeso.getText() == "" || pessoaSexo.getText() == "") {
            report.mostrarErro("Preencha todos os campos!!");
        } else {
            try {
                double altura = Double.parseDouble(pessoaAltura.getText());
                double peso = Double.parseDouble(pessoaPeso.getText());
                String sexo = pessoaSexo.getText();
                Pessoa pessoa = new Pessoa(altura, peso, sexo);
                String strClass = pessoa.getAltura() + "," + pessoa.getPeso() + "," + pessoa.getSexo();
                csv.salvarCSV(strClass, "pessoa", folder);
                report.alerta(strClass + " foi criada com sucesso");
            } catch (NumberFormatException e) {
                report.mostrarErro("Preencha os campos da Pessoa corretamente!");
            }
        }
    }



    @FXML
    private void criarPlanta() {
        if (plantaTamanho.getText() == "" || plantaCor.getText() == "") {
            report.mostrarErro("Preencha todos os campos!!");
        } else {
            try {
                double tamanho = Double.parseDouble(plantaTamanho.getText());
                String cor = plantaCor.getText();
                boolean cortada = plantaCortada.isSelected();
                Planta planta = new Planta(tamanho, cortada, cor);
                String strClass = planta.getTamanho() + "," + planta.getCortada() + "," + planta.getCor();
                csv.salvarCSV(strClass, "planta", folder);
                report.alerta(strClass + " foi criada com sucesso");
            } catch (NumberFormatException e) {
                report.mostrarErro("Preencha os campos da Planta corretamente!");
            }
        }
    }

    @FXML
    private void voltar() throws IOException {
        App.setRoot("main");
    }
}
