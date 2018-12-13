package sample.Java;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.ResourceBundle;

public class rejestracjaController implements Initializable {
    ObservableList<String> stanowiskoList = FXCollections.observableArrayList("Kierownik", "Magazyn", "Pakownia", "Wysylka");
    public ChoiceBox<String> stanowiskoBox = new ChoiceBox<String>();

    @FXML
    public TextField login;
    public TextField haslo;
    public TextField imie;
    public TextField nazwisko;
    public TextField pesel;
    public DatePicker dataur;
    public TextField miasto;
    public TextField nrdomu;
    public TextField nrmieszkania;

    public void buttonRejestracja(ActionEvent actionEvent) throws SQLException {
        String loginGet = login.getText();
        String hasloGet = haslo.getText();
        String stanowiskoGet = stanowiskoBox.getValue();
        String imieGet = imie.getText();
        String nazwiskoGet = nazwisko.getText();
        int peselGet = Integer.parseInt(pesel.getText());
        String miastoGet = miasto.getText();
        int nrdomuGet = Integer.parseInt(nrdomu.getText());
        int nrmieszkaniaGet = Integer.parseInt(nrmieszkania.getText());

        Connection conn = dbController.connect();


        String sql = "INSERT INTO pracownicy(imie, nazwisko, m_zamieszkania, stanowisko) VALUES (?, ?, ?, ?);";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, loginGet);
        pstmt.setString(2, hasloGet);
        pstmt.setString(3, stanowiskoGet);
        pstmt.setString(4, imieGet);
        pstmt.setString(5, nazwiskoGet);
        pstmt.setInt(6, peselGet);
        pstmt.setDate(7, dataur.getValue());
        pstmt.setString(8, miastoGet);
        pstmt.setInt(9, nrdomuGet);
        pstmt.setInt(10, nrmieszkaniaGet);

        pstmt.execute();
        conn.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //stanowiskoBox.setValue("Kierownik");
        stanowiskoBox.setItems(stanowiskoList);


    }
}
