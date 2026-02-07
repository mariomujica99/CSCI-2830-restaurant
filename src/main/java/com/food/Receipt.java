package com.food;

import java.util.ArrayList;
import java.util.Collections;

import com.food.pizza.Pizza;
import com.food.burger.Burger;

/**
 * Class to represent a customer's receipt,
 * containing lists of pizzas and burgers.
 */

public class Receipt {
    private ArrayList<Pizza> pizzaList;
    private ArrayList<Burger> burgerList;

    public Receipt() {
        this.pizzaList = new ArrayList<>();
        this.burgerList = new ArrayList<>();
    }

    public ArrayList<Pizza> getPizzaList() {
        return this.pizzaList;
    }

    public void setPizzaList(ArrayList<Pizza> pizzas) {
        this.pizzaList = pizzas;
    }

    /**
	 * addPizza appends a new pizza to the receipt.
	 * @param pizza is any valid Pizza.
	 */

    public void addPizza(Pizza pizza) {
        this.pizzaList.add(pizza);
    }

    public ArrayList<Burger> getBurgerList() {
        return this.burgerList;
    }

    public void setBurgerList(ArrayList<Burger> burgers) {
        this.burgerList = burgers;
    }

    /**
	 * addBurger appends a new burger to the receipt.
	 * @param burger is any valid Burger.
	 */

    public void addBurger(Burger burger) {
        this.burgerList.add(burger);
    }

    /**
     * getTotalPrice calculates and returns the total price
     * of all items in the receipt.
     */

    public double getTotalPrice() {
        double total = 0.0;
        for (Pizza pizza : pizzaList) {
            total += pizza.getPrice();
        }
        for (Burger burger : burgerList) {
            total += burger.getPrice();
        }
        return total;
    }    

    public void sortPizzasByPrice() {
        Collections.sort(pizzaList);
    }

    public void sortBurgersByPrice() {
        Collections.sort(burgerList);
    }

    /**
     * getAllItemsSorted combines pizzas and burgers into one list,
     * sorts them by price, and returns the list
     * @return allItems
     */
    
    public ArrayList<MenuItem> getAllItemsSorted() {
        ArrayList<MenuItem> allItems = new ArrayList<>();
        allItems.addAll(pizzaList);
        allItems.addAll(burgerList);
        Collections.sort(allItems);
        return allItems;
    }
}