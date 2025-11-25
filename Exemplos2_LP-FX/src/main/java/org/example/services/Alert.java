package org.example.services;

public class Alert {

    public void sucessoAlert(){
        javafx.scene.control.Alert alert = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.CONFIRMATION);
        alert.setTitle("Item adicionado com sucesso!");
        alert.setHeaderText(null);
        alert.setContentText("Ja armazenado no banco!!");
        alert.showAndWait();
    }

    public void erroAlert(String text){
        javafx.scene.control.Alert alert = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.ERROR);
        alert.setTitle("Erro ao adiconar item!");
        alert.setHeaderText(null);
        alert.setContentText(text);
        alert.showAndWait();
    }
}
