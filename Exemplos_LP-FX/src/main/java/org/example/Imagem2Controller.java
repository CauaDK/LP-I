package org.example;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.example.Imagem2.Animal;
import org.example.Imagem2.Imovel;
import org.example.Imagem2.Veiculo;
import org.example.functions.Report;
import org.example.functions.SaveCSV;

import java.io.IOException;

public class Imagem2Controller {

    SaveCSV csv = new SaveCSV();
    Report report = new Report();

    // Inputs Animal
    @FXML private TextField animalEspecie;
    @FXML private TextField animalIdade;
    @FXML private TextField animalPeso;

    // Inputs Imovel
    @FXML private TextField imovelTamanho;
    @FXML private TextField imovelEndereco;
    @FXML private TextField imovelCor;

    // Inputs Veiculo
    @FXML private TextField veiculoModelo;
    @FXML private TextField veiculoCor;
    @FXML private TextField veiculoVelocidade;

    // Métodos de criação

    String folder = "Imagem2";

    @FXML
    private void criarAnimal() {
        if (animalEspecie.getText() == "" || animalIdade.getText() == "" || animalPeso.getText() == "") {
            report.mostrarErro("Preencha todos os campos!!");
        } else {
            try {
                String especie = animalEspecie.getText();
                int idade = Integer.parseInt(animalIdade.getText());
                double peso = Double.parseDouble(animalPeso.getText());
                Animal animal = new Animal(especie, idade, peso);
                String strClass = animal.getEspecie() + "," + animal.getIdade() + "," + animal.getPeso();
                csv.salvarCSV(strClass, "animal", folder);
                report.alerta(strClass + " foi criada com sucesso");
            } catch (NumberFormatException e) {
                report.mostrarErro("Preencha os campos de Animal corretamente!");
            }
        }
    }

    @FXML
    private void criarImovel() {
        if (imovelTamanho.getText() == "" || imovelEndereco.getText() == "" || imovelCor.getText() == "") {
            report.mostrarErro("Preencha todos os campos!!");
        } else {
            try {
                double tamanho = Double.parseDouble(imovelTamanho.getText());
                String endereco = imovelEndereco.getText();
                String cor = imovelCor.getText();
                Imovel imovel = new Imovel(tamanho, endereco, cor);
                String strClass = imovel.getTamanho() + "," + imovel.getEndereco() + "," + imovel.getCor();
                csv.salvarCSV(strClass, "imovel", folder);
                report.alerta(strClass + " foi criada com sucesso");
            } catch (NumberFormatException e) {
                report.mostrarErro("Preencha os campos de Imovel corretamente!");
            }
        }
    }



    @FXML
    private void criarVeiculo() {
        if (veiculoModelo.getText() == "" || veiculoCor.getText() == "" || veiculoVelocidade.getText() == "") {
            report.mostrarErro("Preencha todos os campos!!");
        } else {
            try {
                String modelo = veiculoModelo.getText();
                String cor = veiculoCor.getText();
                int maxvelocidade = Integer.parseInt(veiculoVelocidade.getText());
                Veiculo veiculo = new Veiculo(modelo, cor, maxvelocidade);
                String strClass = veiculo.getModelo() + "," + veiculo.getCor() + "," + veiculo.getMaxVelocidade();
                csv.salvarCSV(strClass, "veiculo", folder);
                report.alerta(strClass + " foi criada com sucesso");
            } catch (NumberFormatException e) {
                report.mostrarErro("Preencha os campos de Veiculo corretamente!");
            }
        }
    }

    @FXML
    private void voltar() throws IOException {
        App.setRoot("main");
    }
}
