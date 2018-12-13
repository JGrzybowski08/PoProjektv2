package sample.Java;

import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class magazynController implements Initializable {

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
