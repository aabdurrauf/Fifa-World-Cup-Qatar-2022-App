package com.example.spormusabakatakipuygulamasi;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class MaclarController {
    @FXML TableView<Matches> maclar_tablosu = new TableView<>();
    @FXML
    TableColumn<Matches, String> Ateam = new TableColumn<>();
    @FXML
    TableColumn<Matches, String> Bteam = new TableColumn<>();
    @FXML
    TableColumn<Matches, String> date_score = new TableColumn<>();

    public MaclarController() {}

    public void setTable(ObservableList<Matches> data) {
        maclar_tablosu.setItems(data);
        Ateam.setCellValueFactory(new PropertyValueFactory<>("teamA"));
        Bteam.setCellValueFactory(new PropertyValueFactory<>("teamB"));
        date_score.setCellValueFactory(new PropertyValueFactory<>("scoreboard"));
    }

    public void GrupMaclari() {
        ObservableList<Matches> data = FXCollections.observableArrayList(ReadFile.groupMatches);
        setTable(data);
    }

    public void KnockOutMaclari() {
        ObservableList<Matches> data = FXCollections.observableArrayList(ReadFile.knockOutMatches);
        setTable(data);
    }
}
