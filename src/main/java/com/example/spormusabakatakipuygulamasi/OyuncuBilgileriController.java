package com.example.spormusabakatakipuygulamasi;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class OyuncuBilgileriController {
    @FXML ImageView player_photo = new ImageView(), flag = new ImageView();
    @FXML Label player_number;
    @FXML Label player_name = new Label();
    @FXML Label yas = new Label();
    @FXML Label boy = new Label();
    @FXML Label gol = new Label();
    @FXML Label asist = new Label();
    @FXML Label sari = new Label();
    @FXML Label kirmizi = new Label();
    @FXML Label kulup = new Label();
    @FXML Label player_position = new Label();

    public void setPlayerInfo(Players player, Country country) {
        player_name.setText(player.getName());
        player_number = new Label(String.valueOf(player.getShirtNumber()));
        gol = new Label(String.valueOf(player.getGoals()));
        asist = new Label(String.valueOf(player.getAssist()));
        sari = new Label(String.valueOf(player.getYellowCard()));
        kirmizi = new Label(String.valueOf(player.getRedCard()));
        kulup = new Label(String.valueOf(player.getClub()));
        yas = new Label(String.valueOf(player.getAge()));
        boy = new Label(String.valueOf(player.getHeight()));


        if (player.getPosition().equals("ST")){
            player_position.setText("Forward");
        }
        else if(player.getPosition().equals("MF")){
            player_position.setText("Midfielder");
        }
        else if(player.getPosition().equals("DF")){
            player_position.setText("Defender");
        }
        else if(player.getPosition().equals("GK")){
            player_position.setText("Goalkeeper");
        }

        try{
            player_photo.setImage(new Image("D:\\Programming\\Java\\SporMusabakaTakipUygulamasi\\src\\" +
                    "main\\resources\\players\\" + player.getName() + ".png"));
        }
        catch (Exception e){
            player_photo.setImage(new Image("D:\\Programming\\Java\\SporMusabakaTakipUygulamasi\\src\\" +
                    "main\\resources\\players\\" + "Lionel Messi" + ".png"));
        }
        flag.setImage(new Image("D:\\Programming\\Java\\SporMusabakaTakipUygulamasi\\src\\main\\" +
                "resources\\" + country.getCountryName() + ".png"));
    }
}
