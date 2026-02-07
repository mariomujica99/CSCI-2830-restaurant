package com.food;

import com.food.burger.*;
import com.food.burger.bun.*;
import com.food.burger.patty.*;
import com.food.burger.cheese.*;
import com.food.burger.garnish.*;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;

public class BurgerController {
    @FXML private TextArea receiptList;
    @FXML private Button createBurgerButton;

    @FXML private RadioButton seasameSeedBunRadioButton;
    @FXML private RadioButton briocheBunRadioButton;
    @FXML private RadioButton potatoBunRadioButton;

    @FXML private RadioButton beefPattyRadioButton;
    @FXML private RadioButton chickenPattyRadioButton;
    @FXML private RadioButton veggiePattyRadioButton;
    @FXML private RadioButton impossiblePattyRadioButton;

    @FXML private RadioButton americanCheeseRadioButton;
    @FXML private RadioButton swissCheeseRadioButton;
    @FXML private RadioButton cheddarCheeseRadioButton;
    @FXML private RadioButton pepperjackCheeseRadioButton;

    @FXML private CheckBox tomatoGarnishRadioButton;
    @FXML private CheckBox lettuceGarnishRadioButton;
    @FXML private CheckBox pickleGarnishRadioButton;
    @FXML private CheckBox baconGarnishRadioButton;
    @FXML private CheckBox guacamoleGarnishRadioButton;
    @FXML private CheckBox onionringGarnishRadioButton;
    @FXML private CheckBox friedeggGarnishRadioButton;

    private Burger burger;

    /**
     * Initialize a new Burger object,
     * attach event listeners to inputs to validate selections,
     * and disable the createBurgerButton until
     * required selections are made.
     */

    @FXML
    private void initialize() {
        burger = new Burger();

        seasameSeedBunRadioButton.setOnAction(e -> validateSelections());
        briocheBunRadioButton.setOnAction(e -> validateSelections());
        potatoBunRadioButton.setOnAction(e -> validateSelections());

        beefPattyRadioButton.setOnAction(e -> validateSelections());
        chickenPattyRadioButton.setOnAction(e -> validateSelections());
        veggiePattyRadioButton.setOnAction(e -> validateSelections());
        impossiblePattyRadioButton.setOnAction(e -> validateSelections());

        americanCheeseRadioButton.setOnAction(e -> validateSelections());
        swissCheeseRadioButton.setOnAction(e -> validateSelections());
        cheddarCheeseRadioButton.setOnAction(e -> validateSelections());
        pepperjackCheeseRadioButton.setOnAction(e -> validateSelections());

        tomatoGarnishRadioButton.setOnAction(e -> validateSelections());
        lettuceGarnishRadioButton.setOnAction(e -> validateSelections());
        pickleGarnishRadioButton.setOnAction(e -> validateSelections());
        baconGarnishRadioButton.setOnAction(e -> validateSelections());
        guacamoleGarnishRadioButton.setOnAction(e -> validateSelections());
        onionringGarnishRadioButton.setOnAction(e -> validateSelections());
        friedeggGarnishRadioButton.setOnAction(e -> validateSelections());

        createBurgerButton.setDisable(true);
    }

    /**
     * Enables the createBurgerButton if all necessary selections are made.
     */

    private void validateSelections() {
        boolean bunSelected = 
                seasameSeedBunRadioButton.isSelected() ||
                briocheBunRadioButton.isSelected() ||
                potatoBunRadioButton.isSelected();
        boolean pattySelected =
                beefPattyRadioButton.isSelected() ||
                chickenPattyRadioButton.isSelected() ||
                veggiePattyRadioButton.isSelected() ||
                impossiblePattyRadioButton.isSelected();
        boolean cheeseSelected =
                americanCheeseRadioButton.isSelected() ||
                swissCheeseRadioButton.isSelected() ||
                cheddarCheeseRadioButton.isSelected() ||
                pepperjackCheeseRadioButton.isSelected();
        boolean garnishSelected =
                tomatoGarnishRadioButton.isSelected() ||
                lettuceGarnishRadioButton.isSelected() ||
                pickleGarnishRadioButton.isSelected() ||
                baconGarnishRadioButton.isSelected() ||
                guacamoleGarnishRadioButton.isSelected() ||
                onionringGarnishRadioButton.isSelected() ||
                friedeggGarnishRadioButton.isSelected();
    
        boolean enable = bunSelected && pattySelected && cheeseSelected && garnishSelected;
        createBurgerButton.setDisable(!enable);
    }

    @FXML
    private void selectBun() {
        if (seasameSeedBunRadioButton.isSelected()) {
            burger.setBun(new SesameSeedBun());
        } else if (briocheBunRadioButton.isSelected()) {
            burger.setBun(new BriocheBun());
        } else if (potatoBunRadioButton.isSelected()) {
            burger.setBun(new PotatoBun());
        }
    }

    @FXML
    private void selectPatty() {
        if (beefPattyRadioButton.isSelected()) {
            burger.setPatty(new BeefPatty());
        } else if (chickenPattyRadioButton.isSelected()) {
            burger.setPatty(new ChickenPatty());
        } else if (veggiePattyRadioButton.isSelected()) {
            burger.setPatty(new VeggiePatty());
        } else if (impossiblePattyRadioButton.isSelected()) {
            burger.setPatty(new ImpossiblePatty());
        }
    }

    @FXML
    private void selectCheese() {
        if (americanCheeseRadioButton.isSelected()) {
            burger.setCheese(new AmericanCheese());
        } else if (swissCheeseRadioButton.isSelected()) {
            burger.setCheese(new SwissCheese());
        } else if (cheddarCheeseRadioButton.isSelected()) {
            burger.setCheese(new CheddarCheese());
        } else if (pepperjackCheeseRadioButton.isSelected()) {
            burger.setCheese(new PepperjackCheese());
        }
    }

    @FXML
    private void selectGarnishes() {
        if (tomatoGarnishRadioButton.isSelected()) {
            burger.addGarnish(new TomatoGarnish());
        }
        if (lettuceGarnishRadioButton.isSelected()) {
            burger.addGarnish(new LettuceGarnish());
        }
        if (pickleGarnishRadioButton.isSelected()) {
            burger.addGarnish(new PickleGarnish());
        }
        if (baconGarnishRadioButton.isSelected()) {
            burger.addGarnish(new BaconGarnish());
        }
        if (guacamoleGarnishRadioButton.isSelected()) {
            burger.addGarnish(new GuacamoleGarnish());
        }
        if (onionringGarnishRadioButton.isSelected()) {
            burger.addGarnish(new OnionRingGarnish());
        }
        if (friedeggGarnishRadioButton.isSelected()) {
            burger.addGarnish(new FriedEggGarnish());
        }
    }

    /**
     * Display the burger's itemized breakdown in the receipt area.
     * @param burger is any valid Burger.
     */

    public void displayItems(Burger burger) {
        receiptList.appendText(String.format("Burger - $%.2f\n", burger.getPrice()));
		for (MenuItem m : burger.getSelectionList()) {
            receiptList.appendText("  • " + m.toNiceString() + "\n");
		}
	}

    /**
     * addBurgerToCart sorts ingredients for display,
     * shows burger details in receipt area,
     * and adds the burger to the receipt,
     * @param event when createBurgerButton is clicked.
     */
    
    @FXML
    private void addBurgerToCart(ActionEvent event) {
        selectBun();
        selectPatty();
        selectCheese();
        selectGarnishes();
        burger.sortItems();
        displayItems(burger);
        Receipt receipt = App.getReceipt();
        receipt.addBurger(burger);

        // Clear selections
        seasameSeedBunRadioButton.setSelected(false);
        briocheBunRadioButton.setSelected(false);
        potatoBunRadioButton.setSelected(false);

        beefPattyRadioButton.setSelected(false);
        chickenPattyRadioButton.setSelected(false);
        veggiePattyRadioButton.setSelected(false);
        impossiblePattyRadioButton.setSelected(false);

        americanCheeseRadioButton.setSelected(false);
        swissCheeseRadioButton.setSelected(false);
        cheddarCheeseRadioButton.setSelected(false);
        pepperjackCheeseRadioButton.setSelected(false);

        tomatoGarnishRadioButton.setSelected(false);
        lettuceGarnishRadioButton.setSelected(false);
        pickleGarnishRadioButton.setSelected(false);
        baconGarnishRadioButton.setSelected(false);
        guacamoleGarnishRadioButton.setSelected(false);
        onionringGarnishRadioButton.setSelected(false);
        friedeggGarnishRadioButton.setSelected(false);

        // Start a new burger object
        burger = new Burger();

        // Disable button until next complete pizza is made
        createBurgerButton.setDisable(true);
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