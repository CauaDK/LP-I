package org.example;

import javafx.fxml.FXML;

import java.io.IOException;

public class MainController {

    // Métodos de link

    @FXML
    private void fromImagem1() throws IOException {
        App.setRoot("imagem1");
    }

    @FXML
    private void fromImagem2() throws IOException {
        App.setRoot("imagem2");
    }

    @FXML
    private void fromMusica() throws IOException {
        App.setRoot("musica");
    }

    @FXML
    private void fromVideo() throws IOException {
        App.setRoot("video");
    }

}
