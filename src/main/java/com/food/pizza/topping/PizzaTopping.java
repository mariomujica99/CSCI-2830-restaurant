package com.food.pizza.topping;

import com.food.MenuItem;

public abstract class PizzaTopping implements MenuItem {
	public abstract String toString(); 
	
	public String toNiceString() {
		return "Topping: " + this.toString() + " $" + String.format("%.2f", this.getPrice());
	}
	
	@Override
	public Double getPrice() {
		return 1.50;
	}
}