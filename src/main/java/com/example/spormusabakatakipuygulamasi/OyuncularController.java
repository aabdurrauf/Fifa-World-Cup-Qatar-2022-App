package com.example.spormusabakatakipuygulamasi;

import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;

import java.io.IOException;

public class OyuncularController {

    public static GridPane setGridPane(Country country){
        GridPane gridPane = new GridPane();
        PlayerPane playerPane;

        int row = 0;
        int column = 0;

        for (Players player : country.getPlayers()){
            playerPane = new PlayerPane(player, country.getCountryName());

            playerPane.setCursor(Cursor.HAND);
            // using FunctionalInterface
            BilgiGoster bilgiGoster =() ->{
                player.makeInfoPane();
                Main.setBack(player.getInfoPane());
                Main.setCenterRoot(player.getInfoPane());
            };
            PlayerPane finalPlayerPane = playerPane;
            playerPane.setOnMouseClicked(e -> {
                finalPlayerPane.useBilgiGoster(bilgiGoster);
            });
            gridPane.add(playerPane, column, row);
            column++;
            /*playerPane.setOnMouseClicked(e -> {
                player.makeInfoPane();
                Main.setCenterRoot(player.getInfoPane());
            });*/
            if((column)%4==0){
                row++;
                column = 0;
            }
        }
        playerPane = new PlayerPane(country.getCoach(), country.getCountryName());
        playerPane.setCursor(Cursor.HAND);
        BilgiGoster bilgiGoster =() ->{ // using FunctionalInterface
            //CoachInfoPane pane = new CoachInfoPane(country.getCoach(), country.getCountryName());
            country.getCoach().makeInfoPane();
            Main.setBack(country.getCoach().getInfoPane());
            Main.setCenterRoot(country.getCoach().getInfoPane());
        };
        PlayerPane finalCoachPane = playerPane;
        playerPane.setOnMouseClicked(e -> finalCoachPane.useBilgiGoster(bilgiGoster));

        gridPane.add(playerPane, column, row);
        gridPane.setPadding(new Insets(15));
        gridPane.setHgap(15);
        gridPane.setVgap(15);

        return gridPane;
    }

    public static void clickPlayer(Country country) throws IOException {
        ScrollPane scrollPane = new ScrollPane();

        scrollPane.setContent(setGridPane(country));
        Main.setBack(scrollPane);
        Main.setCenterRoot(scrollPane);
    }
}
