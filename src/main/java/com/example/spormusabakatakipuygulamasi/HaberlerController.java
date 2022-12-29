package com.example.spormusabakatakipuygulamasi;

import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class HaberlerController {
    TextArea textArea = new TextArea();
    BorderPane borderPane = new BorderPane();
    ImageView imageView = new ImageView();

    public void setTextToTextArea(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        StringBuilder textRead = new StringBuilder(scanner.nextLine());
        while (scanner.hasNextLine()) {
            textRead.append("\n");
            textRead.append(scanner.nextLine());
        }
        this.textArea.setText(textRead.toString());
    }

    public void setImageView(Image image){
        this.imageView.setImage(image);
    }

    public void setSceneToRoot(BorderPane borderPane){

        BorderPane border = Main.getRoot();
        border.setCenter(borderPane);
    }

    public void news1() throws FileNotFoundException {
        setImageView(new Image("D:\\Programming\\Java\\SporMusabakaTakipUygulamasi\\src\\main\\" +
                "resources\\messi kupa.jpg", 300, 0, true, false));
        this.borderPane.setTop(this.imageView);

        setTextToTextArea(new File("D:\\Programming\\Java\\SporMusabakaTakipUygulamasi\\src\\main\\" +
                "resources\\news\\news1.txt"));
        this.borderPane.setCenter(this.textArea);

        setSceneToRoot(this.borderPane);
    }

    public void news2() throws FileNotFoundException {
        setImageView(new Image("D:\\Programming\\Java\\SporMusabakaTakipUygulamasi\\src\\main\\" +
                "resources\\mbappe sad.jpg", 300, 0, true, false));
        this.borderPane.setTop(this.imageView);

        setTextToTextArea(new File("D:\\Programming\\Java\\SporMusabakaTakipUygulamasi\\src\\main\\" +
                "resources\\news\\news2.txt"));
        this.borderPane.setCenter(this.textArea);

        setSceneToRoot(this.borderPane);
    }

    public void news3() throws FileNotFoundException {
        setImageView(new Image("D:\\Programming\\Java\\SporMusabakaTakipUygulamasi\\src\\main\\" +
                "resources\\fbl-wc-2022-training-fra-1-5-scaled.jpg", 300, 0, true, false));
        this.borderPane.setTop(this.imageView);

        setTextToTextArea(new File("D:\\Programming\\Java\\SporMusabakaTakipUygulamasi\\src\\main\\" +
                "resources\\news\\news3.txt"));
        this.borderPane.setCenter(this.textArea);

        setSceneToRoot(this.borderPane);
    }

    public void news4() throws FileNotFoundException {
        setImageView(new Image("D:\\Programming\\Java\\SporMusabakaTakipUygulamasi\\src\\main\\resources\\" +
                "https___bvbbuzz.com_wp-content_uploads_getty-images_2017_07_1229076055.jpeg", 300, 0, true, false));
        this.borderPane.setTop(this.imageView);

        setTextToTextArea(new File("D:\\Programming\\Java\\SporMusabakaTakipUygulamasi\\src\\main\\" +
                "resources\\news\\news4.txt"));
        this.borderPane.setCenter(this.textArea);

        setSceneToRoot(this.borderPane);
    }
}
