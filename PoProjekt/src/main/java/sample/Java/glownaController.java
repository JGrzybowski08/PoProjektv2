package sample.Java;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URL;

import java.util.ResourceBundle;
import javafx.event.ActionEvent;

import javafx.fxml.Initializable;

import javafx.scene.Scene;

import javafx.stage.Stage;

import java.lang.*;



public class glownaController implements Initializable {



    public void menuRejestracja(ActionEvent actionEvent) throws IOException {
        //Stage stage = null;
        FXMLLoader rejestracjaLoader = new FXMLLoader(getClass().getResource("/rejestracja.fxml"));
        Parent rejestracja = (Parent) rejestracjaLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(rejestracja));
        stage.show();
    }

    public void menuStanMagazynowy(ActionEvent actionEvent) throws IOException {
        FXMLLoader stanMagazynowyLoader = new FXMLLoader(getClass().getResource("/stanMagazynowy.fxml"));
        Parent stanMagazynowy = (Parent) stanMagazynowyLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(stanMagazynowy));;
        stage.show();
    }




       /* @Override
        public void start(Stage stage) throws Exception {
            //TableView
            tableView = new TableView();
            buildData();

            //Main Scene
            Scene scene = new Scene(tableView);

            stage.setScene(scene);
            stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                @Override
                public void handle(WindowEvent event) {
                    Platform.exit();
                    System.exit(0);
                }
            });
            stage.show();
        }
    }*/

    @Override
    public void initialize(URL url, ResourceBundle rb) {



    }
}