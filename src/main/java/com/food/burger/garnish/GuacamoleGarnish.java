package com.food.burger.garnish;

public class GuacamoleGarnish extends BurgerGarnish {
	public String toString() {
		return "Guacamole Garnish";
	}
	
	@Override
	public Double getPrice() {
		return 1.15;
	}
}