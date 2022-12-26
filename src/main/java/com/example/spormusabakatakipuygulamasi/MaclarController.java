package com.example.spormusabakatakipuygulamasi;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class MaclarController {
    @FXML TableView<Matches> maclar_tablosu = new TableView<>();
    @FXML TableColumn Ateam = new TableColumn();
    @FXML TableColumn Bteam = new TableColumn();
    @FXML TableColumn date_score = new TableColumn();

    public MaclarController() {}

    public void setTable(ObservableList<Matches> data) {
        maclar_tablosu.setItems(data);
        Ateam.setCellValueFactory(new PropertyValueFactory<Matches, String>("teamA"));
        Bteam.setCellValueFactory(new PropertyValueFactory<Matches, String>("teamB"));
        date_score.setCellValueFactory(new PropertyValueFactory<Matches, String>("scoreboard"));
    }

    public void GrupMaclari(ActionEvent actionEvent) {
        ObservableList<Matches> data = FXCollections.observableArrayList(ReadFile.groupMatches);
        setTable(data);
    }

    public void KnockOutMaclari(ActionEvent actionEvent) {
        ObservableList<Matches> data = FXCollections.observableArrayList(ReadFile.knockOutMatches);
        setTable(data);
    }
}
