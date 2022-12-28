package com.example.spormusabakatakipuygulamasi;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;


public class PlayerPane extends AnchorPane {
    private VBox vbox = new VBox();
    private GridPane gridPane = new GridPane();
    private ImageView flag;
    private ImageView player_photo;
    private Label player_name;

    PlayerPane(Players player, String countryName){
        player_name = new Label(player.getName() + "\n" + player.getPosition());
        flag = new ImageView(new Image("D:\\Programming\\Java\\SporMusabakaTakipUygulamasi\\src\\main\\resources\\" +
                countryName + ".png"));
        flag.setFitHeight(25);
        flag.setFitWidth(35);
        gridPane.add(flag, 0, 0);
        gridPane.add(player_name, 1, 0);
        gridPane.setHgap(10);
        gridPane.setPadding(new Insets(10));

        try{
            player_photo = new ImageView(new Image("D:\\Programming\\Java\\SporMusabakaTakipUygulamasi\\src" +
                    "\\main\\resources\\players\\" + player.getName() + ".png"));
        }
        catch (Exception e){
            player_photo = new ImageView(new Image("D:\\Programming\\Java\\SporMusabakaTakipUygulamasi\\src" +
                    "\\main\\resources\\players\\" + "Lionel Messi" + ".png"));
        }
        player_photo.setFitHeight(250);
        player_photo.setPreserveRatio(true);
        vbox.getChildren().addAll(player_photo, gridPane);
        getChildren().add(vbox);
    }
    PlayerPane(Coach coach, String countryName){
        player_name = new Label(coach.getName() + "\nManager");
        flag = new ImageView(new Image("D:\\Programming\\Java\\SporMusabakaTakipUygulamasi\\src\\main\\resources\\" +
                countryName + ".png"));
        flag.setFitHeight(25);
        flag.setFitWidth(35);
        gridPane.add(flag, 0, 0);
        gridPane.add(player_name, 1, 0);
        gridPane.setHgap(10);
        gridPane.setPadding(new Insets(10));

        try{
            player_photo = new ImageView(new Image("D:\\Programming\\Java\\SporMusabakaTakipUygulamasi\\src" +
                    "\\main\\resources\\players\\" + coach.getName() + ".png"));
        }
        catch (Exception e){
            player_photo = new ImageView(new Image("D:\\Programming\\Java\\SporMusabakaTakipUygulamasi\\src" +
                    "\\main\\resources\\players\\" + "Lionel Messi" + ".png"));
        }
        player_photo.setFitHeight(250);
        player_photo.setPreserveRatio(true);
        vbox.getChildren().addAll(player_photo, gridPane);
        getChildren().add(vbox);
    }
    PlayerPane(){
        super();
    }
}
