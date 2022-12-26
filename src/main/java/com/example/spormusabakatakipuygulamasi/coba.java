package com.example.spormusabakatakipuygulamasi;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.io.IOException;
import java.security.cert.PolicyNode;

public class coba extends Application {
    private static BorderPane root = new BorderPane();
    private static Image icon = new Image("2022_FIFA_Dünya_Kupası.png");

    @Override
    public void start(Stage stage) throws Exception {
        ReadFile.readFile();

        TableView<Country> countries = new TableView<>();
        ObservableList<Country> data = FXCollections.observableArrayList(ReadFile.groups.get(0).getCountryList()); // this works fine
        countries.setItems(data);

        TableColumn nameColumn = new TableColumn("Team");
        nameColumn.setMinWidth(200);
        nameColumn.setCellValueFactory(new PropertyValueFactory<Country, String>("countryName"));

        TableColumn pointColumn = new TableColumn("Points");
        pointColumn.setMinWidth(200);
        pointColumn.setCellValueFactory(new PropertyValueFactory<Country, String>("points"));

        countries.getColumns().addAll(nameColumn, pointColumn);
        countries.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        AnchorPane pane = new AnchorPane();
        pane.getChildren().add(countries);

        ////////////////////////////////////////////////////////////////////////////////////////////////

        Parent main = FXMLLoader.load(getClass().getResource("menu_toolbar.fxml"));

        //AnchorPane homeScreen = FXMLLoader.load(getClass().getResource("anasayfa.fxml"));

        root.setTop(main);
        root.setCenter(pane);

        stage.setTitle("2022 FIFA Dünya Kupası");
        stage.getIcons().add(icon);
        stage.setScene(new Scene(root));
        stage.show();

        try {
            SplitPane gruplar = FXMLLoader.load(getClass().getResource("gruplar.fxml"));
            BorderPane border = Main.getRoot();
            border.setCenter(gruplar);
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        launch(args);
    }

    public static BorderPane getRoot() {
        return root;
    }
}
