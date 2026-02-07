package com.food.burger.garnish;

public class FriedEggGarnish extends BurgerGarnish {
	public String toString() {
		return "Fried Egg Garnish";
	}
	
	@Override
	public Double getPrice() {
		return 1.35;
	}
}