package com.example.spormusabakatakipuygulamasi;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class MenuController {
    private BorderPane border;

    public void anasayfaMenu(ActionEvent actionEvent) {
        try {
            AnchorPane anasayfa = FXMLLoader.load(getClass().getResource("anasayfa.fxml"));
            border = Main.getRoot();
            border.setCenter(anasayfa);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void maclarMenu(ActionEvent actionEvent) {
        try {
            SplitPane maclar = FXMLLoader.load(getClass().getResource("maclar.fxml"));
            border = Main.getRoot();
            border.setCenter(maclar);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void haberlerMenu(ActionEvent actionEvent) {
        try {
            ScrollPane haberler = FXMLLoader.load(getClass().getResource("haberler.fxml"));
            border = Main.getRoot();
            border.setCenter(haberler);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void gruplarMenu(ActionEvent actionEvent) throws IOException {
        /*
        TableView<Country> countries = new TableView<>();
        ObservableList<Country> data = FXCollections.observableArrayList(ReadFile.groups.get(0).getCountryList()); // this works fine
        countries.setItems(data);

        TableColumn nameColumn = new TableColumn("Team");
        nameColumn.setMinWidth(100);
        nameColumn.setCellValueFactory(new PropertyValueFactory<Country, String>("countryName"));

        TableColumn pointColumn = new TableColumn("Points");
        pointColumn.setMinWidth(100);
        pointColumn.setCellValueFactory(new PropertyValueFactory<Country, String>("points"));

        countries.getColumns().addAll(nameColumn, pointColumn);
        Pane pane = new Pane();
        pane.getChildren().add(countries);*/
        try {
            SplitPane gruplar = FXMLLoader.load(getClass().getResource("gruplar.fxml"));
            border = Main.getRoot();
            border.setCenter(gruplar);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void cikisMenu(ActionEvent actionEvent) {
        Stage stage;
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Uygulamadan Çık");
        alert.setHeaderText("Uygulamadan çıkış yapacaksınız");
        alert.setContentText("Çıkmak istediğinize emin misinz?");


        if(alert.showAndWait().get() == ButtonType.OK){
            stage = (Stage) border.getScene().getWindow();
            System.out.println("You have successfully exited the application.");
            stage.close();
        }
    }

    public void hakkimdaMenu(ActionEvent actionEvent) {
    }

    public void oyuncularMenu(ActionEvent actionEvent) throws FileNotFoundException {
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
                        OyuncularController controller = new OyuncularController();
                        controller.clickPlayer(country);
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

        border = Main.getRoot();
        gridPane.setPadding(new Insets(10));
        scrollPane.setContent(gridPane);

        border.setCenter(scrollPane);
    }

}