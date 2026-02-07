package com.food.burger;

import com.food.MenuItem;

import com.food.burger.bun.BurgerBun;
import com.food.burger.patty.BurgerPatty;
import com.food.burger.cheese.BurgerCheese;
import com.food.burger.garnish.BurgerGarnish;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Burger represents a burger in this application.
 * It holds together all the usual components of burger like
 * bun, patty, cheese, and garnishes. For this application,
 * we limit to one bun, one patty, one cheese, and multiple garnishes.
 */

public class Burger implements MenuItem {
	private BurgerBun bun;
	private BurgerPatty patty;
	private BurgerCheese cheese;
	private ArrayList<BurgerGarnish> garnishList;
	private ArrayList<MenuItem> selectionList;
	
	public Burger() {
        this.bun = null;
		this.patty = null;
		this.cheese = null;
		this.garnishList = new ArrayList<BurgerGarnish>();
		this.selectionList = new ArrayList<MenuItem>();
	}

	@SuppressWarnings("exports")
	public BurgerBun getBun() {
		return this.bun;
	}

	public void setBun(@SuppressWarnings("exports") BurgerBun bun) {
		this.bun = bun;
		this.selectionList.add(bun);
	}

	@SuppressWarnings("exports")
	public BurgerPatty getPatty() {
		return this.patty;
	}

	public void setPatty(@SuppressWarnings("exports") BurgerPatty patty) {
		this.patty = patty;
		this.selectionList.add(patty);
	}

	@SuppressWarnings("exports")
	public BurgerCheese getCheese() {
		return this.cheese;
	}

	public void setCheese(@SuppressWarnings("exports") BurgerCheese cheese) {
		this.cheese = cheese;
		this.selectionList.add(cheese);
	}

	@SuppressWarnings("exports")
	public ArrayList<BurgerGarnish> getGarnish() {
		return this.garnishList;
	}

	public void setGarnish(@SuppressWarnings("exports") ArrayList<BurgerGarnish> garnishes) {
		this.garnishList = garnishes;
	}

	/**
	 * addGarnish appends a new garnish to the list of garnishes.
	 * @param garnish is any valid BurgerGarnish
	 */

	public void addGarnish(@SuppressWarnings("exports") BurgerGarnish garnish) {
		this.garnishList.add(garnish);
		this.selectionList.add(garnish);
	}

	/**
	 * Returns the full list of selected components for the burger.
	 * @return selectionList
	 */

	public ArrayList<MenuItem> getSelectionList() {
        return this.selectionList;
    }

	/**
	 * Calculates the total price of the burger
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
	 * describing the burger and its components.
	 */

	@Override
	public String toNiceString() {
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("Burger - $%.2f\n", getPrice()));

		for (MenuItem item : selectionList) {
			sb.append("  • ").append(item.toNiceString()).append("\n");
		}
		return sb.toString();
	}

	public void sortItems() {
		Collections.sort(selectionList);
	}
}