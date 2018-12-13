package sample.Java;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import java.io.*;

public class logowanieController implements Initializable {

    private Scene glownaScene;

    public void setGlownaScene(Scene scene){
        glownaScene = scene;
    }

    public void openGlownaScene(ActionEvent actionEvent){
        Stage primaryScene = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        primaryScene.setScene(glownaScene);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }


}

