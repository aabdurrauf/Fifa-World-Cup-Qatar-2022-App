package com.example.spormusabakatakipuygulamasi;

import javafx.geometry.Orientation;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

import java.util.ArrayList;

public class CoachInfoPane extends PlayerInfoPane{
    Label coach_name, takim, kupalar;
    ImageView coach_photo = new ImageView();
    CoachInfoPane(Coach coach, String country_name){
        try{
            coach_photo.setImage(new Image("D:\\Programming\\Java\\SporMusabakaTakipUygulamasi\\src\\" +
                    "main\\resources\\players\\" + coach.getName() + ".png"));
        }
        catch (Exception e){
            coach_photo.setImage(new Image("D:\\Programming\\Java\\SporMusabakaTakipUygulamasi\\src\\" +
                    "main\\resources\\players\\" + "Lionel Messi" + ".png"));
        }
        AnchorPane leftPane = new AnchorPane();
        leftPane.getChildren().add(coach_photo);
        coach_photo.setFitHeight(400);
        coach_photo.setFitWidth(252);
        coach_photo.setLayoutX(-11);
        coach_photo.setPickOnBounds(true);
        coach_photo.setPreserveRatio(true);

        flag.setImage(new Image("D:\\Programming\\Java\\SporMusabakaTakipUygulamasi\\src\\main\\" +
                "resources\\" + country_name + ".png"));
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
        ArrayList<Label> labels = new ArrayList<Label>();
        labels.add(new Label("Yaş\t\t\t\t: "));
        labels.add(new Label("Takım\t\t\t: "));
        labels.add(new Label("Kazandığı Kupalar\t: "));
        int i = 0;
        for (Label label : labels) {
            label.setFont(fontGrid);
            grid.add(label, 0, i);
            i++;
        }
        takim = new Label(String.valueOf(coach.getTakim()));
        yas = new Label(String.valueOf(coach.getAge()));
        StringBuilder kupaString = new StringBuilder();
        for (String kupa : coach.getKupalar()){
            kupaString.append(kupa + "\n");
            kupalar = new Label(kupaString.toString());
        }

        takim.setFont(fontGrid);
        yas.setFont(fontGrid);
        kupalar.setFont(fontGrid);

        grid.add(yas, 1, 0);
        grid.add(takim, 1, 1);
        grid.add(kupalar, 1, 2);

        grid.setLayoutX(13);
        grid.setLayoutY(126);
        grid.setPrefHeight(226);
        grid.setPrefWidth(307);

        AnchorPane rightPane = new AnchorPane();
        rightPane.getChildren().addAll(flag, coach_name, coach_photo, grid);

        setOrientation(Orientation.HORIZONTAL);
        setDividerPositions(0.383);
        getItems().addAll(leftPane, rightPane);
    }
}
