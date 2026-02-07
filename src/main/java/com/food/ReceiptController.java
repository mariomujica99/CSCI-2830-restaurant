package com.food;

import java.io.IOException;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class ReceiptController {
    @FXML private Button homeButton;
    @FXML private Button exitButton;
    @FXML private Label thankYou;
    @FXML private Label enjoy;
    @FXML private TextArea receiptListView;

    /**
     * Disables the exit button until the order is completed,
     * retrieves the current receipt, and displays all menu items
     * in sorted order with their details in the receipt text area,
     * appends the total price at the bottom,
     * and scrolls the TextArea view to the top.
     */

    @FXML
    private void initialize() {
        exitButton.setDisable(true);
        Receipt receipt = App.getReceipt();

        for (MenuItem item : receipt.getAllItemsSorted()) {
            receiptListView.appendText(item.toNiceString() + "\n\n");
        }
        
        double total = receipt.getTotalPrice();
        receiptListView.appendText(String.format("Total: $%.2f", total));

        receiptListView.positionCaret(0);
    }

    @FXML
    private void switchToHomepage() throws IOException {
        App.setRoot("homepage");
    }

    @FXML
    private void exitApplication() {
        Platform.exit();
    }

    /**
     * completeOrder enables the exit button,
     * disables the home button to prevent navigation back,
     * and updates the labels to show thank you message.
     */

    @FXML
    private void completeOrder() {
        exitButton.setDisable(false);
        homeButton.setDisable(true);
        thankYou.setText("Thank You For Stopping At Rio's");
        enjoy.setText("Enjoy!");
    }
}