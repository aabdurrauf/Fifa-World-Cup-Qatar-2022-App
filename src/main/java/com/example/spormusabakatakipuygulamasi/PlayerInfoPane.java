package com.example.spormusabakatakipuygulamasi;

import javafx.geometry.Orientation;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

import java.util.ArrayList;

public class PlayerInfoPane extends SplitPane {
    ImageView player_photo = new ImageView(), flag = new ImageView();
    Label player_number = new Label(), player_name = new Label();
    Label yas, boy;
    Label gol, asist;
    Label sari, kirmizi;
    Label kulup, player_position = new Label();

    PlayerInfoPane(Players player, String country_name) {
        try{
            player_photo.setImage(new Image("D:\\Programming\\Java\\SporMusabakaTakipUygulamasi\\src\\" +
                    "main\\resources\\players\\" + player.getName() + ".png"));
        }
        catch (Exception e){
            player_photo.setImage(new Image("D:\\Programming\\Java\\SporMusabakaTakipUygulamasi\\src\\" +
                    "main\\resources\\players\\" + "Lionel Messi" + ".png"));
        }
        AnchorPane leftPane = new AnchorPane();
        leftPane.getChildren().add(player_photo);
        player_photo.setFitHeight(400);
        player_photo.setFitWidth(252);
        player_photo.setLayoutX(-11);
        player_photo.setPickOnBounds(true);
        player_photo.setPreserveRatio(true);

        flag.setImage(new Image("D:\\Programming\\Java\\SporMusabakaTakipUygulamasi\\src\\main\\" +
                "resources\\" + country_name + ".png"));
        flag.setFitHeight(86);
        flag.setFitWidth(147);
        flag.setLayoutX(14);
        flag.setLayoutY(14);
        flag.setPickOnBounds(true);
        flag.setPreserveRatio(true);


        Font fontName = Font.font("System", FontWeight.BOLD, FontPosture.ITALIC, 20);
        player_name = new Label(player.getName());
        player_name.setLayoutX(153);
        player_name.setLayoutY(50);
        player_name.setPrefHeight(35);
        player_name.setPrefWidth(208);
        player_name.setFont(fontName);

        Font fontNumber = Font.font("System", FontWeight.BOLD, FontPosture.ITALIC, 36);
        player_number = new Label(String.valueOf(player.getShirtNumber()));
        player_number.setLayoutX(153);
        player_number.setLayoutY(10);
        player_number.setPrefHeight(54);
        player_number.setPrefWidth(208);
        player_number.setFont(fontNumber);

        switch (player.getPosition()) {
            case "(ST)" -> player_position.setText("Forward");
            case "(MF)" -> player_position.setText("Midfielder");
            case "(DF)" -> player_position.setText("Defender");
            case "(GK)" -> player_position.setText("Goal Keeper");
        }
        Font fontPosition = Font.font("System", FontWeight.LIGHT, FontPosture.ITALIC, 14);
        player_position.setLayoutX(153);
        player_position.setLayoutY(81);
        player_position.setPrefHeight(20);
        player_position.setPrefWidth(147);
        player_position.setFont(fontPosition);

        Font fontGrid = Font.font("System", FontWeight.BOLD, FontPosture.ITALIC, 16);
        GridPane grid = new GridPane();
        ArrayList<Label> labels = new ArrayList<Label>();
        labels.add(new Label("Yaş\t\t\t: "));
        labels.add(new Label("Boy\t\t\t: "));
        labels.add(new Label("Goller\t\t: "));
        labels.add(new Label("Asistler\t\t: "));
        labels.add(new Label("Sarı Kart\t\t: "));
        labels.add(new Label("Kırmızı Kart\t: "));
        labels.add(new Label("Kulüp\t\t: "));
        int i = 0;
        for (Label label : labels) {
            label.setFont(fontGrid);
            grid.add(label, 0, i);
            i++;
        }
        gol = new Label(String.valueOf(player.getGoals()));
        asist = new Label(String.valueOf(player.getAssist()));
        sari = new Label(String.valueOf(player.getYellowCard()));
        kirmizi = new Label(String.valueOf(player.getRedCard()));
        kulup = new Label(String.valueOf(player.getClub()));
        yas = new Label(String.valueOf(player.getAge()));
        boy = new Label(player.getHeight());

        gol.setFont(fontGrid);
        asist.setFont(fontGrid);
        sari.setFont(fontGrid);
        kirmizi.setFont(fontGrid);
        kulup.setFont(fontGrid);
        yas.setFont(fontGrid);
        boy.setFont(fontGrid);

        grid.add(yas, 1, 0);
        grid.add(boy, 1, 1);
        grid.add(gol, 1, 2);
        grid.add(asist, 1, 3);
        grid.add(sari, 1, 4);
        grid.add(kirmizi, 1, 5);
        grid.add(kulup, 1, 6);

        grid.setLayoutX(13);
        grid.setLayoutY(126);
        grid.setPrefHeight(226);
        grid.setPrefWidth(307);

        AnchorPane rightPane = new AnchorPane();
        rightPane.getChildren().addAll(flag, player_number, player_name, player_position, grid);

        setOrientation(Orientation.HORIZONTAL);
        setDividerPositions(0.383);
        getItems().addAll(leftPane, rightPane);
    }
    PlayerInfoPane(){
        super();
    }
}
