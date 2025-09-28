package org.example.functions;

import javafx.scene.control.Alert;

public class Report {
    public void mostrarErro(String mensagem) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erro de entrada");
        alert.setContentText(mensagem);
        alert.showAndWait();
    }

    public void alerta(String mensagem) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Objeto armazenado");
        alert.setContentText(mensagem);
        alert.showAndWait();
    }
}
