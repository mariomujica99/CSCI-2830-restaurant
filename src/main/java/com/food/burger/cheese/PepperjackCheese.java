package com.food.burger.cheese;

public class PepperjackCheese extends BurgerCheese {
	@Override
	public String toString() {
		return "Pepperjack Cheese";
	}

	@Override
	public Double getPrice() {
		return 0.85;
	}
}