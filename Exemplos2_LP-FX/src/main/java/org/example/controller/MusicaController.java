package org.example.controller;

import javafx.event.ActionEvent;
import org.example.dao.EstrelaDAO;
import org.example.dao.MinerioDAO;
import org.example.dao.RoupaDAO;
import org.example.model.Estrela;
import org.example.model.Minerio;
import org.example.model.Roupa;
import org.example.services.Alert;

import javafx.fxml.FXML;
import javafx.scene.control.*;


public class MusicaController {

    Alert alert = new Alert();

    @FXML
    private TextField txtTemperatura, txtMassa, txtIdade;
    @FXML
    private TextField txtDureza, txtPureza;
    @FXML
    private ComboBox<String> txtRaridade;
    @FXML
    private TextField txtTamanho, txtCor, txtTecido;

    @FXML
    private Button btnEstrela, btnMinerio, btnRoupa;

    private EstrelaDAO estrelaDAO = new EstrelaDAO();
    private MinerioDAO minerioDAO = new MinerioDAO();
    private RoupaDAO roupaDAO = new RoupaDAO();

    @FXML
    public void initialize() {
        estrelaDAO.createTableIfNotExists();
        minerioDAO.createTableIfNotExists();
        roupaDAO.createTableIfNotExists();
    }

    @FXML
    private void adicionar(ActionEvent event) {
        Object tipo = event.getSource();
        if (tipo == btnEstrela) {
            if (txtTemperatura.getText() == "" || txtMassa.getText() == "" || txtIdade.getText() == "") {
                alert.erroAlert("Preencha todos os campos!!");
            } else {
                try {
                    double temperatura = Double.parseDouble(txtTemperatura.getText());
                    double massa = Double.parseDouble(txtMassa.getText());
                    int idade = Integer.parseInt(txtIdade.getText());
                    estrelaDAO.inserir(new Estrela(
                                    temperatura,
                                    massa,
                                    idade
                            )
                    );
                    txtTemperatura.clear();
                    txtMassa.clear();
                    txtIdade.clear();
                } catch (NumberFormatException e) {
                    alert.erroAlert("Preencha os campos de Estrela corretamente!");
                }
            }
        } else if (tipo == btnMinerio) {
            if (txtDureza.getText() == "" || txtPureza.getText() == "" || txtRaridade.getValue() == null) {
                alert.erroAlert("Preencha todos os campos!!");
            } else {
                try {
                    double dureza = Double.parseDouble(txtDureza.getText());
                    double pureza = Double.parseDouble(txtPureza.getText());
                    minerioDAO.inserir(new Minerio(
                                    dureza,
                                    pureza,
                                    txtRaridade.getValue()
                            )
                    );
                    txtDureza.clear();
                    txtPureza.clear();
                } catch (NumberFormatException e) {
                    alert.erroAlert("Preencha os campos de Minerio corretamente!");
                }
            }
        } else if (tipo == btnRoupa) {
            if (txtTamanho.getText() == "" || txtCor.getText() == "" || txtTecido.getText() == "") {
                alert.erroAlert("Preencha todos os campos!!");
            } else {
                try {
                    double tamanho = Double.parseDouble(txtTamanho.getText());
                    roupaDAO.inserir(new Roupa(
                                    tamanho,
                                    txtCor.getText(),
                                    txtTecido.getText()
                            )
                    );
                    txtTamanho.clear();
                    txtCor.clear();
                    txtTecido.clear();
                } catch (NumberFormatException e) {
                    alert.erroAlert("Preencha os campos de Roupa corretamente!");
                }
            }
        } else {
            alert.erroAlert("Tabela inexistente");
        }
    }
}
