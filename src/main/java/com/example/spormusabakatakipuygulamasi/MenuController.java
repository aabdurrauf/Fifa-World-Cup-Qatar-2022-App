package com.example.spormusabakatakipuygulamasi;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;


public class MenuController {
    public void backPage(){
        try{
            Main.setCenterRoot(Main.getPriorPage());

            Main.setNextPage(Main.getCurrentPage());
            Main.setCurrentPage(Main.getPriorPage());
            Main.setPriorPage(Main.getNextPage());
        }
        catch (NullPointerException e){
            Main.setCenterRoot(Main.getCurrentPage());
        }
    }


    public void anasayfaMenu() {
        try {
            AnchorPane anasayfa = FXMLLoader.load(getClass().getResource("anasayfa.fxml"));
            Main.setBack(anasayfa);
            Main.setCenterRoot(anasayfa);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void maclarMenu() {
        try {
            SplitPane maclar = FXMLLoader.load(getClass().getResource("maclar.fxml"));
            Main.setBack(maclar);
            Main.setCenterRoot(maclar);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void haberlerMenu() {
        try {
            ScrollPane haberler = FXMLLoader.load(getClass().getResource("haberler.fxml"));
            Main.setBack(haberler);
            Main.setCenterRoot(haberler);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void gruplarMenu() {
        try {
            SplitPane gruplar = FXMLLoader.load(getClass().getResource("gruplar.fxml"));
            Main.setBack(gruplar);
            Main.setCenterRoot(gruplar);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void cikisMenu() {
        Stage stage;
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Uygulamadan Çık");
        alert.setHeaderText("Uygulamadan çıkış yapacaksınız");
        alert.setContentText("Çıkmak istediğinize emin misinz?");
        BorderPane border = Main.getRoot();

        if(alert.showAndWait().get() == ButtonType.OK){
            stage = (Stage) border.getScene().getWindow();
            System.out.println("You have successfully exited the application.");
            stage.close();
        }
    }

    public void kadrolarMenu(){
        ScrollPane scrollPane = new ScrollPane();
        GridPane gridPane = new GridPane();
        ArrayList<ImageView> flagList = new ArrayList<>();
        Font font = Font.font("System", FontWeight.BOLD, FontPosture.ITALIC, 20);
        int row = 0;
        int column = 0;
        char groupName = 65;

        int i = 0;
        for (Group group : ReadFile.groups){
            for (Country country : group.getCountryList()){
                flagList.add(new ImageView(new Image("D:\\Programming\\Java\\SporMusabakaTakipUygulamasi\\src\\main\\resources\\" +
                        country.getCountryName() + ".png", 125, 100, true, true)));
                flagList.get(i).setCursor(Cursor.HAND);
                flagList.get(i).setOnMouseClicked(e -> {
                    try {
                        Main.setBack(scrollPane);
                        OyuncularController.clickPlayer(country);
                    } catch (IOException ex) {
                        System.out.println("An error occurred");
                        ex.printStackTrace();
                    }
                });
                if(i%4 == 0){
                    Text text = new Text("Group " + groupName);
                    text.setFont(font);
                    gridPane.add(text, 0, row);
                    groupName++;
                }
                gridPane.add(flagList.get(i), column, row+1);
                column++;
                if((i+1)%4==0){
                    row += 2;
                    column = 0;
                }
                i++;
            }
        }
        gridPane.setHgap(25);
        gridPane.setVgap(25);

        gridPane.setPadding(new Insets(10));
        scrollPane.setContent(gridPane);
        Main.setBack(scrollPane);
        Main.setCenterRoot(scrollPane);
    }

    @FXML TextField search;
    public void searchTyped(){
        ScrollPane pane = new ScrollPane();
        GridPane gridPane = new GridPane();

        setHBox("", "");
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(15));
        String searchText = search.getText();
        int column = 0;
        for (Country country : ReadFile.CountryList){
            StringBuilder countryName = new StringBuilder(country.getCountryName());
            for (int i = 1; i < countryName.length()+1; i++){
                if (searchText.equals(countryName.substring(0, i)) || searchText.equals(countryName.substring(0, i).toLowerCase())){

                    HBox box = setHBox(country.getCountryName(), "- ülke");
                    box.setOnMouseClicked(e -> {
                        try {
                            OyuncularController.clickPlayer(country);
                        } catch (IOException ex) {
                            System.out.println("An error occurred");
                            ex.printStackTrace();
                        }
                        search.deleteText(0, searchText.length());
                    });
                    gridPane.add(box, 0, column);
                    column++;
                    break;
                }
            }
            for (Players player : country.getPlayers()) {
                StringBuilder playerName = new StringBuilder(player.getName());
                for (int i = 1; i < playerName.length()+1; i++){
                    if (searchText.equals(playerName.substring(0, i)) || searchText.equals(playerName.substring(0, i).toLowerCase())){
                        HBox box = setHBox(player.getName(), "- oyuncu");
                        box.setOnMouseClicked(e -> {
                            player.makeInfoPane();
                            Main.setCenterRoot(player.getInfoPane());
                            search.deleteText(0, searchText.length());
                        });
                        //System.out.println(country.getCountryName());
                        gridPane.add(box, 0, column);
                        column++;
                        break;
                    }
                }
            }
            StringBuilder coachName = new StringBuilder(country.getCoach().getName());
            for (int i = 1; i < coachName.length()+1; i++) {
                if (searchText.equals(coachName.substring(0, i)) || searchText.equals(coachName.substring(0, i).toLowerCase())) {
                    HBox box = setHBox(country.getCoach().getName(), "- antrenör");
                    box.setOnMouseClicked(e -> {
                        country.getCoach().makeInfoPane();
                        Main.setCenterRoot(country.getCoach().getInfoPane());
                        search.deleteText(0, searchText.length());
                    });
                    gridPane.add(box, 0, column);
                    column++;
                }
            }
        }
        pane.setContent(gridPane);
        Main.setCenterRoot(pane);
    }

    HBox setHBox(String name, String category){
        Font font = Font.font("System", FontWeight.BOLD, 16);
        Font font2 = Font.font("System", FontWeight.LIGHT, FontPosture.ITALIC, 16);
        Label labelName, labelCategory;
        HBox box = new HBox();
        box.setSpacing(7);
        labelName = new Label(name);
        labelName.setFont(font);
        labelName.setCursor(Cursor.HAND);
        labelCategory = new Label(category);
        labelCategory.setFont(font2);
        labelCategory.setCursor(Cursor.HAND);
        box.getChildren().addAll(labelName, labelCategory);
        Label finalLabel = labelName;
        Label finalLabelCategory = labelCategory;
        box.setOnMouseEntered(e -> {
            finalLabel.setStyle("-fx-text-fill: mediumorchid");
            finalLabelCategory.setStyle("-fx-text-fill: mediumorchid");
        });
        box.setOnMouseExited(e -> {
            finalLabel.setStyle("-fx-text-fill: BLACK");
            finalLabelCategory.setStyle("-fx-text-fill: BLACK");
        });
        return box;
    }
}