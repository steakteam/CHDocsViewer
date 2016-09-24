package me.itstake.chdocsviewer;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuBar;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private MenuBar menuBar;

    public void menuBarInit() {
        menuBar.setUseSystemMenuBar(true);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        menuBarInit();
    }
}
