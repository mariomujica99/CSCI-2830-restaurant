package com.food.burger.garnish;

public class TomatoGarnish extends BurgerGarnish {
	public String toString() {
		return "Tomato Garnish";
	}

	@Override
	public Double getPrice() {
		return .50;
	}
}