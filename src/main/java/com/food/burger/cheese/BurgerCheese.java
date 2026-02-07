package com.food.burger.cheese;

import com.food.MenuItem;

public abstract class BurgerCheese implements MenuItem {
	public abstract String toString(); 
	
	public String toNiceString() {
		return "Cheese Slice: " + this.toString() + " $" + String.format("%.2f", this.getPrice());
	}

	@Override
	public Double getPrice() {
		return 0.50;
	}
}