package com.food.burger.garnish;

public class PickleGarnish extends BurgerGarnish {
	public String toString() {
		return "Pickles Garnish";
	}

	@Override
	public Double getPrice() {
		return 0.55;
	}
}