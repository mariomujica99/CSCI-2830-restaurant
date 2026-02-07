package com.food.burger.cheese;

public class SwissCheese extends BurgerCheese {
	@Override
	public String toString() {
		return "Swiss Cheese";
	}

	@Override
	public Double getPrice() {
		return .75;
	}
}