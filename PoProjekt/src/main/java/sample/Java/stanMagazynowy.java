package sample.Java;
import javafx.application.Application;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import sample.Java.dbController;

import java.sql.*;
import java.util.ArrayList;
import java.util.TimeZone;

//Author: Yerbol
//SQL database "sqlbase_schema" contains a Table "sqlbase_table" with 3 columns: "id" (Integer(INT(11))), "name" (String(VARCHAR(45))), "married" (Boolean(TINYINT(1)));

public class stanMagazynowy extends Application {
    private TableView<Mag> tableView = new TableView<>();

    @Override
    public void start(Stage primaryStage) throws SQLException, ClassNotFoundException {
        //Show window
        buildData();
        Parent root = tableView;
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }

    public void buildData() throws ClassNotFoundException, SQLException {
        Connection conn = dbController.connect();
        String select = "SELECT * FROM towar";


        //Extracting data from Databasee
        ResultSet resultSet = null;
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(select);
            resultSet = preparedStatement.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        ObservableList dbData = FXCollections.observableArrayList(dataBaseArrayList(resultSet));

        //Giving readable names to columns
        for(int i=0 ; i<resultSet.getMetaData().getColumnCount(); i++) {
            TableColumn column = new TableColumn<>();
            switch (resultSet.getMetaData().getColumnName(i+1)) {
                case "Id":
                    column.setText("ID #");
                    break;
                case "Nazwa":
                    column.setText("Nazwa");
                    break;
                case "Ilosc":
                    column.setText("Ilosc");
                    break;
                case "Miejsce":
                    column.setText("Miejsce");
                    break;
                default: column.setText(resultSet.getMetaData().getColumnName(i+1)); //if column name in SQL Database is not found, then TableView column receive SQL Database current column name (not readable)
                    break;
            }
            column.setCellValueFactory(new PropertyValueFactory<>(resultSet.getMetaData().getColumnName(i+1))); //Setting cell property value to correct variable from Person class.
            tableView.getColumns().add(column);
        }

        //Filling up tableView with data
        tableView.setItems(dbData);
    }

    public class Mag {

        IntegerProperty id = new SimpleIntegerProperty(); //variable names should be exactly as column names in SQL Database Table. In case if you want to use <int> type instead of <IntegerProperty>, then you need to use getter/setter procedures instead of xxxProperty() below
        StringProperty Nazwa = new SimpleStringProperty();
        IntegerProperty Ilosc = new SimpleIntegerProperty();
        StringProperty Miejsce = new SimpleStringProperty();

        public IntegerProperty idProperty() { //name should be exactly like this [IntegerProperty variable name (id) + (Property) = idProperty] (case sensitive)
            return id;
        }

        public StringProperty nazwaProperty() {
            return Nazwa;
        }

        public IntegerProperty iloscProperty() {
            return Ilosc;
        }
        public StringProperty miejsceProperty() {
            return Miejsce;
        }


        public Mag(int idValue, String nazwaValue, int iloscValue, String miejsceValue) {
            id.set(idValue);
            Nazwa.set(nazwaValue);
            Ilosc.set(iloscValue);
            Miejsce.set(miejsceValue);
        }

        Mag(){}
    }

    //extracting data from ResulSet to ArrayList
    private ArrayList dataBaseArrayList(ResultSet resultSet) throws SQLException {
        ArrayList<Mag> data =  new ArrayList<>();
        while (resultSet.next()) {
            Mag magazyn = new Mag();
            magazyn.id.set(resultSet.getInt("ID"));
            magazyn.Nazwa.set(resultSet.getString("Nazwa"));
            magazyn.Ilosc.set(resultSet.getInt("Ilosc"));
            magazyn.Nazwa.set(resultSet.getString("Miejsce"));
            data.add(magazyn);
        }
        return data;
    }

    public static void main(String[] args) {
        launch(args);
    }
}