package com.food.burger.garnish;

public class BaconGarnish extends BurgerGarnish {
	public String toString() {
		return "Bacon Garnish";
	}

	@Override
	public Double getPrice() {
		return 0.75;
	}
}