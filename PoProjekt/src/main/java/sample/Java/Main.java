package sample.Java;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader logowanieLoader = new FXMLLoader(getClass().getResource("/Logowanie.fxml"));
        Parent logowanie = logowanieLoader.load();
        Scene logowanieScene = new Scene(logowanie);

        FXMLLoader glownaLoader = new FXMLLoader(getClass().getResource("/glownyRoot.fxml"));
        Parent glowna = glownaLoader.load();
        Scene glownaScene = new Scene(glowna);



        logowanieController logowanieController = logowanieLoader.getController();
        logowanieController.setGlownaScene(glownaScene);

        primaryStage.setScene(logowanieScene);
        //primaryStage.setMaximized(true);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }{}


}

