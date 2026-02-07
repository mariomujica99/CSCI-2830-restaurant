package com.food;

import com.food.pizza.*;
import com.food.pizza.crust.ThickCrust;
import com.food.pizza.crust.ThinCrust;
import com.food.pizza.sauce.AlfredoSauce;
import com.food.pizza.sauce.TomatoSauce;
import com.food.pizza.topping.*;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;

public class PizzaController {
    @FXML private TextArea receiptList;
    @FXML private Button createPizzaButton;

    @FXML private RadioButton thinCrustRadioButton;
    @FXML private RadioButton thickCrustRadioButton;

    @FXML private RadioButton tomatoSauceRadioButton;
    @FXML private RadioButton alfredoSauceRadioButton;

    @FXML private CheckBox pepperoniToppingRadioButton;
    @FXML private CheckBox sausageToppingRadioButton;
    @FXML private CheckBox pepperToppingRadioButton;
    @FXML private CheckBox mushroomToppingRadioButton;
    @FXML private CheckBox mozzarellaToppingRadioButton;
    @FXML private CheckBox asiagoToppingRadioButton;

    @FXML private RadioButton flourCrustRadioButton;
    @FXML private RadioButton cauliflowerCrustRadioButton;

    private Pizza pizza;

    /**
     * Initialize a new Pizza object,
     * attach event listeners to inputs to validate selections,
     * and disable the createPizzaButton until
     * required selections are made.
     */

    @FXML
    private void initialize() {
        pizza = new Pizza();

        thinCrustRadioButton.setOnAction(e -> validateSelections());
        thickCrustRadioButton.setOnAction(e -> validateSelections());

        flourCrustRadioButton.setOnAction(e -> validateSelections());
        cauliflowerCrustRadioButton.setOnAction(e -> validateSelections());

        tomatoSauceRadioButton.setOnAction(e -> validateSelections());
        alfredoSauceRadioButton.setOnAction(e -> validateSelections());

        pepperoniToppingRadioButton.setOnAction(e -> validateSelections());
        sausageToppingRadioButton.setOnAction(e -> validateSelections());
        pepperToppingRadioButton.setOnAction(e -> validateSelections());
        mushroomToppingRadioButton.setOnAction(e -> validateSelections());
        mozzarellaToppingRadioButton.setOnAction(e -> validateSelections());
        asiagoToppingRadioButton.setOnAction(e -> validateSelections());

        createPizzaButton.setDisable(true);
    }

    /**
     * Enables the createPizzaButton if all necessary selections are made.
     */

    private void validateSelections() {
        boolean crustSelected = thinCrustRadioButton.isSelected() || thickCrustRadioButton.isSelected();
        boolean crustIngredientSelected = flourCrustRadioButton.isSelected() || cauliflowerCrustRadioButton.isSelected();
        boolean sauceSelected = tomatoSauceRadioButton.isSelected() || alfredoSauceRadioButton.isSelected();
        boolean toppingSelected =
                pepperoniToppingRadioButton.isSelected() ||
                sausageToppingRadioButton.isSelected() ||
                pepperToppingRadioButton.isSelected() ||
                mushroomToppingRadioButton.isSelected() ||
                mozzarellaToppingRadioButton.isSelected() ||
                asiagoToppingRadioButton.isSelected();
    
        boolean enable = crustSelected && crustIngredientSelected && sauceSelected && toppingSelected;
        createPizzaButton.setDisable(!enable);
    }
    
    @FXML
    private void selectCrust() {
        if (thinCrustRadioButton.isSelected()) {
            pizza.setCrust(new ThinCrust());
        } else if (thickCrustRadioButton.isSelected()) {
            pizza.setCrust(new ThickCrust());
        }
    }

    @FXML
    private void selectCrustIngredient() {
        if (flourCrustRadioButton.isSelected()) {
            pizza.getCrust().setIngredient("Flour");
        } else if (cauliflowerCrustRadioButton.isSelected()) {
            pizza.getCrust().setIngredient("Cauliflower");
        }
    }

    @FXML
    private void selectSauce() {
        if (tomatoSauceRadioButton.isSelected()) {
            pizza.setSauce(new TomatoSauce());
        } else if (alfredoSauceRadioButton.isSelected()) {
            pizza.setSauce(new AlfredoSauce());
        }
    }

    @FXML
    private void selectToppings() {
        if (pepperoniToppingRadioButton.isSelected()) {
            pizza.addTopping(new PepperoniTopping());
        }
        if (sausageToppingRadioButton.isSelected()) {
            pizza.addTopping(new SausageTopping());
        }
        if (pepperToppingRadioButton.isSelected()) {
            pizza.addTopping(new PepperTopping());
        }
        if (mushroomToppingRadioButton.isSelected()) {
            pizza.addTopping(new MushroomTopping());
        }
        if (mozzarellaToppingRadioButton.isSelected()) {
            pizza.addTopping(new MozzarellaTopping());
        }
        if (asiagoToppingRadioButton.isSelected()) {
            pizza.addTopping(new AsiagoTopping());
        }
    }

    /**
     * Display the pizza's itemized breakdown in the receipt area.
     * @param pizza is any valid Pizza.
     */

    public void displayItems(Pizza pizza) {
        receiptList.appendText(String.format("Pizza - $%.2f\n", pizza.getPrice()));
		for (MenuItem m : pizza.getSelectionList()) {
            receiptList.appendText("  • " + m.toNiceString() + "\n");
		}
	}

    /**
     * addPizzaToCart sorts ingredients for display,
     * shows pizza details in receipt area,
     * and adds the pizza to the receipt,
     * @param event when createPizzaButton is clicked.
     */
    
    @FXML
    private void addPizzaToCart(ActionEvent event) {
        selectCrust();
        selectCrustIngredient();
        selectSauce();
        selectToppings();
        pizza.sortItems();
        displayItems(pizza);
        Receipt receipt = App.getReceipt();
        receipt.addPizza(pizza);

        // Clear selections
        thinCrustRadioButton.setSelected(false);
        thickCrustRadioButton.setSelected(false);
        flourCrustRadioButton.setSelected(false);
        cauliflowerCrustRadioButton.setSelected(false);
        tomatoSauceRadioButton.setSelected(false);
        alfredoSauceRadioButton.setSelected(false);
        pepperoniToppingRadioButton.setSelected(false);
        sausageToppingRadioButton.setSelected(false);
        pepperToppingRadioButton.setSelected(false);
        mushroomToppingRadioButton.setSelected(false);
        mozzarellaToppingRadioButton.setSelected(false);
        asiagoToppingRadioButton.setSelected(false);

        // Start a new pizza object
        pizza = new Pizza();

        // Disable button until next complete pizza is made
        createPizzaButton.setDisable(true);
    }

    @FXML
    private void switchToHomepage() throws IOException {
        App.setRoot("homepage");
    }

    @FXML
    private void switchToReceipt() throws IOException {
        App.setRoot("receipt");
    }
}