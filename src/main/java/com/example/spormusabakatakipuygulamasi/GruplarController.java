package com.example.spormusabakatakipuygulamasi;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
    @FXML
    TableColumn<Country, String> nameColumn = new TableColumn<>();
    @FXML
    TableColumn<Country, String> pointColumn = new TableColumn<>();
    @FXML
    TableColumn<Country, String> win = new TableColumn<>();
    @FXML
    TableColumn<Country, String> lose = new TableColumn<>();
    @FXML
    TableColumn<Country, String> draw = new TableColumn<>();
    @FXML
    TableColumn<Country, String> goalscored = new TableColumn<>();
    @FXML
    TableColumn<Country, String> goalconceded = new TableColumn<>();
    @FXML
    TableColumn<Matches, String> Ateam2 = new TableColumn<>();
    @FXML
    TableColumn<Matches, String> Bteam2 = new TableColumn<>();
    @FXML
    TableColumn<Matches, String> date_score2 = new TableColumn<>();
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
                    countryName.substring(1,countryName.length()) + ".png"));
        }
    }

    public void setTable(ObservableList<Country> data){
        countries.setItems(data);

        nameColumn.setCellValueFactory(new PropertyValueFactory<>("countryName"));
        pointColumn.setCellValueFactory(new PropertyValueFactory<>("points"));
        win.setCellValueFactory(new PropertyValueFactory<>("win"));
        draw.setCellValueFactory(new PropertyValueFactory<>("draw"));
        lose.setCellValueFactory(new PropertyValueFactory<>("lose"));
        goalscored.setCellValueFactory(new PropertyValueFactory<>("goalsScored"));
        goalconceded.setCellValueFactory(new PropertyValueFactory<>("goalsConceded"));
    }

    public void setTable2(ObservableList<Matches> data) {
        maclar_tablosu2.setItems(data);
        Ateam2.setCellValueFactory(new PropertyValueFactory<>("teamA"));
        Bteam2.setCellValueFactory(new PropertyValueFactory<>("teamB"));
        date_score2.setCellValueFactory(new PropertyValueFactory<>("scoreboard"));
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

    public void AGrubMenu() throws FileNotFoundException {
        setGroup("A", 0);
    }

    public void BGrubMenu() throws FileNotFoundException {
        setGroup("B", 1);
    }

    public void CGrubMenu() throws FileNotFoundException {
        setGroup("C", 2);
    }

    public void DGrubMenu() throws FileNotFoundException {
        setGroup("D", 3);
    }

    public void EGrubMenu() throws FileNotFoundException {
        setGroup("E", 4);
    }

    public void FGrubMenu() throws FileNotFoundException {
        setGroup("F", 5);
    }

    public void GGrubMenu() throws FileNotFoundException {
        setGroup("G", 6);
    }

    public void HGrubMenu() throws FileNotFoundException {
        setGroup("H", 7);
    }
}
