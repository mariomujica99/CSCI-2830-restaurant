package com.food.pizza;

import com.food.MenuItem;
import com.food.pizza.crust.PizzaCrust;
import com.food.pizza.sauce.PizzaSauce;
import com.food.pizza.topping.PizzaTopping;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Pizza represents a pizza in this application.
 * It holds together all the usual components of pizza like
 * crust, sauce, and toppings.
 * For our application, we limit to one crust, one sauce, and multiple toppings.
 */

public class Pizza implements MenuItem {
	private PizzaCrust crust;
	private PizzaSauce sauce;
	private ArrayList<PizzaTopping> toppingList;
	private ArrayList<MenuItem> selectionList;
	
	public Pizza() {
        this.crust = null;
		this.sauce = null;
		this.toppingList = new ArrayList<PizzaTopping>();
		this.selectionList = new ArrayList<MenuItem>();
	}

	@SuppressWarnings("exports")
	public PizzaCrust getCrust() {
		return this.crust;
	}

	public void setCrust(@SuppressWarnings("exports") PizzaCrust crust) {
		this.crust = crust;
		this.selectionList.add(crust);
	}

	@SuppressWarnings("exports")
	public PizzaSauce getSauce() {
		return this.sauce;
	}

	public void setSauce(@SuppressWarnings("exports") PizzaSauce sauce) {
		this.sauce = sauce;
		this.selectionList.add(sauce);
	}

	@SuppressWarnings("exports")
	public ArrayList<PizzaTopping> getTopping() {
		return this.toppingList;
	}

	public void setTopping(@SuppressWarnings("exports") ArrayList<PizzaTopping> toppings) {
		this.toppingList = toppings;
	}

	/**
	 * addTopping appends a new topping to the list of toppings.
	 * @param topping is any valid PizzaTopping
	 */

	public void addTopping(@SuppressWarnings("exports") PizzaTopping topping) {
		this.toppingList.add(topping);
		this.selectionList.add(topping);
	}

	/**
	 * Returns the full list of selected components for the pizza.
	 * @return selectionList
	 */

	public ArrayList<MenuItem> getSelectionList() {
        return this.selectionList;
    }

	/**
	 * Calculates the total price of the pizza
	 * by summing all component prices.
	 */
	
	@Override
	public Double getPrice() {
		Double totalPrice = 0.0;
		for (MenuItem m : this.selectionList) {
			totalPrice += m.getPrice();
		}
		return totalPrice;
	}

	/**
	 * Returns a nicely formatted string
	 * describing the pizza and its components.
	 */

	@Override
	public String toNiceString() {
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("Pizza - $%.2f\n", getPrice()));

		for (MenuItem item : selectionList) {
			sb.append("  • ").append(item.toNiceString()).append("\n");
		}
		return sb.toString();
	}

	public void sortItems() {
		Collections.sort(selectionList);
	}
}