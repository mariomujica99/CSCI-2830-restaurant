package com.food.burger.garnish;

import com.food.MenuItem;

public abstract class BurgerGarnish implements MenuItem {
	public abstract String toString(); 
	
	public String toNiceString() {
		return "Garnish: " + this.toString() + " $" + String.format("%.2f", this.getPrice());
	}
	@Override
	public Double getPrice() {
		return .45;
	}
}