package com.food.burger.patty;

import com.food.MenuItem;

public abstract class BurgerPatty implements MenuItem {
	public abstract String toString(); 
	
	public String toNiceString() {
		return "Patty: " + this.toString() + " $" + String.format("%.2f", this.getPrice());
	}

	@Override
	public Double getPrice() {
		return 3.00;
	}
}