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
    private TextField txtIdEstrela, txtIdMinerio, txtIdRoupa;
    @FXML
    private TextField txtTemperatura, txtMassa, txtIdade;
    @FXML
    private TextField txtDureza, txtPureza;
    @FXML
    private ComboBox<String> txtRaridade;
    @FXML
    private TextField txtTamanho, txtCor, txtTecido;

    @FXML
    private Button btnEstrelaA, btnMinerioA, btnRoupaA;
    @FXML
    private Button btnEstrelaD, btnMinerioD, btnRoupaD;
    @FXML
    private Button btnEstrelaU, btnMinerioU, btnRoupaU;
    @FXML
    private Button btnEstrelaS, btnMinerioS, btnRoupaS;

    @FXML
    private TextArea areaResultado;

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
        if (tipo == btnEstrelaA) {
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
        } else if (tipo == btnMinerioA) {
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
        } else if (tipo == btnRoupaA) {
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

    @FXML
    private void deletar(ActionEvent event) {
        Object tipo = event.getSource();

        if (tipo == btnEstrelaD) {
            if (txtIdEstrela.getText() == "") {
                alert.erroAlert("Preencha o campo ID para atualizar!!");
            } else{
                int id = Integer.parseInt(txtIdEstrela.getText());
                estrelaDAO.deletar(id);
                txtIdEstrela.clear();
                txtTemperatura.clear();
                txtMassa.clear();
                txtIdade.clear();
            }
        } else if (tipo == btnMinerioD) {
            if (txtIdMinerio.getText() == "") {
                alert.erroAlert("Preencha o campo ID para atualizar!!");
            } else {
                int id = Integer.parseInt(txtIdMinerio.getText());
                minerioDAO.deletar(id);
                txtIdMinerio.clear();
                txtDureza.clear();
                txtPureza.clear();
            }
        } else if (tipo == btnRoupaD) {
            if (txtIdRoupa.getText() == "") {
                alert.erroAlert("Preencha o campo ID para atualizar!!");
            } else {
                int id = Integer.parseInt(txtIdRoupa.getText());
                roupaDAO.deletar(id);
                txtIdRoupa.clear();
                txtTamanho.clear();
                txtCor.clear();
                txtTecido.clear();
            }
        }
    }

    @FXML
    private void atualizar(ActionEvent event) {
        Object tipo = event.getSource();

        if (tipo == btnEstrelaU) {
            if (txtIdEstrela.getText() == "") {
                alert.erroAlert("Preencha o campo ID para atualizar!!");
            } else if (txtTemperatura.getText() == "" || txtMassa.getText() == "" || txtIdade.getText() == "") {
                alert.erroAlert("Preencha todos os campos!!");
            } else {
                estrelaDAO.atualizar(
                        new Estrela(
                                Double.parseDouble(txtTemperatura.getText()),
                                Double.parseDouble(txtMassa.getText()),
                                Integer.parseInt(txtIdade.getText())
                        ),
                        Integer.parseInt(txtIdEstrela.getText())
                );
                txtIdEstrela.clear();
                txtTemperatura.clear();
                txtMassa.clear();
                txtIdade.clear();
            }
        } else if (tipo == btnMinerioU) {
            if (txtIdMinerio.getText() == "") {
                alert.erroAlert("Preencha o campo ID para atualizar!!");
            } else if (txtDureza.getText() == "" || txtPureza.getText() == "" || txtRaridade.getValue() == null) {
                alert.erroAlert("Preencha todos os campos!!");
            } else {
                minerioDAO.atualizar(
                        new Minerio(
                                Double.parseDouble(txtDureza.getText()),
                                Double.parseDouble(txtPureza.getText()),
                                txtRaridade.getValue()
                        ),
                        Integer.parseInt(txtIdMinerio.getText())
                );
                txtIdMinerio.clear();
                txtDureza.clear();
                txtPureza.clear();
            }
        } else if (tipo == btnRoupaU) {
            if (txtIdRoupa.getText() == "") {
                alert.erroAlert("Preencha o campo ID para atualizar!!");
            } else if (txtTamanho.getText() == "" || txtCor.getText() == "" || txtTecido.getText() == "") {
                alert.erroAlert("Preencha todos os campos!!");
            } else {
                roupaDAO.atualizar(
                        new Roupa(
                                Double.parseDouble(txtTamanho.getText()),
                                txtCor.getText(),
                                txtTecido.getText()
                        ),
                        Integer.parseInt(txtIdRoupa.getText())
                );
                txtIdRoupa.clear();
                txtTamanho.clear();
                txtCor.clear();
                txtTecido.clear();
            }
        }
    }

    @FXML
    private void seletar(ActionEvent event) {
        Object tipo = event.getSource();

        areaResultado.clear();

        if (tipo == btnEstrelaS) {
            estrelaDAO.listar().forEach(s -> areaResultado.appendText(s + "\n"));
        } else if (tipo == btnMinerioS) {
            minerioDAO.listar().forEach(s -> areaResultado.appendText(s + "\n"));
        } else if (tipo == btnRoupaS) {
            roupaDAO.listar().forEach(s -> areaResultado.appendText(s + "\n"));
        }
    }
}
