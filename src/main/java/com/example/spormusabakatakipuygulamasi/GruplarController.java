package com.example.spormusabakatakipuygulamasi;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class GruplarController {
    @FXML Text group_name;
    @FXML TableView<Country> countries = new TableView<>();
    @FXML TableView<Matches> maclar_tablosu2 = new TableView<>();
    @FXML TableColumn nameColumn = new TableColumn();
    @FXML TableColumn pointColumn = new TableColumn();
    @FXML TableColumn win = new TableColumn();
    @FXML TableColumn lose = new TableColumn();
    @FXML TableColumn draw = new TableColumn();
    @FXML TableColumn goalscored = new TableColumn();
    @FXML TableColumn goalconceded = new TableColumn();
    @FXML TableColumn Ateam2 = new TableColumn();
    @FXML TableColumn Bteam2 = new TableColumn();
    @FXML TableColumn date_score2 = new TableColumn();
    @FXML TextArea country01;
    @FXML TextArea country02;
    @FXML TextArea country03;
    @FXML TextArea country04;
    @FXML ImageView flag1;
    @FXML ImageView flag2;
    @FXML ImageView flag3;
    @FXML ImageView flag4;
    File directory = new File("D:\\Programming\\Java\\SporMusabakaTakipUygulamasi\\src\\main\\data_resources");
    File[] fileList = directory.listFiles();

    public void setTextToTextArea(ArrayList<TextArea> countryInfoList, ArrayList<ImageView> flags, int a) throws FileNotFoundException {

        assert fileList != null;
        for(int i = 0; i < 4; i++) {
            Scanner scanner = new Scanner(fileList[i + a]);
            StringBuilder textRead = new StringBuilder(scanner.nextLine());
            while (scanner.hasNext()) {
                textRead.append("\n");
                textRead.append(scanner.nextLine());
            }
            countryInfoList.get(i).setText(textRead.toString());
            scanner.close();
        }
        for (int i = 0; i < 4; i++){
            Scanner scanner = new Scanner(fileList[i + a]);
            scanner.next();
            StringBuilder countryName = new StringBuilder(scanner.nextLine());
            flags.get(i).setImage(new Image("D:\\Programming\\Java\\SporMusabakaTakipUygulamasi\\src\\main\\resources\\" +
                    countryName.substring(1,countryName.length()).toString() + ".png"));

        }
    }

    public void setTable(ObservableList<Country> data){
        countries.setItems(data);

        nameColumn.setCellValueFactory(new PropertyValueFactory<Country, String>("countryName"));
        pointColumn.setCellValueFactory(new PropertyValueFactory<Country, String>("points"));
        win.setCellValueFactory(new PropertyValueFactory<Country, String>("win"));
        draw.setCellValueFactory(new PropertyValueFactory<Country, String>("draw"));
        lose.setCellValueFactory(new PropertyValueFactory<Country, String>("lose"));
        goalscored.setCellValueFactory(new PropertyValueFactory<Country, String>("goalsScored"));
        goalconceded.setCellValueFactory(new PropertyValueFactory<Country, String>("goalsConceded"));
    }

    public void setTable2(ObservableList<Matches> data) {
        maclar_tablosu2.setItems(data);
        Ateam2.setCellValueFactory(new PropertyValueFactory<Matches, String>("teamA"));
        Bteam2.setCellValueFactory(new PropertyValueFactory<Matches, String>("teamB"));
        date_score2.setCellValueFactory(new PropertyValueFactory<Matches, String>("scoreboard"));
    }

    public void setGroup (String groupName, int groupNumber) throws FileNotFoundException {
        group_name.setText(groupName + " Grubu");
        ArrayList<TextArea> countryInfoList = new ArrayList<>();
        ArrayList<ImageView> flags = new ArrayList<>();
        countryInfoList.add(country01);
        countryInfoList.add(country02);
        countryInfoList.add(country03);
        countryInfoList.add(country04);
        flags.add(flag1);
        flags.add(flag2);
        flags.add(flag3);
        flags.add(flag4);
        ObservableList<Country> data1 = FXCollections.observableArrayList(ReadFile.groups.get(groupNumber).getCountryList());
        ObservableList<Matches> data2 = FXCollections.observableArrayList(ReadFile.groups.get(groupNumber).getMatchesList());
        setTable(data1);
        setTable2(data2);
        setTextToTextArea(countryInfoList, flags, groupNumber*4);
    }

    public void AGrubMenu(ActionEvent actionEvent) throws FileNotFoundException {
        setGroup("A", 0);
    }

    public void BGrubMenu(ActionEvent actionEvent) throws FileNotFoundException {
        setGroup("B", 1);
    }

    public void CGrubMenu(ActionEvent actionEvent) throws FileNotFoundException {
        setGroup("C", 2);
    }

    public void DGrubMenu(ActionEvent actionEvent) throws FileNotFoundException {
        setGroup("D", 3);
    }

    public void EGrubMenu(ActionEvent actionEvent) throws FileNotFoundException {
        setGroup("E", 4);
    }

    public void FGrubMenu(ActionEvent actionEvent) throws FileNotFoundException {
        setGroup("F", 5);
    }

    public void GGrubMenu(ActionEvent actionEvent) throws FileNotFoundException {
        setGroup("G", 6);
    }

    public void HGrubMenu(ActionEvent actionEvent) throws FileNotFoundException {
        setGroup("H", 7);
    }
}
