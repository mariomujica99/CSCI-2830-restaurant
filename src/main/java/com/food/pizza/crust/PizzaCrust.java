package com.food.pizza.crust;

import com.food.MenuItem;

public abstract class PizzaCrust implements MenuItem {
	protected String ingredient;

	public PizzaCrust() {
		this.ingredient = "";
	}

	public abstract String toString(); 

	public String toNiceString() {
		return "Crust: " + this.toString() + " (" + this.ingredient + ")" + " $" + String.format("%.2f", this.getPrice());
	}
	
	public String getIngredient() {
		return this.ingredient;
	}
	
	public void setIngredient(String ingredient) {
		this.ingredient = ingredient;
	}

	@Override
	public Double getPrice() {
		return 2.00;
	}
}