package com.food.burger.garnish;

public class OnionRingGarnish extends BurgerGarnish {
	public String toString() {
		return "Onion Rings Garnish";
	}
	
	@Override
	public Double getPrice() {
		return 1.25;
	}
}