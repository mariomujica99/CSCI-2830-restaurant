package com.food.burger.bun;

import com.food.MenuItem;

public abstract class BurgerBun implements MenuItem {
	public abstract String toString(); 

	public String toNiceString() {
		return "Bun: " + this.toString() + " $" + String.format("%.2f", this.getPrice());
	}

	@Override
	public Double getPrice() {
		return 1.00;
	}
}