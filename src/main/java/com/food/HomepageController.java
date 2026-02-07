package com.food;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;

public class HomepageController {
    @FXML private ImageView logoImage;

    @FXML
    private void initialize() {
        try {
            Image image = new Image(getClass().getResourceAsStream("/icons/icon.png"));
            logoImage.setImage(image);

            // Create circular clip
            Circle clip = new Circle(75, 75, 75);
            logoImage.setClip(clip);
        } catch (Exception e) {
            System.err.println("Could not load logo image: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @FXML
    private void switchToPizza() throws IOException {
        App.setRoot("pizza");
    }

    @FXML
    private void switchToBurger() throws IOException {
        App.setRoot("burger");
    }

    @FXML
    private void switchToReceipt() throws IOException {
        App.setRoot("receipt");
    }
}