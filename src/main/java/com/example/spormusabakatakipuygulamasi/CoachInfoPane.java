package com.example.spormusabakatakipuygulamasi;

import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

import java.util.ArrayList;

public class CoachInfoPane extends PlayerInfoPane{
    Label coach_name, uyruk, takim, kupalar;
    ImageView coach_photo = new ImageView();
    VBox vbox = new VBox();
    CoachInfoPane(Coach coach, Country country){
        try{
            coach_photo.setImage(new Image("D:\\Programming\\Java\\SporMusabakaTakipUygulamasi\\src\\" +
                    "main\\resources\\players\\" + coach.getName() + ".png"));
        }
        catch (IllegalArgumentException e){
            coach_photo.setImage(new Image("D:\\Programming\\Java\\SporMusabakaTakipUygulamasi\\src\\" +
                    "main\\resources\\players\\" + "Lionel Messi" + ".png"));
        }
        coach_photo.setFitHeight(400);
        coach_photo.setFitWidth(252);
        coach_photo.setLayoutX(-11);
        coach_photo.setPickOnBounds(true);
        coach_photo.setPreserveRatio(true);
        try {
            flag.setImage(new Image("D:\\Programming\\Java\\SporMusabakaTakipUygulamasi\\src\\main\\" +
                    "resources\\" + country.getCountryName() + ".png"));
        }
        catch (NullPointerException e){
            flag.setImage(new Image("D:\\Programming\\Java\\SporMusabakaTakipUygulamasi\\src\\main\\" +
                    "resources\\" + "white flag" + ".png"));
        }
        flag.setFitHeight(86);
        flag.setFitWidth(147);
        flag.setLayoutX(14);
        flag.setLayoutY(14);
        flag.setPickOnBounds(true);
        flag.setPreserveRatio(true);


        Font fontName = Font.font("System", FontWeight.BOLD, FontPosture.ITALIC, 20);
        coach_name = new Label(coach.getName());
        coach_name.setLayoutX(153);
        coach_name.setLayoutY(50);
        coach_name.setPrefHeight(35);
        coach_name.setPrefWidth(208);
        coach_name.setFont(fontName);

        Font fontGrid = Font.font("System", FontWeight.BOLD, FontPosture.ITALIC, 16);
        GridPane grid = new GridPane();
        ArrayList<Label> labels = new ArrayList<>();
        labels.add(new Label("Yaş\t\t\t: "));
        labels.add(new Label("Uyruk\t\t: "));
        labels.add(new Label("Takım\t\t: "));
        labels.add(new Label("Kupalar\t\t: "));
        int i = 0;
        for (Label label : labels) {
            label.setFont(fontGrid);
            grid.add(label, 0, i);
            i++;
        }
        uyruk = new Label(coach.getNationality());
        takim = new Label(coach.getTakim());
        yas = new Label(String.valueOf(coach.getAge()));
        uyruk.setFont(fontGrid);
        takim.setFont(fontGrid);
        yas.setFont(fontGrid);

        for (int j = 0; j < coach.getKupalar().size(); j++) {
            kupalar = new Label(coach.getKupalar().get(j));
            grid.add(kupalar, 1, j+3);
            kupalar.setFont(fontGrid);
        }
        grid.add(yas, 1, 0);
        grid.add(uyruk, 1, 1);
        grid.add(takim, 1, 2);

        grid.setLayoutX(13);
        grid.setLayoutY(140);
        grid.setPrefHeight(226);
        grid.setPrefWidth(307);

        vbox.getChildren().addAll(flag, coach_name);
        vbox.setPadding(new Insets(15));
        AnchorPane leftPane = new AnchorPane();
        AnchorPane rightPane = new AnchorPane();
        leftPane.getChildren().add(coach_photo);
        rightPane.getChildren().addAll(vbox, grid);

        setOrientation(Orientation.HORIZONTAL);
        setDividerPositions(0.383);
        getItems().addAll(leftPane, rightPane);
    }
    CoachInfoPane(){
        super();
    }
}
