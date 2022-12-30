package com.example.spormusabakatakipuygulamasi;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.util.Objects;

public class Main extends Application {
    private static Node[] priorPage = new Node[3];
    private static BorderPane root = new BorderPane();
    private static final Image icon = new Image("2022_FIFA_Dünya_Kupası.png");

    public void init() throws Exception {
        // reading the data files
        ReadFile.readFile();
        ReadFile.readMatchFile("group stage", ReadFile.groupMatches,
                "D:\\Programming\\Java\\SporMusabakaTakipUygulamasi\\src\\main\\resources\\matches\\group_stages_matches.txt");
        ReadFile.readMatchFile("knock out stage", ReadFile.knockOutMatches,
                "D:\\Programming\\Java\\SporMusabakaTakipUygulamasi\\src\\main\\resources\\matches\\knock_out_matches.txt");
        for (Group group : ReadFile.groups){
            ReadFile.addGroupMatches(group);
        }
        ReadFile.readPlayerFile();
        ReadFile.readCoachFile();

        super.init();
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent main = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("menu_toolbar.fxml")));
        AnchorPane homeScreen = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("anasayfa.fxml")));
        root.setTop(main);
        root.setCenter(homeScreen);
        //MenuController.setBack(homeScreen);
        setPriorPage(homeScreen);
        setCurrentPage(homeScreen);

        stage.setTitle("2022 FIFA Dünya Kupası");
        stage.getIcons().add(icon);
        stage.setScene(new Scene(root));
        stage.show();

        stage.setOnCloseRequest(event -> {
            event.consume();
            exitApp(stage);
        });
    }

    @Override
    public void stop() throws Exception {
        System.out.println("Application closed");
        super.stop();
    }
    public static BorderPane getRoot() {
        return root;
    }

    public static void setCenterRoot(Node node){
        root.setCenter(node);
    }

    public static void setPriorPage(Node node){
        priorPage[0] = node;
    }

    public static Node getPriorPage(){
        return priorPage[0];
    }
    public static void setCurrentPage(Node node){
        priorPage[1] = node;
    }
    public static Node getCurrentPage(){
        return priorPage[1];
    }
    public static void setNextPage(Node node){
        priorPage[2] = node;
    }
    public static Node getNextPage(){
        return priorPage[2];
    }

    static void setBack(Node node){
        try{
            //System.out.println("(Main.getPriorPage().equals(node)) = " + Objects.equals(Main.getPriorPage(), node));
            if(!(getPriorPage().equals(node))){
                setPriorPage(Main.getCurrentPage());
                setCurrentPage(node);
            }
        }
        catch (NullPointerException e){
            setCurrentPage(node);
        }
    }
    public void exitApp(Stage stage){

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Uygulamadan Çık");
        alert.setHeaderText("Uygulamadan çıkış yapacaksınız");
        alert.setContentText("Çıkmak istediğinize emin misinz?");

        if(alert.showAndWait().get() == ButtonType.OK){
            System.out.println("You have successfully exited the application.");
            stage.close();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}