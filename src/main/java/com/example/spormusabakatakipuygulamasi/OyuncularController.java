package com.example.spormusabakatakipuygulamasi;

import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
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

            gridPane.add(playerPane, column, row);
            column++;
            gridPane.setPadding(new Insets(15));
            gridPane.setHgap(15);
            gridPane.setVgap(15);
            playerPane.setCursor(Cursor.HAND);
            playerPane.setOnMouseClicked(e -> {
                try {
                    playerInfoRequest(player, country);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            });
            if((column)%4==0){
                row++;
                column = 0;
            }
        }
        playerPane = new PlayerPane(country.getCoach(), country.getCountryName());
        gridPane.add(playerPane, column, row);
        gridPane.setPadding(new Insets(15));
        gridPane.setHgap(15);
        gridPane.setVgap(15);
        playerPane.setCursor(Cursor.HAND);

        return gridPane;
    }

    public void clickPlayer(Country country) throws IOException {
        ScrollPane scrollPane = new ScrollPane();

        scrollPane.setContent(setGridPane(country));
        BorderPane border = Main.getRoot();
        border.setCenter(scrollPane);
    }

    public static void playerInfoRequest(Players player, Country country) throws IOException {
        PlayerInfoPane pane = new PlayerInfoPane(player, country.getCountryName());
        BorderPane border = Main.getRoot();
        border.setCenter(pane);
    }
}
