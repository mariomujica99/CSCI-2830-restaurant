package com.food.pizza.sauce;

import com.food.MenuItem;

public abstract class PizzaSauce implements MenuItem {
	public abstract String toString(); 
	
	public String toNiceString() {
		return "Sauce: " + this.toString() + " $" + String.format("%.2f", this.getPrice());
	}

	@Override
	public Double getPrice() {
		return 1.15;
	}
}